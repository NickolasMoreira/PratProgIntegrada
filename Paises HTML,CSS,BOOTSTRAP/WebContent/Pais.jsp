<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Modelo.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="charset" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>Pais</title>

<style>
hr{

width: 100%;
height: 4px;
}

</style>
</head>
<body>
<%Pais pais = (Pais)request.getAttribute("paises");%>


<div class="container">

<h1 class="page-header">País cadastrado!</h1><br>
<hr>
    <div class="row">
        <div class="col-md-2">
            <b>ID:</b> <%= pais.getId() %><br>
        </div>

        <div class="col-md-3">
            <b>Nome:</b> <%= pais.getNome() %><br>
        </div>
        <div class="col-md-2">
            <b>População:</b> <%= pais.getPopulacao() %><br>
        </div>
        <div class="col-md-2">
            <b>Área:</b> <%= pais.getArea() %>
        </div>

    </div>
<!-- <p>
<b>ID:</b> <%= pais.getId() %><br>
<b>Nome:</b> <%= pais.getNome() %><br>
<b>População:</b> <%= pais.getPopulacao() %><br>
<b>Área:</b> <%= pais.getArea() %>
</p> -->
</div>
</body>
</html>