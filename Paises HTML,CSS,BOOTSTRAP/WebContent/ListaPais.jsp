<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="Modelo.Pais, java.util.ArrayList" %>
    
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

</style>
</head>
<body>

<div class="container-fluid">  
<h2 class="page-header">Lista de Paises</h2>
<hr>
<%
	
	ArrayList<Pais> papais = (ArrayList<Pais>)request.getAttribute("paises");
	for(Pais pais:papais){
%>
    <div class="row">
        <div id="listaP" class="col-md-4">

                <p>
                <b>ID:</b><%= pais.getId() %><br>	
                <b>NOME:</b><%= pais.getNome() %>	<br>
                <b>POPULACAO:</b><%=pais.getPopulacao() %>	<br>
                <b>AREA:</b><%=pais.getArea() %><br>
                </p> 
                    

        </div>

</div>


<% } %>
</div> 
</body>
</html>