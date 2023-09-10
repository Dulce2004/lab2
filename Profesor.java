public class Profesor {
    private String nombre_profesor;
    private int carne;
    private int telefono;

    // Constructor
    public Profesor(String nombre_profesor, int carne, int telefono) {
        this.nombre_profesor = nombre_profesor;
        this.carne = carne;
        this.telefono = telefono;
    }

    // setters y getters
    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}