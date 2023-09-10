import java.util.HashMap;
import java.util.Map;

public class Horario {
    private int capacidad;
    private String[][] horario;
    private Curso[] listaCursos;

    // constructor
    public Horario(int capacidad, String[][] horario, Curso[] listaCursos) {
        this.capacidad = capacidad;
        this.horario = horario;
        this.listaCursos = listaCursos;
    }

    // setters y getters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String[][] getHorario() {
        return horario;
    }

    public void setHorario(String[][] horario) {
        this.horario = horario;
    }

    public Curso[] getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(Curso[] listaCursos) {
        this.listaCursos = listaCursos;
    }

    /**
     * Método para asignar el curso
     */
    public void asignarCurso(Curso curso, int dia, int periodo) {
        if (dia >= 0 && dia < 7 && periodo >= 0 && periodo < 14) {
            // Verificar si el espacio en el laboratorio está disponible
            if (horario[dia][periodo] == null) {
                // Verificar si la cantidad de estudiantes no excede la capacidad del
                // laboratorio
                if (curso.getEstudiantes() <= capacidad) {
                    // Asignar el curso al horario
                    horario[dia][periodo] = curso.getCodigo();
                    System.out.println("Curso asignado correctamente.");
                } else {
                    System.out.println(
                            "Error: La cantidad de estudiantes inscritos supera la capacidad del laboratorio.");
                }
            } else {
                System.out.println("Error: Este espacio ya está asignado a otro curso.");
            }
        } else {
            System.out.println("Error: Día o período no válido.");
        }

    }

    /**
     * Método para mostrar la información del curso
     */
    public void verInformacionCurso(int dia, int periodo) {
        if (dia >= 0 && dia < 7 && periodo >= 0 && periodo < 14) {
            String codigoCurso = horario[dia][periodo];
            if (codigoCurso != null) {
                // Buscar el curso en la lista de cursos y mostrar su información
                for (Curso curso : listaCursos) {
                    if (curso.getCodigo().equals(codigoCurso)) {
                        System.out.println("Información del curso en el día " + dia + " y período " + periodo + ":");
                        System.out.println("Código del curso: " + curso.getCodigo());
                        System.out.println("Nombre del curso: " + curso.getNombre());
                        System.out.println("Días de la semana: " + String.join(", ", curso.getDiasSemana()));
                        System.out.println("Hora de inicio: " + curso.getHoraInicio());
                        System.out.println("Estudiantes inscritos: " + curso.getEstudiantes());
                        System.out.println("Profesor a cargo: " + curso.getProfesor().getNombre_profesor());
                        return;
                    }
                }
            } else {
                System.out.println("No hay curso asignado en el día " + dia + " y período " + periodo + ".");
            }
        } else {
            System.out.println("Error: Día o período no válido.");
        }
        // Si llegamos aquí, no se encontró el curso en el horario especificado
        System.out.println("No se encontró información para el día " + dia + " y período " + periodo + ".");
    }

    /**
     * Método para eliminar el curso
     */
    public void eliminarCurso(int dia, int periodo) {
        if (dia >= 0 && dia < 7 && periodo >= 0 && periodo < 14) {
            if (horario[dia][periodo] != null) {
                horario[dia][periodo] = null;
                System.out.println("Curso eliminado correctamente del día " + dia + " y período " + periodo + ".");
            } else {
                System.out.println("No hay curso asignado en el día " + dia + " y período " + periodo + ".");
            }
        } else {
            System.out.println("Error: Día o período no válido.");
        }
    }

    /**
     * Método para buscar el curso
     */
    public Curso buscarCursoPorCodigo(String codigoCurso) {
        for (Curso curso : listaCursos) {
            if (curso.getCodigo().equals(codigoCurso)) {
                return curso;
            }
        }
        return null; // Devuelve null si no se encuentra el curso
    }

    /**
     * Método para mostrar al profesor
     */
    public void mostrarProfesorEnHorario(String nombreProfesor) {
        System.out.println("Profesor: " + nombreProfesor);
        for (int dia = 0; dia < 7; dia++) {
            for (int periodo = 0; periodo < 14; periodo++) {
                String codigoCurso = horario[dia][periodo];
                if (codigoCurso != null) {
                    Curso curso = buscarCursoPorCodigo(codigoCurso); // Implementa una función para buscar un curso por
                                                                     // su código
                    if (curso != null && curso.getProfesor().getNombre_profesor().equals(nombreProfesor)) {
                        System.out.println("Día " + dia + ", Período " + periodo + ": " + curso.getNombre());
                    }
                }
            }
        }
    }

    /**
     * Método para mostrar los días del profesor
     */
    public void mostrarDiasProfesor(String nombre_profesor) {
        System.out.println("Días en los que " + nombre_profesor + " está al frente del laboratorio:");
        for (int dia = 0; dia < 7; dia++) {
            for (int periodo = 0; periodo < 14; periodo++) {
                String codigoCurso = horario[dia][periodo];
                if (codigoCurso != null) {
                    Curso curso = buscarCursoPorCodigo(codigoCurso); // Implementa una función para buscar un curso por
                                                                     // su código
                    if (curso != null && curso.getProfesor().getNombre_profesor().equals(nombre_profesor)) {
                        System.out.println("Día " + dia + ", Período " + periodo + ": " + curso.getNombre());
                    }
                }
            }
        }
    }

    /**
     * Método para mostrar la responsabilidad del profesor
     */
    public void mostrarResponsabilidadProfesores() {
        System.out.println("Responsabilidad de los profesores:");

        Map<String, Integer> profesorResponsabilidad = new HashMap<>();

        for (int dia = 0; dia < 7; dia++) {
            for (int periodo = 0; periodo < 14; periodo++) {
                String codigoCurso = horario[dia][periodo];
                if (codigoCurso != null) {
                    Curso curso = buscarCursoPorCodigo(codigoCurso);
                    if (curso != null) {
                        String nombreProfesor = curso.getProfesor().getNombre_profesor();
                        profesorResponsabilidad.put(nombreProfesor,
                                profesorResponsabilidad.getOrDefault(nombreProfesor, 0) + 1);
                    }
                }
            }
        }

        // Luego, imprime el resultado del cálculo de la responsabilidad
        for (Map.Entry<String, Integer> entry : profesorResponsabilidad.entrySet()) {
            String nombreProfesor = entry.getKey();
            int cantidadHorarios = entry.getValue();
            double porcentajeResponsabilidad = (double) cantidadHorarios / (7 * 14) * 100;
            System.out.println(
                    nombreProfesor + ": " + cantidadHorarios + " horarios (" + porcentajeResponsabilidad + "%)");
        }
    }

    /**
     * Método para mostrar la responsabilidad del profesor
     */
    public void ponerDisponibleNuevoSemestre() {
        // Reiniciar la matriz de horario para el nuevo semestre
        for (int dia = 0; dia < 7; dia++) {
            for (int periodo = 0; periodo < 14; periodo++) {
                horario[dia][periodo] = null;
            }
        }
        System.out.println("El laboratorio ha sido puesto disponible para el nuevo semestre.");
    }

    public void mostrarProfesorEnHorario(int diaBusqueda, int periodoBusqueda) {
    }

}