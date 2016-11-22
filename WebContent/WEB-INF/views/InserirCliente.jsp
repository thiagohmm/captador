<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Inserir Cliente</h3>
  <p>Página para inserir os clientes
 
  <form action="InserirCliente" method="post">
 <div class="form-group">
  <label for="nome">Nome:</label>
  <input type="text" class="form-control" id="nome" placeholder="Nome do Cliente" name="nomeCliente" required>

<br />
  <label for="email">Email:</label>
  <input type="email" class="form-control" id="email" placeholder="Email" name="emailCliente">

<br />
<label for="email">Empresa:</label>
 <input type="text" class="form-control" id="email" placeholder="Empresa"  name="empresaCliente" required>

<br />
<div class="col-xs-4 row">

	<label for="tel01">Telefone 01:</label>
    <input type="tel" class="form-control" placeholder=""  name="tel01Cliente">
    
  <select class="custom-select" name="tipotel01">
  <option selected></option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trablaho">Trabalho</option>
</select>
    <br />
     <br />
    <label for="tel02">Telefone 02:</label>
    <input type="tel" class="form-control" placeholder=""  name="tel02Cliente">
     <select class="custom-select" name="tipotel02">
  <option selected></option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trablaho">Trabalho</option>
</select>
     
    <br />
     <br />
	
	<label for="tel03">Telefone 03:</label>
    <input type="tel" class="form-control" placeholder=""  name="tel03Cliente">
  <select class="custom-select" name="tipotel03">
  <option selected></option>
  <option value="residencial">Residencial</option>
  <option value="celular">Celular</option>
  <option value="trablaho">Trabalho</option>
</select>
  
    <br />
     <br />


</div>
  
<div class="col-xs-2">
 <label for="tel03">Aniversário:</label>
    <input type="date" class="form-control" placeholder=""  name="niverCliente" required id="datepicker">
   
        

 

<br />
</div>

 

</div>
<button type="submit" class="btn btn-primary btn-block" >Salva Cliente</button>
</form>

 <script>
  $( function() {
    $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd'});
  } );
  </script>
</body>
</html>