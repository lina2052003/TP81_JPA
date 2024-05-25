<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un article</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .form-container {
            text-align: center;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h1 {
            margin-bottom: 20px;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }
        .form-container input[type="submit"] {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Modifier un article</h1>
    <form action="${pageContext.request.contextPath}/modifyArticle.do" method="post">
        ID de l'article à modifier: <input type="text" name="articleId"><br>
        Nouvelle description: <input type="text" name="description"><br>
        Nouvelle quantité: <input type="text" name="quantite"><br>
        Nouveau prix: <input type="text" name="price"><br>
        <input type="submit" value="Modifier">
    </form>
</div>
</body>
</html>
