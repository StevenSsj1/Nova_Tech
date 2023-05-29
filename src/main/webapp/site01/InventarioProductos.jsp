<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section>
<%String id_cats = request.getParameter("id_cat"); %>
	
	<form action="InventarioProductos.jsp" method="post">
           <div>
	           <h1>Categoria</h1>
	           <label>Elegir categoria </label>
	           
		           <select name="txtestado-categoria" id="estado-categoria">
		           		<option value="0">Todas las categorías</option>
			            <option value="100">!Phone</option>
			            <option value="300">Samsung</option>
			            <option value="200">Xiamoni</option>
		          </select>
		          <br>        
          </div>
    
        	
        	<% 
        			String id_cat = request.getParameter("txtestado-categoria");
	        		Prueba con = new Prueba();
		        	String table = con.consultarProducto(id_cat);	    	
		        	if (id_cat != null && !id_cat.isEmpty()) {
		        		out.println(table);	
		        	}else if (id_cats != null && !id_cats.isEmpty()){
		        		table = con.consultarProducto(id_cats);
		        		out.println(table);	

		        	}
		        %>
        
         
              <br>
              <br>
              <input type="submit"/>	
      </form>
</section>



</body>
</html>