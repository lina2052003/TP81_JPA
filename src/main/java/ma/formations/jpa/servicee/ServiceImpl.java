package ma.formations.jpa.servicee;
import java.util.Base64;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.NoResultException;


import ma.formations.jpa.dao.DaoImplJPA;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.dao.article.ArticleDaoImplJPA;
import ma.formations.jpa.dao.article.IArticleDao;
import ma.formations.jpa.service.model.Article;
import ma.formations.jpa.service.model.User;

public class ServiceImpl implements IService {
    private IDao dao = new DaoImplJPA();
    private IArticleDao daoArticle = new ArticleDaoImplJPA();

    @Override
    public Boolean checkAccount(String username, String password) {
        User u = dao.getUserByUsername(username);
        if (u == null)
            return false;
        return (password.equals(u.getPassword()));
    }

    @Override
    public List<Article> getAllArticle() {
        return daoArticle.findAll();
    }

    @Override
    public void addArticle(Article article) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(article);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void deleteArticle(Long articleId) {
        // Crée une instance de EntityManagerFactory en utilisant l'unité de persistance nommée "unite1".
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
        // Crée un EntityManager à partir de l'EntityManagerFactory.
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Rechercher l'article à supprimer
            Article article = entityManager.find(Article.class, articleId);
            if (article != null) {
                entityManager.remove(article); // Supprimer l'article
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void updateArticle(Article article) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Recherche de l'article à mettre à jour
            Article existingArticle = entityManager.find(Article.class, article.getId());
            if (existingArticle != null) {
                // Mettre à jour les champs de l'article existant avec les valeurs de l'article fourni
                existingArticle.setDescription(article.getDescription());
                existingArticle.setQuantite(article.getQuantite());
                existingArticle.setPrice(article.getPrice());

                // Mettre à jour l'article dans la base de données
                entityManager.merge(existingArticle);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Vous pouvez gérer cette exception de manière appropriée
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public Article getArticleById(Long articleId) {
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager.find(Article.class, articleId);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void addUser(User user) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
            entityManager = entityManagerFactory.createEntityManager(); // Initialisation de entityManager

            transaction = entityManager.getTransaction();
            transaction.begin();

            // Ajouter l'utilisateur à la base de données
            entityManager.persist(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean checkPassword(String username, String oldPassword) {
        EntityManager entityManager = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
            entityManager = entityManagerFactory.createEntityManager();// Initialisation de entityManager

            // Recherche de l'utilisateur par nom d'utilisateur
            User user = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();

            // Vérification du mot de passe
            return user != null && user.getPassword().equals(oldPassword);
        } catch (NoResultException e) {
            return false; // Aucun utilisateur avec ce nom d'utilisateur
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updatePassword(String username, String hashedNewPassword) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unite1");
            entityManager = entityManagerFactory.createEntityManager();// Initialisation de entityManager
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Recherche de l'utilisateur par nom d'utilisateur
            User user = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();

            // Mise à jour du mot de passe
            user.setPassword(hashedNewPassword);
            entityManager.merge(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password.", e);
        }
    }
}










