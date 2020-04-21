<%@ page import ="Modelo.Pais, java.util.ArrayList" %>
<%@page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="charset" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<title>Listar Paises</title>
<style>
hr{

width: 100%;
height: 2px;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: center;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}


</style>
</head>
<body>

<div class="container-fluid">  
<h2 class="page-header">Lista de Paises</h2>
<hr>
	

    
  
		<table>
		  <tr>	
        <th><b>ID</b></th>
          <th><b>Nome</b></th>
            <th><b>População</b></th>
              <th><b>Área</b></th>
        </tr>
        <c:forEach var="paises" items="${paises}">
        <tr>
        <td>${paises.id}</td>
        <td>${paises.nome}</td>
        <td>${paises.populacao}</td>
        <td>${paises.area}</td>
        </tr>
		</c:forEach>
		</table>
		
</body>
</html>