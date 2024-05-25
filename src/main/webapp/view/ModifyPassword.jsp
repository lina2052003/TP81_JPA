<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier le mot de passe</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light gray background */
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333; /* Dark gray heading */
            text-align: center;
        }
        form {
            background-color: #fff; /* White background for the form */
            width: 300px;
            margin: 0 auto; /* Center the form horizontally */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
            border: 1px solid #ccc; /* Light gray border */
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #008CBA; /* Blue submit button */
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #005f79; /* Darker blue on hover */
        }
    </style>
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
