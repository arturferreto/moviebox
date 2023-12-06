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
    <h1>Avaliar filme</h1>
    <form action="?params=atualizar&id=${watched.id}&movieId=${watched.movieId}" method="GET">
        <label for="name">Filme</label>
        <input type="text" name="name" id="name" value="${watched.moviesByMovieId.name}" disabled> <br><br>

        <label for="rating">Avaliação</label>
        <label><input type="radio" name="rating" value="1" <c:if test="${watched.rating == 1}">checked</c:if>>1</label>
        <label><input type="radio" name="rating" value="2" <c:if test="${watched.rating == 2}">checked</c:if>>2</label>
        <label><input type="radio" name="rating" value="3" <c:if test="${watched.rating == 3}">checked</c:if>>3</label>
        <label><input type="radio" name="rating" value="4" <c:if test="${watched.rating == 4}">checked</c:if>>4</label>
        <label><input type="radio" name="rating" value="5" <c:if test="${watched.rating == 5}">checked</c:if>>5</label>

        <br><br>

        <label for="remark">Comentário</label> <br>
        <textarea name="remark" id="remark" cols="30" rows="3">${watched.remark}</textarea>

        <br><br>

        <input type="checkbox" id="favorite" name="favorite" value="favorite" <c:if test="${watched.favorite == 1}">checked</c:if>>
        <label for="favorite">Adicionar aos favoritos</label> <br><br>

        <input type="submit" value="EDITAR">
        <input type="hidden" name="params" value="atualizar">
        <input type="hidden" name="id" value="${watched.id}">
        <input type="hidden" name="movieId" value="${watched.movieId}">
    </form>

    <br>

    <a href="?params=buscar-todos">Voltar</a>
</body>
</html>
