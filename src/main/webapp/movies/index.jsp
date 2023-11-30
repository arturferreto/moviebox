<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
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
<ul>
  <c:forEach items="${movies}" var="movie">
    <c:out value="${movie.name}"/> </td>
  </c:forEach>
</ul>
</body>
</html>
