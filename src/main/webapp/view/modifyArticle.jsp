<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un article</title>
</head>
<body>
<h1>Modifier un article</h1>
<form action="${pageContext.request.contextPath}/modifyArticle.do" method="post">
    ID de l'article à modifier: <input type="text" name="articleId"><br>
    Nouvelle description: <input type="text" name="description"><br>
    Nouvelle quantité: <input type="text" name="quantite"><br>
    Nouveau prix: <input type="text" name="price"><br>
    <input type="submit" value="Modifier">
</form>
</body>
</html>
