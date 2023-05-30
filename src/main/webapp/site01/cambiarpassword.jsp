<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.Usuario"%>
    
<%
	String clave = request.getParameter("txtapassword");
	String nclave = request.getParameter("txtpassword");
	String vnclave = request.getParameter("txtvpassword");

	String sms = null;
	HttpSession sesions = request.getSession();
	String perfils = (String) sesions.getAttribute("usuario");
	System.out.print(perfils);
	Usuario a = new Usuario();
	if(a.verificarPassword(perfils).equals(clave)){
		System.out.print(a.verificarPassword(perfils));
		a.ModificarPassword(perfils, nclave);
		response.sendRedirect("menu.jsp");
		sms = "Actualizacion Correcya";
	}else{
		sms = "La contraseña no coincide con la anterior";
	}
%>
<h3><%out.print(sms);%></h3>
