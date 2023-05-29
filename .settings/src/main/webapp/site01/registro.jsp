<%@page import="com.producto.negocio.validarion_id"
%>
<%
String nombre = request.getParameter("txtnombre");
String cedula = request.getParameter("txtcedula");
String estado_civil = request.getParameter("txtestado-civil");
String residencia = request.getParameter("rdResidencia");
String img = request.getParameter("imgfoto");
String fecha = request.getParameter("txtfecha-nacimiento");
String color = request.getParameter("txtcolor-favorito");

//out.println(String.format("Su nombre es: %10s", nombre));
out.print("Su nombre es: " + nombre + "</br>");
out.print("Cedula: " + cedula + "</br>");
out.print("Fecha de Nacimiento: " + fecha + "</br>");
out.print("Estado Civil: " + estado_civil + "</br>");
out.print("Residencia: " + residencia + "</br>" );
out.print("Foto: " + img +"</br>" );
out.print("Color favorito: " + color + "</br>");
%>

<span>
	<br>
	<font color=<%=color%>> Este es tu color favorito</font>
	<br>
	Su provincia es: <%= com.producto.negocio.validarion_id.idProvince(cedula)%>
	<br>
	Su edad es: <%= com.producto.negocio.validarion_id.agePerson(fecha) %>
</span>