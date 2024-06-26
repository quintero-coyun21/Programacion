package Primero_DAM.Unidad14;

public class Alumno {
    private int idAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Alumno(int idAlumno, String nombre, String apellido1, String apellido2) {
        setIdAlumno(idAlumno);
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
}