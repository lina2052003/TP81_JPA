<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un nouvel article</title>
</head>
<body>
<h1>Ajouter un nouvel article</h1>
<form action="${pageContext.request.contextPath}/addArticle.do" method="post">
    Description: <input type="text" name="description"><br>
    Quantité: <input type="text" name="quantite"><br>
    Prix: <input type="text" name="price"><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
