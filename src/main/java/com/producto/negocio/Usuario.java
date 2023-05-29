package com.producto.negocio;

import java.sql.ResultSet;

import com.producto.datos.Conexion;

public class Usuario {
	
	private UsuarioData data = new UsuarioData();

	public Usuario() {
	}

	public String getLogin() {
		return data.Login;
	}

	public void setLogin(String login) {
		data.Login = login;
	}

	public String getClave() {
		return data.Clave;
	}

	public void setClave(String clave) {
		data.Clave = clave;
	}

	public int getPerfil() {
		return data.Perfil;
	}

	public void setPerfil(int perfil) {
		data.Perfil = perfil;
	}

	public String getNombre() {
		return data.Nombre;
	}

	public void setNombre(String nombre) {

		data.Nombre = nombre;
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

