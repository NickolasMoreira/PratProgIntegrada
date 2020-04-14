<%@page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

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
            <b>ID:</b> ${paises.id }<br>
        </div>

        <div class="col-md-3">
            <b>Nome:</b>  ${paises.nome} <br>
        </div>
        <div class="col-md-2">
            <b>População:</b> ${paises.populacao} <br>
        </div>
        <div class="col-md-2">
            <b>Área:</b> ${paises.area}
        </div>
       
			 <div class="col-md-2">
			 <a class="btn btn-primary" href="index.jsp" role="button">Voltar</a>

 				</div>
			 </div>
        

    </div>
</div>
</body>
</html>