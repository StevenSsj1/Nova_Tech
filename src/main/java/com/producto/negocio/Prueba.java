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
	
	public String consultarProducto(String cod) {
		String tabla = "<table border=2>";
		String consulta = "SELECT id_celular, nombre_celular, precio_celular, id_cate, descripcion, cantidad\n"
				+ "FROM tb_productos\n"
				+ "WHERE id_cate ="+cod+"";
		ResultSet rs = null;
		tabla += "<tr>"
				+ "<th>Codigo</th>"
				+ "<th>Descripcion</th>"
				+ "<th>Precio</th>"
				+ "<th>Cantidad</th>"
				+ "</tr>";
		Conexion con = new Conexion();
		try {
			rs = con.Consulta(consulta);
			
			while (rs.next()) {
				tabla += "<tr><td><pre Style=\"text-align; center\">" + rs.getInt(1) + "</pre></td>"
		                + "<td><pre Style=\"text-align; center\">" + rs.getString(2) + "</pre></td>"
		                + "<td><pre Style=\"text-align; center\">" + rs.getString(3) + "</pre></td>"
		                + "<td><pre Style=\"text-align; center\">" + rs.getInt(6) + "</pre></td>"
		                + "<td><a href= BuscarProducto.jsp?cod="+ rs.getInt(1)+"><pre style=\"text-align; center\">Modificar</pre></a></td>"
		                + "<td><a href= EliminarProducto.jsp?cod="+ rs.getInt(1)+"><pre style=\"text-align; center\">Eliminar</pre></a></td>"
		                + "<td><a href= ActivarOferta.jsp?cod=" + rs.getInt(1) + "&precio=" + rs.getString(3) + "><pre style=\"text-align; center\">Oferta</pre></a></td>";
			}	tabla += "</table>";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
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
	
	public String obtenerProductosConOfertaPorCategoria(String id_cats) {
	    int id_cat = Integer.parseInt(id_cats);
	    String tabla = "";

	    if (id_cat == 0) {
	        tabla = obtenerProductosConOferta();
	    } else {
	        String sql = "SELECT tb_productos.*, tb_ofertas.precio_oferta, tb_ofertas.estado " +
	                     "FROM tb_productos " +
	                     "LEFT JOIN tb_ofertas ON tb_productos.id_celular = tb_ofertas.id_oferta " +
	                     "WHERE tb_productos.id_cate = " + id_cat;

	        Conexion con = new Conexion();
	        tabla = "<table border=2;><th>Nombre</th><th>Precio</th><th>Descripción</th><th>Precio con oferta</th>";
	        ResultSet rs = null;

	        try {
	            rs = con.Consulta(sql);
	            while (rs.next()) {
	                String nombreCelular = rs.getString("nombre_celular");
	                String precioCelular = rs.getString("precio_celular");
	                String descripcion = rs.getString("descripcion");
	                String precioOferta = rs.getString("precio_oferta");
	              

	                // Verificar si los valores son nulos
	                if (rs.wasNull()) {
	                    precioOferta = ""; // Reemplazar con una cadena vacía si es nulo
	                    
	                }

	                tabla += "<tr><td>" + (nombreCelular != null ? nombreCelular : "") + "</td>"
	                        + "<td>" + (precioCelular != null ? precioCelular : "") + "</td>"
	                        + "<td>" + (descripcion != null ? descripcion : "") + "</td>"
	                        + "<td>" + precioOferta + "</td>"
	                        + "</tr>";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	            System.out.println("Error");
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        tabla += "</table>";
	    }

	    return tabla;
	}


	public String obtenerProductosConOferta() {
	    String sql = "SELECT tb_productos.*, tb_ofertas.precio_oferta, tb_ofertas.estado\r\n"
	    		+ "FROM tb_productos\r\n"
	    		+ "LEFT JOIN tb_ofertas ON tb_productos.id_celular = tb_ofertas.id_oferta";
	    Conexion con = new Conexion();
	    String tabla = "<table border=2;><th>Nombre</th><th>Precio</th><th>Descripción</th><th>Precio con oferta</th>";
	    ResultSet rs = null;
	    
	    try {
	        rs = con.Consulta(sql);
	        while (rs.next()) {
	        	 String precioOferta = rs.getString("precio_oferta");
	            tabla += "<tr><td>" + rs.getString("nombre_celular") + "</td>"
	                    + "<td>" + rs.getString("precio_celular") + "</td>"
	                    + "<td>" + rs.getString("descripcion") + "</td>"
	                    + "<td>" + (precioOferta != null ? precioOferta : "") + "</td>"
	                    + "</tr>";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	        System.out.println("Error");
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    tabla += "</table>";
	    return tabla;
	}
	

}
