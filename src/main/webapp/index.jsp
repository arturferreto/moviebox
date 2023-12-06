<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./css/output.css"/>
    <title>Moviebox - Review de filmes</title>
</head>
<body>
<header class="flex justify-between items-center w-full px-4 py-2 bg-slate-900 text-slate-100">
    <h1 class="font-bold text-xl"><%= "Movie Box!" %></h1>
    <nav>
        <ul class="flex space-x-2">
            <li><a class="px-2 py-1 rounded-md border border-slate-700 text-slate-200" href="/filmes">Filmes</a></li>
            <li><a class="px-2 py-1 rounded-md border border-slate-700 text-slate-200" href="/assistidos">Assistidos</a></li>
        </ul>
    </nav>
</header>



</body>
</html>