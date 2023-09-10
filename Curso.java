public class Curso {
    private String codigo;
    private String nombre;
    private int periodosSemana;
    private String[] diasSemana;
    private String horaInicio;
    private int estudiantes;
    private Profesor profesor;

    // constructor
    public Curso(String codigo, String nombre, int periodosSemana, String[] diasSemana, String horaInicio,
            int estudiantes, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.periodosSemana = periodosSemana;
        this.diasSemana = diasSemana;
        this.horaInicio = horaInicio;
        this.estudiantes = estudiantes;
        this.profesor = profesor;
    }

    // setters y getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeriodosSemana() {
        return periodosSemana;
    }

    public void setPeriodosSemana(int periodosSemana) {
        this.periodosSemana = periodosSemana;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}