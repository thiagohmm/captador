<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


 <c:import url="cabecalho.jsp" />

  
<div class="container">
  <h3>Inseri Conversa</h3>
  <p>Página para inserir os conversa de clientes
 
  <form action="<c:url value="/InsertConversa"/>" method="post">
  
 <div class="form-group">
 <c:forEach items="${Clientes}" var="cliente" >
  <input type="hidden" class="form-control" id="fKCliente" placeholder="" name="fKCliente" value="${cliente.idCliente}" required>
   <label for="nome">Assunto:</label>
  <input type="text" class="form-control" id="assunto" placeholder="Assunto" name="conversaAssunto" required>

<br />
  <div class="form-group">
  <label for="comment">Conversa:</label>
  <textarea class="form-control" rows="5" id="comment"  placeholder="Texto" name="conversaTexto" required></textarea>
</div>
<br />

<div class="col-xs-2">
 <label for="DataConversa">Data Convesa:</label>
    <input type="date" class="form-control" placeholder=""  name="conversaData" id="datepicker" required>
   
        

 

<br />
</div>

</c:forEach>
 

</div>
<button type="submit" class="btn btn-primary btn-block" >Salva Cliente</button>
</form>
</body>
</html>