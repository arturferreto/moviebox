<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Moviebox - Review de filmes</title>
</head>
<body>
    <h1>Editar um filme</h1>
    <form action="?params=atualizar&id=${movie.id}" method="GET">
        <label for="name">Nome</label>
        <input type="text" name="name" id="name" value="${movie.name}"> <br><br>

        <label for="genreId">Gênero</label>
        <select name="genreId" id="genreId">
            <c:forEach items="${genres}" var="genre">
                <option value="${genre.id}" <c:if test="${genre.id == movie.genreId}">selected</c:if>>${genre.description}</option>
            </c:forEach>
        </select> <br><br>

        <input type="checkbox" id="watchlist" name="watchlist" value="watchlist" <c:if test="${movie.watchlist == 1}">checked</c:if>>
        <label for="watchlist">Adicionar na Watchlist</label> <br><br>

        <input type="submit" value="EDITAR">
        <input type="hidden" name="params" value="atualizar">
        <input type="hidden" name="id" value="${movie.id}">
    </form>

    <br>

    <a href="?params=buscar-todos">Voltar</a>
</body>
</html>
