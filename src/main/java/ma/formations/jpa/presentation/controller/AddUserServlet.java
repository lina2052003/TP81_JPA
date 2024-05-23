package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.service.model.User;
import ma.formations.jpa.servicee.IService;
import ma.formations.jpa.servicee.ServiceImpl;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService userService;
    private IService service=new ServiceImpl();

    public void init() throws ServletException {
        super.init();

        userService = new ServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashedpassword = service.hashPassword(password);
        // Créer un nouvel utilisateur avec les données fournies
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(hashedpassword);

// Ajouter un attribut à la requête pour indiquer le succès
        request.setAttribute("successMessage", "L'utilisateur a été ajouté avec succès.");

        // Ajouter le nouvel utilisateur
        userService.addUser(newUser);

        // Rediriger vers une autre page ou afficher un message de succès
        response.sendRedirect(request.getContextPath() + "/articles.do");
    }
}

