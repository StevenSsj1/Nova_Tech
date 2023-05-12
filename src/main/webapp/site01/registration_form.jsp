<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css">
  </head>
  <body >
    <header>
      <h1 style="color: white">Formulario de registro</h1>
    </header>
    <main>
      <form action="registro.jsp" method="post">
        <section>
          <label for="nombre">Nombre:</label>
          <input type="text" name="txtnombre"  required>
        </section>
        <section>
          <label for="cedula">Cedula:</label>
          <input type="text" name="txtcedula" maxlength="10" id="cedula" required >
        </section>
        <section>
          <label for="estado-civil">Estado civil:</label>
          <select name="txtestado-civil" id="estado-civil">
            <option value="soltero">Soltero</option>
            <option value="casado">Casado</option>
            <option value="divorciado">Divorciado</option>
            <option value="viudo">Viudo</option>
          </select>
        </section>
        <section style="color: white">
          <label for="residencia">Lugar de residencia:</label>
          <input type="radio" name="rdResidencia" value="Sur">Sur
          <input type="radio" name="rdResidencia" value="Norte">Norte
          <input type="radio" name="rdResidencia" value="Centro">Centro 

        </section>
        <section>
          <label for="foto">Foto:</label>
          <input type="file" name="imgfoto" id="foto">
        </section>
        <section>
          <label for="fecha-nacimiento">Mes y año de nacimiento:</label>
          <input type="month" name="txtfecha-nacimiento" id="fecha-nacimiento">
        </section>
        <section>
          <label for="color-favorito">Color favorito:</label>
          <input type="color" name="txtcolor-favorito" id="color-favorito">
        </section>
        <input type="submit" value="Enviar datos"/>
      </form>
    </main>
    <!-- <footer>
      <p></p>
    </footer> -->
  </body>
</html>
