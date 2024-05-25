<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un nouvel utilisateur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Background color */
            color: #333; /* Text color */
        }
        h1 {
            color: #007bff; /* Heading color */
        }
        form {
            background-color: #fff; /* Form background color */
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
            border: 1px solid #ccc; /* Border color */
            border-radius: 5px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #007bff; /* Highlight color on focus */
        }
        input[type="submit"] {
            background-color: #007bff; /* Button background color */
            color: #fff; /* Button text color */
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3; /* Button background color on hover */
        }
    </style>
</head>
<body>
<h1>Ajouter un nouvel utilisateur</h1>
<form action="${pageContext.request.contextPath}/addUser" method="post">
    Nom d'utilisateur: <input type="text" name="username"><br>
    Mot de passe: <input type="password" name="password"><br>
    <!-- Add more fields if necessary -->
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
