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
    <link rel="stylesheet" href="./../css/output.css"/>
    <title>Moviebox - Review de filmes</title>
</head>
<body>
<header class="flex justify-between items-center w-full px-4 py-2 bg-slate-900 text-slate-100">
    <h1><span class="font-bold text-xl">Moviebox</span> - Editar um filme</h1>
    <nav>
        <ul class="flex space-x-2">
            <li>
                <a class="px-2 py-1 rounded-md border border-slate-700 text-slate-200" href="?params=buscar-todos">Voltar</a>
            </li>
        </ul>
    </nav>
</header>
<section class="grid sm:grid-cols-3 gap-y-5">
    <div class="sm:mb-0 mb-3">
        <h2 class="text-2xl font-bold">Filmes</h2>
        <p id="title" class="text-sm">Edição de filmes</p>
    </div>
    <div class="sm:col-span-2 border p-4 bg-slate-100 rounded-lg">
        <form action="?params=atualizar&id=${movie.id}" method="GET" class="flex flex-col gap-2">
            <div class="text-sm">
                <label class="block" for="name">Nome</label>
                <input class="px-3 py-2 rounded border w-full" type="text" name="name" id="name" value="${movie.name}">
            </div>
            <div class="text-sm">
                <label class="block" for="genreId">Gênero</label>
                <select class="px-3 py-2 rounded border w-full" name="genreId" id="genreId">
                    <c:forEach items="${genres}" var="genre">
                        <option value="${genre.id}"
                                <c:if test="${genre.id == movie.genreId}">selected</c:if>>${genre.description}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="text-sm">
                <input type="checkbox" id="watchlist" name="watchlist" value="watchlist"
                       <c:if test="${movie.watchlist == 1}">checked</c:if>>
                <label for="watchlist">Adicionar na Watchlist</label>
            </div>
            <div class="mt-2 flex justify-end">
                <input class="px-2 py-1 bg-green-700 text-slate-50 rounded" type="submit" value="EDITAR">
                <input type="hidden" name="params" value="atualizar">
                <input type="hidden" name="id" value="${movie.id}">
            </div>
        </form>
    </div>
</section>
</body>
</html>
