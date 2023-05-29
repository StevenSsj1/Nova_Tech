package com.producto.negocio; 
import com.producto.datos.*;
import java.sql.*;

public class producto {
	
public String consultarTodo()
{
	String sql="SELECT * FROM tb_productos ORDER BY id_pr";
	Conexion con=new Conexion();
	String tabla="<table border=2><th>ID</th><th>Producto</th><th>Cantidad</th><th>Precio</th>";
	ResultSet rs=null;
	rs=con.Consulta(sql);
try {
	while(rs.next())
	{
	tabla+="<tr><td>"+rs.getInt(1)+"</td>"
	+ "<td>"+rs.getString(3)+"</td>"
	+ "<td>"+rs.getInt(4)+"</td>"
	+ "<td>"+rs.getDouble(5)+"</td>"
	+ "</td></tr>";
	}
} catch (SQLException e) {
// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.print(e.getMessage());
}
	tabla+="</table>";
return tabla;
}
}