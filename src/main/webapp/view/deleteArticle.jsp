<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supprimer un article</title>
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
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Supprimer un article</h1>
    <form action="${pageContext.request.contextPath}/deleteArticle.do" method="get">
        ID de l'article à supprimer: <input type="text" name="articleId"><br>
        <input type="submit" value="Supprimer">
    </form>
</div>
</body>
</html>
