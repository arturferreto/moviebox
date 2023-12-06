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
  <h2>Lista de filmes assistidos</h2>
  <table>
    <thead>
      <tr>
        <th>Filme</th>
        <th>Gênero</th>
        <th>Avaliação</th>
        <th>Comentário</th>
        <th>Favorito</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${watchedes}" var="watched">
        <tr>
          <td><c:out value="${watched.moviesByMovieId.name}"/></td>
          <td><c:out value="${watched.moviesByMovieId.genresByGenreId.description}"/></td>
          <td><c:out value="${watched.rating}"/></td>
          <td><c:out value="${watched.remark}"/></td>
          <c:if test="${watched.favorite == 1}">
            <td>Sim</td>
          </c:if>
          <c:if test="${watched.favorite == 0}">
            <td>Não</td>
          </c:if>
            <td>
                <a href="?params=editar&id=${watched.id}">Editar</a>
                <a href="?params=deletar&id=${watched.id}">Excluir</a>
            </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <br><br>

  <a href="//filmes">Visualizar filmes</a>
</body>
</html>
