<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.producto.negocio.Prueba"%>
<html>
    <head>
        <link href="css/estilos.css"
        rel="stylesheet"
        type="text/css">
        <title>Modelos de celulares</title>
        <header> 
			<div style="text-align:left;">
				<img src="imagenes/icon.png" 
				alt="logo" width="50" height="45">
				<h1 id="texto">Nova Tech</h1>
			</div>
        </header>
        <body style="color : white">
            <nav class="estilosMenu">
                <a href="index.jsp">Home</a>
                <a href="categoria.jsp">Ver Productos</a>
                <a href="registrar.jsp">Registrar Productos</a>
                </nav>
            <hr>
           <!--  <img src="imagenes/fondo1.jpg" 
            width="500px" 
            height="250px"
            /> -->
           
            <h1>Consulta de productos</h1>
    <form action="categoria.jsp" method="post">
           <div>
           <h1>Categoria</h1>
           <label>Elegir categoria </label>
           
	           <select name="txtestado-categoria" id="estado-categoria">
	           		<option value="0">Todas las categorías</option>
		            <option value="100">!Phone</option>
		            <option value="300">Samsung</option>
		            <option value="200">Xiamoni</option>
	          </select>
	         
          </div>
    
        	<% 
		        String id_cat=request.getParameter("txtestado-categoria");
		    	Prueba cat = new Prueba();
		    	if(id_cat == null){
		    		String tablaCate = cat.consultar_por_categoria("0");
		    		out.print(tablaCate);
		    	}else{
		    		String tablaCate = cat.consultar_por_categoria(id_cat);
		    		out.print(tablaCate);
		    	}
              %>
              <br>
              <br>
              <input type="submit"/>
      </form>    
  
        </body>
    </head>
</html>