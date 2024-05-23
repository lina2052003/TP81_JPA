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

@WebServlet("/modifyArticle.do")
public class ModifyArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        Long articleId = Long.parseLong(request.getParameter("articleId"));
        String description = request.getParameter("description");
        double quantite = Double.parseDouble(request.getParameter("quantite"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Récupérer l'article existant à modifier
        Article article = service.getArticleById(articleId);
        if (article != null) {
            // Mettre à jour les propriétés de l'article
            article.setDescription(description);
            article.setQuantite(quantite);
            article.setPrice(price);

            // Mettre à jour l'article dans la base de données
            service.updateArticle(article);
        }

        // Rediriger vers la page d'affichage des articles après modification
        response.sendRedirect(request.getContextPath() + "/articles.do");
    }
}
