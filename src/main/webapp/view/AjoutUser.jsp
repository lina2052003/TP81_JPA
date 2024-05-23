<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un nouvel utilisateur</title>
</head>
<body>
<h1>Ajouter un nouvel utilisateur</h1>
<form action="${pageContext.request.contextPath}/addUser" method="post">
    Nom d'utilisateur: <input type="text" name="username"><br>
    Mot de passe: <input type="password" name="password"><br>
    <!-- Ajoutez d'autres champs si nécessaire -->
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
