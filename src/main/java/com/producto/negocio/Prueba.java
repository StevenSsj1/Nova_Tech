package com.producto.negocio;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.producto.datos.*;
public class Prueba {
	public String consultarTodo() {
	    String sql = "SELECT * FROM tb_productos ORDER BY id_celular";
	    Conexion con = new Conexion();
	    String tabla = "<table border=2;><th>Nombre</th><th>Precio</th><th>Descripcion</th>";
	    ResultSet rs = null;
	    
	    try {
	        rs = con.Consulta(sql);
	        while (rs.next()) {
	            tabla += "<tr><td>" + rs.getString("nombre_celular") + "</td>"
	                + "<td>" + rs.getString("precio_celular") + "</td>"
	                + "<td>" + rs.getString("descripcion") + "</td>"
	                + "</tr>";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	        System.out.println("Error");
	    } finally {
	        try {
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    tabla += "</table>";
	    return tabla;
	}
	
	public String consultar_por_categoria(String id_cats) {
		int id_cat = Integer.parseInt(id_cats);
		
		String sql = "select * from tb_productos";
		Conexion con = new Conexion();
		String tabla = "<table border=2;><th>Nombre</th><th>Precio</th><th>Descripcion</th>";
		ResultSet rs = null;
		if(id_cat == 0 ) {
			tabla = consultarTodo();
		}else {
			sql ="select nombre_categoria, precio_celular, nombre_celular\r\n"
					+ "from tb_productos, tb_categorias\r\n"
					+ "where id_cate ="+id_cat+"\n"
							+ "and id_categoria="+id_cat+"";
			try {
		        rs = con.Consulta(sql);
		        while (rs.next()) {
		            tabla += "<tr><td>" + rs.getString("nombre_categoria") + "</td>"
		                + "<td>" + rs.getString("precio_celular") + "</td>"
		                + "<td>" + rs.getString("nombre_celular") + "</td>"
		                + "</tr>";
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.print(e.getMessage());
		        System.out.println("Error");
		    } finally {
		        try {
		            rs.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }	    
		    tabla += "</table>";
		}
		   
	    return tabla;
	}


}
