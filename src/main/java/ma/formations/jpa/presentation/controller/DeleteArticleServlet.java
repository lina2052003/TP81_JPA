package ma.formations.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.servicee.IService;
import ma.formations.jpa.servicee.ServiceImpl;

@WebServlet("/deleteArticle.do")
public class DeleteArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String articleIdStr = request.getParameter("articleId");

            if (articleIdStr != null && !articleIdStr.isEmpty()) {
                try {
                    Long articleId = Long.parseLong(articleIdStr);

                    // Supprimer l'article de la base de données
                    service.deleteArticle(articleId);

                    // Rediriger vers la page d'affichage des articles après suppression
                    response.sendRedirect(request.getContextPath() + "/articles.do");
                } catch (NumberFormatException e) {
                    // Gérer l'erreur de conversion de chaîne en nombre
                    // Vous pouvez rediriger vers une page d'erreur ou afficher un message d'erreur
                    e.printStackTrace();
                }
            } else {
                // Gérer le cas où aucun ID d'article n'est fourni dans la requête
                // Vous pouvez rediriger vers une page d'erreur ou afficher un message d'erreur
                System.out.println("ID d'article non fourni");
            }
        }
        }



