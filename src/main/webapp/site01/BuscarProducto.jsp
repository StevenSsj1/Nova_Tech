<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.producto"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
		<%
		  int cod = Integer.parseInt(request.getParameter("cod"));
		  producto mp = new producto();
		  mp.ConsultarEditarProductos(cod);
	    %>
	
	<main>
		<form action="modificar.jsp" method="post">
			<section>
	    		<label for="Codigo Producto">Codigo Producto</label>
	    		<input type="text" name="editarcod" value="<%=cod%>"  required/>
    		</section>
    		<section>
	    		<label for="Categoria Producto">Categoria</label>
				<label><output><%=mp.getId_cat() %></output></label>
				 <input type="hidden" name="id_cat" value="<%=mp.getId_cat() %>">
    		</section>
    		<section>
	    		<label for="Descripcion Producto">Descripcion</label>
	    		<input type="text" name="txtNombre" 
	    		value="<%=mp.getDescripcion() %>" required>
    		</section>
    		<section>
	    		<label for="Cantidad Producto">Cantidad</label>
	    		<input type="text" name="txtCantidad"  
	    		value="<%=mp.getCantidad()%>" required>
    		</section>
    		<section>
	    		<label for="Precio Producto">Precio</label>
	    		<input type="text" name="txtPrecio"  
	    		value="<%=mp.getPrecio()%>" required>
    		</section>
    		<input type="submit" value="Enviar datos"/>
		</form>
		
		
	</main>

</body>
</html>