package com.producto.negocio; 
import com.producto.datos.*;
import java.sql.*;

public class producto {
	private int Id_pr;
	private int Id_cat;
	private String Descripcion;
	private int Precio;
	private int cantidad;
	
	public producto() {
	}
	
	public producto(String descripcion, int id_pr, int precio, int cantidad) {
		Id_pr = id_pr;
		Descripcion = descripcion;
		Precio = precio;
		this.cantidad = cantidad;
	}
	public int getId_pr() {
		return Id_pr;
	}
	public void setId_pr(int id_pr) {
		Id_pr = id_pr;
	}
	public int getId_cat() {
		return Id_cat;
	}
	public void setId_cat(int id_cat) {
		Id_cat = id_cat;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void ConsultarEditarProductos(int cod) {
		Conexion con = new Conexion();
		
		ResultSet rs = null;
		
		String consulta = "SELECT id_celular, nombre_celular, precio_celular, id_cate, descripcion, cantidad\n"
				+ "FROM tb_productos\n"
				+ "WHERE id_celular ="+cod+"";
		
		try {
			rs = con.Consulta(consulta);
			
			while(rs.next()) {
				setId_pr(rs.getInt(1));
				setId_cat(rs.getInt(4));
				setDescripcion(rs.getString(5));
				setPrecio(rs.getInt(3));
				setCantidad(rs.getInt(6));
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public boolean ModificarProducto(producto cmp) {
			
			boolean agregado = false;
			Conexion con = new Conexion();
			String sql = "Update tb_productos set descripcion ='"+cmp.Descripcion+"' ,"
					+ " cantidad = "+cmp.getCantidad() + ", precio_celular = " + String.valueOf(cmp.getPrecio()) 
					+ " where id_celular = "+cmp.getId_pr();
					
			try {
				con.Ejecutar(sql);
				agregado = true;
			}catch(Exception e) {
				agregado = false;
			}
			return agregado;
			
		}

		public boolean Eliminar_Producto(int id_pro) {
			boolean eliminado = false;
			Conexion con = new Conexion();
			String sql = "DELETE FROM tb_productos WHERE id_celular ="+id_pro;
			try {
				con.Ejecutar(sql);
				eliminado = true;
			} catch (Exception e) {
				eliminado = false;
			}
			return eliminado;

		}
		
		public boolean Nueva_Oferta(int cod, int precio) {
			boolean agregado = false;
			double precio_oferta = precio + (0.4*precio);
			
			Conexion con = new Conexion();
			String sql = "Insert into tb_ofertas values (Default,"+cod+","+precio_oferta
					+",true)";
					
			try {
				con.Ejecutar(sql);
				agregado = true;
			}catch(Exception e) {
				agregado = false;
			}
			
			return agregado;
		}
}