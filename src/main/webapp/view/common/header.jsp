<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <!-- Gestion des articles dropdown menu -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownArticles"
                   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Gestion des articles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownArticles">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/articles.do">Consulter</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/view/ajoutArticle.jsp">Ajouter</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/view/modifyArticle.jsp">Modifier</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/view/deleteArticle.jsp">Supprimer</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout.do">LogOut <span class="sr-only"></span></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <!-- Gestion des Users dropdown menu -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownUsers"
                   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Gestion des Users
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownUsers">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/view/AjoutUser.jsp">Ajouter Un User</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/view/ModifyPassword.jsp">Modifier MDP</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
