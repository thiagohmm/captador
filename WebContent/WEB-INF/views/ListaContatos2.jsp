<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Captador de Clientes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Captador</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Inserir <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Inserir Cliente</a></li>
            <li><a href="#">Inserir Conversa</a></li>
            </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container">
  <h3>Lista Cliente</h3>
  <p>Lista os clientes que já estão com conversas inseridas com verde clientes que não tem conversas inseridas com vermelho.
  
  <jsp:useBean id="dao" class="br.com.marquez.thiago.DBMysql.ClienteDao"/>
<table class="table" style="overflow-y:scroll ">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone01</th>
        <th>Data</th>
         <th>Empresa</th>
      </tr>
    </thead>
    <tbody>
    
      	<c:forEach var="cliente" items="${dao.ListaComConversa()}">
      	<tr class="success">
      	<td>${cliente.nomeCliente}</td>
      	<c:if test="${not empty cliente.emailCliente}">
        <td>${cliente.emailCliente}</td>
      </c:if>
      <c:if test="${empty cliente.emailCliente}">
        <td>Email não Informado</td>
      </c:if>
      	<td>${cliente.tel01Cliente}</td>
         <td>${cliente.niverCliente}</td>
         <td>${cliente.empresaCliente}</td>
      	</c:forEach>
      </tr>
      
      <c:forEach var="cliente" items="${dao.ListaSemConversa()}">
      <tr class="danger">
        <td>${cliente.nomeCliente}</td>
        <td>${cliente.emailCliente}</td>
        <td>${cliente.tel01Cliente}</td>
         <td>${cliente.niverCliente}</td>
         <td>${cliente.empresaCliente}</td>
		</c:forEach>      
      </tr>
      
    </tbody>
  </table>



</div>

</body>
</html>