<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="cabecalho.jsp" />
<div class="container">
  <h3>Altera Cliente</h3>
  <p>Página para alterar os clientes
 
  <form action="<c:url value="/AlteraCliente"/>" method="post">
 <div class="form-group">
 <c:forEach items="${Clientes}" var="cliente" >
 <input type="hidden" class="form-control" id="idcliente" placeholder="id Cliente" name="idCliente" value="${cliente.idCliente}">
  <label for="nome">Nome:</label>
  <input type="text" class="form-control" id="nome" placeholder="Nome do Cliente" name="nomeCliente" value="${cliente.nomeCliente}" required>

<br />
  <label for="email">Email:</label>
  <input type="email" class="form-control" id="email" placeholder="Email" name="emailCliente" value="${cliente.emailCliente}">

<br />
<label for="email">Empresa:</label>
 <input type="text" class="form-control" id="email" placeholder="Empresa"  name="empresaCliente" value="${cliente.empresaCliente}" required>

<br />
<div class="col-xs-4 row">

	<label for="tel01">Telefone 01:</label>
    <input type="text" class="form-control" placeholder=""  name="tel01Cliente" value="${cliente.tel01Cliente}">
    
  <select class="custom-select" name="tipotel01">
  <option selected value="${cliente.tipotel01}">${cliente.tipotel01}</option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trablaho">Trabalho</option>
</select>
    <br />
     <br />
    <label for="tel02">Telefone 02:</label>
    <input type="text" class="form-control" placeholder=""  name="tel02Cliente" value="${cliente.tel02Cliente}">
     <select class="custom-select" name="tipotel02">
  <option selected value="${cliente.tipotel02}">${cliente.tipotel02}</option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trablaho">Trabalho</option>
</select>
     
    <br />
     <br />
	
	<label for="tel03">Telefone 03:</label>
    <input type="text" class="form-control" placeholder=""  name="tel03Cliente" value="${cliente.tel03Cliente}">
  <select class="custom-select" name="tipotel03">
  <option selected value="${cliente.tipotel03}">${cliente.tipotel03}</option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trabalho">Trabalho</option>
</select>
  
    <br />
     <br />


</div>
  
<div class="col-xs-2">
 <label for="tel03">Aniversário:</label>
    <input type="date" class="form-control" placeholder=""  name="niverCliente" id="datepicker" value="<fmt:formatDate value="${cliente.niverCliente.time}" pattern="yyyy-MM-dd" />" required/>
   
        
</c:forEach>
 

<br />
</div>

 

</div>
<button type="submit" class="btn btn-primary btn-block" >Altera Cliente</button>
</form>
<script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});
  } );
  </script>
</body>
</html>