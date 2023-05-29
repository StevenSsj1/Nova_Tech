<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.producto"%>
<%
			int cods = Integer.parseInt(request.getParameter("editarcod"));
	    	String Descripcion = request.getParameter("txtNombre");
	    	int precio = Integer.parseInt(request.getParameter("txtPrecio"));
	    	int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
			int categoria = Integer.parseInt(request.getParameter("id_cat"));
			System.out.print(categoria);
	    	producto smp = new producto(Descripcion,cods,precio,cantidad);
	    	boolean actualizado = smp.ModificarProducto(smp);
	    	if(actualizado	== true){
	    		response.sendRedirect("InventarioProductos.jsp?id_cat="+categoria);
	    	}
	    	
	    	
		%>