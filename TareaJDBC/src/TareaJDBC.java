
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TareaJDBC {

    public static void main(String[] args) {
        Connection con = null;
    try {
        String url = "jdbc:mysql://localhost:3306/prueba";
        String usuario = "root";
        String contraseña = "319192142";

        con = DriverManager.getConnection(url, usuario, contraseña);
        
    } catch (SQLException e) {
        System.err.println("Error al conectar a la base de datos");
    }
    
    PreparedStatement ps;
    ResultSet rs;
    
    try {
        ps =  con.prepareStatement("select * from empleados");
        rs= ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id_empleado")+" "+rs.getString("ap_paterno")+" "+rs.getString("ap_materno")+" "+rs.getString("nombre")+" "+rs.getInt("seccion"));
        }
    } catch (SQLException e) {
        System.out.println(e);
    }

    try {
        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
    }
}