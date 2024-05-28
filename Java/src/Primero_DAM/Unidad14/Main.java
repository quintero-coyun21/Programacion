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
                1. Listar alumnos
                2. Listar las matrículas de un alumno
                3. Insertar alumnos
                4. Insertar matrículas de un alumno
                5. Obtener mejor y peor nota del alumno
                6. Obtener la nota medida del alumno
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
            case 4:
                insertarMatriculas();
                return;
            case 5:
                obtenerMejorPeorNota();
                return;
            case 6:
                notaMedia();
                return;
            default:
                System.out.println("Opción no valida");
        }
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

    public static void obtenerMatriculas() throws SQLException {
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = new Scanner(System.in).nextInt();
        String sql = "select * from matricula where idAlumno=" + idAlumnoP;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("idAlumno" + " " + rs.getString("idAlumno") + " " + "idAsignatura" + " " + rs.getString("idAsignatura") + " " + "Nota" + " " + rs.getString("nota"));
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

    public static void insertarMatriculas() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = sc.nextInt();
        System.out.println("Introduce el id de la asignatura:");
        int idAsignaturaP = sc.nextInt();
        System.out.println("Introduce la nota:");
        double notaP = sc.nextDouble();
        String sql = "insert into matricula(idAlumno,idAsignatura,nota) " + "values('" + idAlumnoP + "','" + idAsignaturaP + "','" + notaP + "')";
        stmt.execute(sql);
    }

    public static void obtenerMejorPeorNota() throws SQLException {
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = new Scanner(System.in).nextInt();
        String sql = "select nota from matricula where idAlumno=" + idAlumnoP;

        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = stmt.executeQuery(sql);
        resultSet.first();
        double minima = resultSet.getDouble("nota");
        resultSet.last();
        double maxima = resultSet.getDouble("nota");

        System.out.println("Mínima:" + minima);
        System.out.println("Máxima:" + maxima);

    }

    public static void notaMedia() throws SQLException {
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = new Scanner(System.in).nextInt();
        String sql = "select round(avg(nota),2) as media from matricula where idAlumno=" + idAlumnoP;
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        double notaMedia = resultSet.getDouble("Nota media");
        System.out.println("Nota media:" + notaMedia);
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

    public static void actualizarNota() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id del alumno:");
        int idAlumnoP = sc.nextInt();
        System.out.println("Introduce el id la asignatura:");
        int idAsignaturaP = sc.nextInt();
        System.out.println("Introduce la nota:");
        double nota = sc.nextDouble();
        String sql = "update matricula set nota =" + nota + "where idAlumno ="+ idAlumnoP + "and idAsignatura="+idAsignaturaP;
        stmt.execute(sql);
    }

}