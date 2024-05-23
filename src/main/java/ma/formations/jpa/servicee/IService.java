package ma.formations.jpa.servicee;
import java.util.List;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public interface IService {

    Boolean checkAccount(String username,String password);
    List<Article> getAllArticle();

    void addArticle(Article article);

    void deleteArticle(Long articleId);

    void updateArticle(Article article);

    Article getArticleById(Long articleId);

    void addUser(User user);

    boolean checkPassword(String username, String oldPassword);

    void updatePassword(String username, String hashedNewPassword);

    String hashPassword(String password);
}