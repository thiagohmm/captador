<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

  <head>
    <script>
      function loadModalWindow() {
         // open your window here
    	  window.alert("Usuário já Existe");
    	  window.location = "<c:url value="/AdmUser"/>";
      }
  </script>
  </head>

  <body onload="loadModalWindow()">
   
  </body>
</html>