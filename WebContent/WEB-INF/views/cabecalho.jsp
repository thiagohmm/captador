<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Captador de Clientes</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="http://code.jquery.com/jquery-1.9.0.min.js" type="text/javascript"></script>
    <script src="<c:url value="/js/jquery.complexify.js"/>"></script>
    
 
 
 
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
      <a class="navbar-brand" href="<c:url value="/ListaContatos"/>">Captador</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="<c:url value="/ListaContatos"/>">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Inserir <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="adicionaCliente">Inserir Cliente</a></li>
            </ul>
        </li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Procurar <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="/ProcuraCliente"/>">Procurar Cliente</a></li>
            <li><a href="<c:url value="/ProcuraConversa"/>">Procurar Conversa</a></li>
            </ul>
        <li><a href="<c:url value="/AdmUser"/>">Gerenciar Usuário</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
     
        <li><a href="<c:url value="/Logout"/>"><span class="glyphicon glyphicon-user"></span> Sair</a></li>
        </ul>
    </div>
  </div>
</nav>