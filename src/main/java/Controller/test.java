package Controller;
import java.sql.ResultSet;

import com.producto.datos.Conexion;
import com.producto.negocio.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int cod = 0;
			String dd = null;
			String sql="SELECT * FROM tb_pagina pag, tb_perfil per, \"tb_perfilPagina\" pper "
		    		+ "WHERE pag.id_pag = pper.id_pag AND pper.id_per = per.id_per AND pper.id_per ="+1;
			//System.out.print(sentencia);
			try
			{
				ResultSet rs;
				Conexion clsCon=new Conexion();
				rs=clsCon.Consulta(sql);
					if(rs.next())
					{
						 cod = rs.getInt(6);
						 dd = rs.getString(2);
					}
					else
					{
						rs.close();
					}
			}
		catch(Exception ex)
		{
		System.out.println( ex.getMessage());
		}
		
		System.out.println(cod);
		System.out.println(dd);
	
	}

}
