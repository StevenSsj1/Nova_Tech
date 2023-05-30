<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<title>Datos</title>
</head>
<body>
<form action="cambiarpassword.jsp" method="post">
        <section>
          <label for="nombre">Password anterior:</label>
          <input type="text" name="txtapassword"  required>
        </section>
        <section>
          <label for="cedula">Password nuevo:</label>
          <input type="text" name="txtpassword" required >
        </section>
         <section>
          <label for="cedula">Verifique el password nuevo:</label>
          <input type="text" name="txtvpassword" required >
        </section>
        <input type="submit" value="Enviar datos"/>
      </form>
</body>
</html>