<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.producto"%>
    
<%
		  int cod = Integer.parseInt(request.getParameter("cod"));
		  int precio = Integer.parseInt(request.getParameter("precio"));
	    %>
<%
			
	    	producto smp = new producto();
	    	boolean actualizado = smp.Nueva_Oferta(cod, precio);
	    	producto mp = new producto();
			mp.ConsultarEditarProductos(cod);
	    	if(actualizado	== true){
	    		response.sendRedirect("InventarioProductos.jsp?id_cat="+mp.getId_cat());
	    	}
	    	
	    	
		%>