<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Procura Cliente Cliente</h3>
  <p>Página para procurar clientes
  <br>
 <br>
 <br>

 
 <form action="SelectCliente" method="post">
<input type="radio"  name="select" value="nome" checked>Nome do Cliente
<input type="radio"  name="select" value="empresa">Empresa Cliente
<input type="text"   name="busca" size="31" maxlength="255" value="">
<input type="submit" value="Pesquisar">

</form>

</body>
</html>