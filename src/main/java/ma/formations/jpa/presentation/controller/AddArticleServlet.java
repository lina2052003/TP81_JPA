package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.servicee.IService;
import ma.formations.jpa.servicee.ServiceImpl;
import ma.formations.jpa.service.model.Article;

@WebServlet("/addArticle.do")
public class AddArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String description = request.getParameter("description");
        double quantite = Double.parseDouble(request.getParameter("quantite"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Créer un nouvel article
        Article article = new Article();
        article.setDescription(description);
        article.setQuantite(quantite);
        article.setPrice(price);

        // Ajouter l'article à la base de données
        service.addArticle(article);

        // Rediriger vers la page d'affichage des articles après ajout
        response.sendRedirect(request.getContextPath() + "/articles.do");
    }
}