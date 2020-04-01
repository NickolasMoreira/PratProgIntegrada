<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Modelo.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pais</title>
</head>
<body>
<%Pais pais = (Pais)request.getAttribute("paises");%>

<h1>País cadastrado!</h1><br>
<p>
ID: <%= pais.getId() %><br>
Nome: <%= pais.getNome() %><br>
População: <%= pais.getPopulacao() %><br>
Área: <%= pais.getArea() %>
</p>
</body>
</html>