package Primero_DAM.Unidad14;
import java.sql.*;
public class Main {
    static Statement stmt = null;
    static Connection con = null;

    public static void main(String[] args) throws SQLException {
        establecerConexion();
        obtenerAlumnos();
        System.out.println();
        obtenerAsignaturas();
    }

    public static void establecerConexion() {
        String url = "jdbc:mysql://localhost:3306/salesianos";
        try {
            con = DriverManager.getConnection(url, "yuna","yuna");
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void obtenerAlumnos() throws SQLException {
        String sql = "select * from alumno";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("nombre") + " " + rs.getString("apellido1") + " " +  rs.getString("apellido2"));
        }
    }

    public static void obtenerAsignaturas() throws SQLException {
        String sql = "select * from asignatura";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            //System.out.println(rs.getString("nombre") + " " + rs.getString("curso"));
            System.out.println("""
                    \nNombre de la Asignatura:""" + " " + rs.getString("nombre") + """ 
                    \nCurso de la Asignatura:""" + " " + rs.getString("curso")
            );
        }
    }
}