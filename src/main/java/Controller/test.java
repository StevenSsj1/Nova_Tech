package Controller;
import java.sql.ResultSet;

import com.producto.datos.Conexion;
import com.producto.negocio.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int cod = 0;
			String dd = null;
			String description = null;
			String consulta = "SELECT id_celular, nombre_celular, precio_celular, id_cate, descripcion\n"
					+ "FROM tb_productos\n"
					+ "WHERE id_cate ="+100+"";
			//System.out.print(sentencia);
			try
			{
				ResultSet rs;
				Conexion clsCon=new Conexion();
				rs=clsCon.Consulta(consulta);
					if(rs.next())
					{
						 cod = rs.getInt(1);
						 dd = rs.getString(2);
						 description = rs.getString(3);
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
		System.out.println(description);
	
	}

}
