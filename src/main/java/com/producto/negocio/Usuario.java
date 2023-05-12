package com.producto.negocio;

import java.sql.ResultSet;

import com.producto.datos.Conexion;

public class Usuario {
	
	private String Login;
	private String Clave;
	private int Perfil;
	private String Nombre;

	public Usuario() {
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public int getPerfil() {
		return Perfil;
	}

	public void setPerfil(int perfil) {
		Perfil = perfil;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {

		Nombre = nombre;
	}
	
	
	public boolean verificarUsuario(String nlogin, String nclave)
	{
		boolean respuesta=false;
		String sentencia= "Select * from tb_usuario where login_us='"+nlogin+
		"' and clave_us='"+nclave+"';";
		//System.out.print(sentencia);
		try
		{
			ResultSet rs;
			Conexion clsCon=new Conexion();
			rs=clsCon.Consulta(sentencia);
				if(rs.next())
				{
					respuesta=true;
					this.setLogin(nlogin);
					this.setClave(nclave);
					this.setPerfil(rs.getInt(6));
					this.setNombre(rs.getString(2));
				}
				else
				{
					respuesta=false;
					rs.close();
				}
		}
	catch(Exception ex)
	{
	System.out.println( ex.getMessage());
	}
	return respuesta;
	}

}

