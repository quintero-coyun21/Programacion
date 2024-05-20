package Primero_DAM.Unidad14;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static Statement stmt = null;
    static Connection con = null;

    public static void main(String[] args) throws SQLException {
        establecerConexion();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1. Obtener alumnos
                2. Obtener las matrículas de los alumnos
                3. Insertar alumnos
                4. Actualizar nota
                """);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                obtenerAlumnos();
                return;
            case 2:
                obtenerMatriculas();
                return;
            case 3:
                insertarAlumnos();
                return;
            default:
                System.out.println("Opcion no valida");
        }
//        System.out.println();
//        obtenerAsignaturas();
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

    public static void obtenerMatriculas() throws SQLException {
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = new Scanner(System.in).nextInt();
        String sql = "select alumno.idAlumno, alumno.nombre, c.idAsignatura, c.nota from instituto.alumno a "+"inner join instituto.matriculas c on c.idAlumno = a.idAlumno"+"where a.idAlumno="+idAlumnoP;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAlum = rs.getInt("idAlumno");//1
                String nombre = rs.getString("nombre");//2
                int idAsig = rs.getInt("curso");//3
                double nota = rs.getDouble("nota");//4

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insertarAlumnos() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String nombre,apellido1,apellido2;
        System.out.println("Introduce el nombre del alumno:");
        nombre = sc.nextLine();
        System.out.println("Introduce el primer apellido del alumno:");
        apellido1 = sc.nextLine();
        System.out.println("Introduce el segundo apellido del alumno:");
        apellido2 = sc.nextLine();

        String sql = "insert into alumno(nombre,apellido1,apellido2) " + "values('" + nombre + "','" + apellido1 + "','" + apellido2 + "')";
        stmt.execute(sql);
    }
}