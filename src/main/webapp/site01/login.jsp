<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.producto.negocio.Usuario"
	session="true" 
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="css/estilos.css" rel="stylesheet" type="text/css">
	</head>

<body class="background_login">
		<nav>
			<a href="categoria.jsp">Ver Productos</a>
			<a href="index.jsp">Home</a>
		</nav>
	
    <div class="container">
        <div class="container_background">
            <img src="imagenes/fondo_login.jpg" width="250" height="200"/>
        </div>
        <form action="Verificar_login.jsp" method="post">
        <div class="login">     
            <h3 class="title">User Login</h3>
            <div class="text-input">
                <i class="ri-user-fill"></i>
                <input type="text" placeholder="Username" name="usuario">
            </div>
            <div class="text-input">
                <i class="ri-lock-fill"></i>
                <input type="password" placeholder="Password" name="clave">
            </div>
            <button type="submit" class="login-btn">LOGIN</button>
        </div>
        <div class="create">
                <a href="registration_form.jsp">Registrate</a>
                <i class="ri-arrow-right-fill"></i>
            </div>
      </form>
            
        </div>
</body>
</html>