package com.productos.negocio;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.productos.datos.*;
public class Prueba {
	public String consultarTodo() {
	    String sql = "SELECT * FROM tb_productos ORDER BY id_marca";
	    Conexion con = new Conexion();
	    String tabla = "<table border=2;><th>Nombre</th><th>Precio</th><th>Descripcion</th>";
	    ResultSet rs = null;
	    
	    try {
	        rs = con.Consulta(sql);
	        while (rs.next()) {
	            tabla += "<tr><td>" + rs.getString("nombre_celular") + "</td>"
	                + "<td>" + rs.getString("precio_celular") + "</td>"
	                + "<td>" + rs.getString("description") + "</td>"
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
	
	public String consultar_por_categoria(String id_cat) {
		String sql ="select id_celular,nombre_categoria,precio_celular, nombre_celular\r\n"
				+ "from tb_productos, tb_categorias\r\n"
				+ "where id_cate = id_categoria";
//		if(id_cat.equals("0")) {
//		sql = "select * from tb_productos";
//		}else {
//		sql = "select * from tb_categorias, tb_productos where id_categoria ="+id_cat;
//		}
		
	    Conexion con = new Conexion();
	    String tabla = "<table border=2;><th>ID</th><th>Nombre</th><th>Precio</th><th>Descripcion</th>";
	    ResultSet rs = null;
	    
	    try {
	        rs = con.Consulta(sql);
	        while (rs.next()) {
	            tabla += "<tr><td>" + rs.getInt("id_celular") + "</td>"
	                + "<td>" + rs.getString("nombre_categoria") + "</td>"
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
	    
	    return tabla;
	}


}
