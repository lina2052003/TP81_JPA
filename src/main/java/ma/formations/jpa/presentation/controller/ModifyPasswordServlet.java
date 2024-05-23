package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.servicee.ServiceImpl;
import ma.formations.jpa.servicee.IService;

@WebServlet("/modifyPassword")
public class ModifyPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService userService;

    public void init() throws ServletException {
        super.init();
        userService = new ServiceImpl(); // Ou utilisez une autre méthode pour injecter votre service
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        // Hasher le nouveau mot de passe
        String hashedOldPassword = userService.hashPassword(oldPassword);
        String hashedNewPassword = userService.hashPassword(newPassword);
        // Vérifiez le mot de passe actuel de l'utilisateur
        boolean passwordCorrect = userService.checkPassword(username, hashedOldPassword);
        if (!passwordCorrect) {
            // Gérer le cas où le mot de passe actuel est incorrect
            // Par exemple, rediriger vers une page d'erreur ou afficher un message d'erreur
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return;
        }

        try {
            // Le mot de passe actuel est correct, donc mettez à jour le mot de passe
            userService.updatePassword(username, hashedNewPassword);
            // Rediriger vers une page de succès ou afficher un message de succès
            response.sendRedirect(request.getContextPath() + "/articles.do");
        } catch (Exception e) {
            // Gérer l'exception (par exemple, afficher un message d'erreur ou journaliser l'erreur)
            e.printStackTrace(); // ou autre traitement approprié
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
