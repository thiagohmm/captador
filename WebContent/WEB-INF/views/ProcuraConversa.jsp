<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />
 
  
<div class="container">
  <h3>Procura Conversa</h3>
  <p>Página para procurar conversas
  <br>
 <br>
 <br>

 
 <form action="SelectConversa" method="post">

 
 
 <select name="escolhecontato">
 <option value="nada"></option>
  <c:forEach items="${Clientes}" var="cliente" >
 <option value="${cliente.idCliente}">${cliente.nomeCliente}</option>
 </c:forEach>
  </select>
 
<input type="text"   name="busca" size="31" maxlength="255" value="">
<input type="submit" value="Pesquisar">
<input type="radio"  name="select" value="texto" checked>Texto
<input type="radio"  name="select" value="assunto">Assunto


</form>

</body>
</html>