public class Registro {
    String nombre, apellido1, apellido2;
    public Registro(String nombre, String apellido1, String apellido2) {
        setNombre(nombre);
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getApellido1() {
        return apellido1;
    }

    public void setApellido1(java.lang.String apellido1) {
        this.apellido1 = apellido1;
    }

    public java.lang.String getApellido2() {
        return apellido2;
    }

    public void setApellido2(java.lang.String apellido2) {
        this.apellido2 = apellido2;
    }
}
