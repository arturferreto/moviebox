<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <h1>Moviebox - Review de filmes</h1>
  <h2>Lista de filmes</h2>
  <table>
    <thead>
      <tr>
        <th>Nome</th>
        <th>Gênero</th>
        <th>Watchlist</th>
        <th>Ações</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${movies}" var="movie">
        <tr>
          <td><c:out value="${movie.name}"/></td>
          <td><c:out value="${movie.genresByGenreId.description}"/></td>
          <c:if test="${movie.watchlist == 1}">
            <td>Sim</td>
          </c:if>
          <c:if test="${movie.watchlist == 0}">
            <td>Não</td>
          </c:if>
            <td>
                <a href="?params=editar&id=${movie.id}">Editar</a>
                <a href="?params=deletar&id=${movie.id}">Excluir</a>
            </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <br>

  <a href="?params=criar">Adicionar</a>
</body>
</html>
