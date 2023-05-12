 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.producto.negocio.*"
	session="true" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="consulta.jsp">Ver Productos</a>
        <a href="registrar.jsp">Registrar Productos</a>
        </nav>
    <hr>

    <%
String usuario;
HttpSession sesion = request.getSession();
 if (sesion.getAttribute("usuario") == null) //Se verifica si existe la variable
 {
 %>
 <jsp:forward page="login.jsp">
 <jsp:param name="error" value="Debe registrarse en el sistema."/>
 </jsp:forward>
 <%
 }
 else
 {
 usuario=(String)sesion.getAttribute("usuario"); //Se devuelve los valores de atributos
 int perfil=(Integer)sesion.getAttribute("perfil");
 %>
 
<h1 style="color: white;">Sitio Privado de Productos</h1>
<h4 style="color: white;">Bienvenido
<%
out.println(usuario);

%>
</h4>
<%
Pagina com = new Pagina();
String menu = com.mostrarMenu(perfil);
out.print(menu);
}%>

</body>
</html>
