package ma.formations.jpa.presentation.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    public static String hashPassword(String password) {
        try {
            // Créez une instance de MessageDigest avec l'algorithme SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Appliquez le hachage au mot de passe
            byte[] hash = digest.digest(password.getBytes());

            // Convertissez le hachage en une chaîne hexadécimale
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Gérez l'erreur si l'algorithme de hachage n'est pas disponible
            e.printStackTrace();
            return null;
        }
    }
}

