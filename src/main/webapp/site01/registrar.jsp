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
        <body>
            <nav>
                <a href="index.jsp">Home</a>
                <a href="categoria.jsp">Ver Productos</a>
                </nav>
            <hr>
             <header>
      <h1 style="color: white">Ingresar un nuevo producto</h1>
    </header>
    <main>
    	<form>
    		<section>
	    		<label for="Codigo Producto">ID Producto</label>
	    		<input type="text" name="txtIdProducto"  required>
    		</section>
    		<section>
	    		<label for="Categoria Producto">Categoria</label>
	    		<input type="text" name="txtCategoria"  required>
    		</section>
    		<section>
	    		<label for="Nombre Producto">Nombre</label>
	    		<input type="text" name="txtNombre"  required>
    		</section>
    		<section>
	    		<label for="Cantidad Producto">Cantidad</label>
	    		<input type="text" name="txtCantidad"  required>
    		</section>
    		<section>
	    		<label for="Precio Producto">Precio</label>
	    		<input type="text" name="txtPrecio"  required>
    		</section>
    		<section>
	    		<label for="Precio Producto">Precio</label>
	    		<input type="text" name="txtPrecio"  required>
    		</section>
    		<section>
	          <label for="foto">Imagen del producto</label>
	          <input type="text" name="pathImg">
	          <input type="file" name="imgfoto" id="foto">
            </section>
    		<input type="submit" value="Enviar datos"/>
    	</form>
    
    </main>
        </body>
    </head>
</html>