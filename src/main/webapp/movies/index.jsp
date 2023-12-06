<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="./../css/output.css"/>
  <title>Moviebox - Review de filmes</title>
</head>
<%--<style type="text/css"> @import url("../css/output.css"); </style>--%>
<body>
<header class="flex justify-between items-center w-full px-4 py-2 bg-slate-900 text-slate-100">
  <h1><span class="font-bold text-xl">Moviebox</span> - Review de filmes</h1>
  <nav>
    <ul class="flex space-x-2">
      <li><a class="px-2 py-1 rounded-md border border-slate-700 text-slate-200" href="?params=criar">+ Adicionar Filme</a></li>
      <li><a class="px-2 py-1 rounded-md border border-slate-700 text-slate-200" href="/assistidos">Assistidos</a></li>
    </ul>
  </nav>
</header>
<section class="mt-4">
  <h2 class="text-lg text-slate-900 font-bold">Lista de filmes</h2>
  <table class="w-full">
    <thead>
    <tr>
      <th class="border bg-slate-900 text-neutral-200 text-left px-2">Nome</th>
      <th class="border bg-slate-900 text-neutral-200 text-left px-2">Gênero</th>
      <th class="border bg-slate-900 text-neutral-200 text-left px-2">Watchlist</th>
      <th class="border bg-slate-900 text-neutral-200 text-left px-2">Ações</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${movies}" var="movie">
      <tr>
        <td class="text-left px-2 py-1 border-b border-slate-700"><c:out value="${movie.name}"/></td>
        <td class="text-left px-2 py-1 border-b border-slate-700"><c:out value="${movie.genresByGenreId.description}"/></td>
        <c:if test="${movie.watchlist == 1}">
          <td class="text-left px-2 py-1 border-b border-slate-700">Sim</td>
        </c:if>
        <c:if test="${movie.watchlist == 0}">
          <td class="text-left px-2 py-1 border-b border-slate-700">Não</td>
        </c:if>
        <td class="text-left px-2 py-1 border-b border-slate-700 gap-2">
          <a class="px-2 py-1 rounded-md text-slate-100 bg-green-500" href="/assistidos?params=criar&id=${movie.id}">Assistir</a>
          <a class="px-2 py-1 rounded-md text-slate-100 bg-yellow-500" href="?params=editar&id=${movie.id}">Editar</a>
          <a class="px-2 py-1 rounded-md text-slate-100 bg-red-500" href="?params=deletar&id=${movie.id}">Excluir</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
</body>
</html>