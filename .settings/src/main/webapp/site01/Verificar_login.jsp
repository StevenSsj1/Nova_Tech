 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.producto.negocio.Usuario"
	session="true" 
%>
 <%	
            	
				Usuario usuario=new Usuario();
				String nlogin=request.getParameter("usuario");
				String nclave=request.getParameter("clave");
				if(nlogin != null){
					HttpSession sesion=request.getSession(); //Se crea la variable de sesión
					System.out.print(nlogin);
					boolean respuesta=usuario.verificarUsuario(nlogin,nclave);
						if (respuesta)
						{
							sesion.setAttribute("usuario", usuario.getNombre()); //Se añade atributos
							sesion.setAttribute("perfil", usuario.getPerfil()); //Se añade atributos
							response.sendRedirect("menu.jsp"); //Se redirecciona a una página específica

						}
						else
						{
							%>
							<jsp:forward page="login.jsp">
							<jsp:param name="error" value="Datos incorrectos.<br>Vuelva a intentarlo."/>
							</jsp:forward>
							<%
							
						}
						
				}
%>