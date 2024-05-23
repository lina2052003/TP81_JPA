<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier le mot de passe</title>
</head>
<body>
<h1>Modifier le mot de passe</h1>
<form action="${pageContext.request.contextPath}/modifyPassword" method="post">
    Nom d'utilisateur: <input type="text" name="username"><br>
    Ancien mot de passe: <input type="password" name="oldPassword"><br>
    Nouveau mot de passe: <input type="password" name="newPassword"><br>
    <!-- Ajoutez d'autres champs si nécessaire -->
    <input type="submit" value="Modifier">
</form>
</body>
</html>
