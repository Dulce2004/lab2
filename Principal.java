import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Horario lab = new Horario(30, new String[7][14], new Curso[50]); // Reemplaza TAMAÑO_DE_LA_LISTA con el tamaño
                                                                         // real de tu lista de cursos

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Asignar curso");
            System.out.println("2. Ver información de curso en un horario");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Mostrar profesor en un horario");
            System.out.println("5. Mostrar días de un profesor");
            System.out.println("6. Mostrar responsabilidad de profesores");
            System.out.println("7. Poner disponible el laboratorio para el nuevo semestre");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Asignar un curso:");
                    System.out.print("Ingrese el código del curso: ");
                    String codigoCurso = scanner.nextLine();
                    System.out.print("Ingrese el nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    System.out.print(
                            "Ingrese la cantidad de períodos (de una hora) que se imparte el curso por cada día de la semana: ");
                    int cantidadPeriodos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print(
                            "Ingrese los días de la semana que se imparte el curso (por ejemplo, lunes martes): ");
                    String diasSemana = scanner.nextLine();
                    System.out.print("Ingrese el horario en que se imparte el curso (por ejemplo, 7:00 am): ");
                    String horaInicio = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de estudiantes inscritos: ");
                    int estudiantes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el nombre del profesor que imparte el curso: ");
                    String nombreProfesor = scanner.nextLine();
                    System.out.print("Ingrese el nombre del profesor que imparte el curso: ");
                    String nombre_Profesor = scanner.nextLine();

                    // También proporciona el carné y el teléfono del profesor, si es necesario
                    System.out.print("Ingrese el carné del profesor: ");
                    int carneProfesor = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Ingrese el teléfono del profesor: ");
                    int telefonoProfesor = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Profesor profesor = new Profesor(nombreProfesor, carneProfesor, telefonoProfesor);

                    Curso curso = new Curso(codigoCurso, nombreCurso, cantidadPeriodos, diasSemana.split(" "),
                            horaInicio, estudiantes, profesor);

                    System.out.print("Ingrese el día (0-6): ");
                    int diaAsignacion = scanner.nextInt();

                    System.out.print("Ingrese el período (0-13): ");
                    int periodoAsignacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    lab.asignarCurso(curso, diaAsignacion, periodoAsignacion);
                    break;
                case 2:
                    System.out.println("Ver información de un curso en un horario específico:");

                    // Solicitar al usuario el día y período para ver la información del curso
                    System.out.print("Ingrese el día (0-6): ");
                    int diaConsulta = scanner.nextInt();

                    System.out.print("Ingrese el período (0-13): ");
                    int periodoConsulta = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Llama al método verInformacionCurso de la instancia de Horario para mostrar
                    // la información del curso
                    lab.verInformacionCurso(diaConsulta, periodoConsulta);
                    break;
                case 3:
                    System.out.println("Eliminar un curso de un período de tiempo del calendario:");

                    // Solicitar al usuario el día y período para eliminar el curso
                    System.out.print("Ingrese el día (0-6): ");
                    int diaEliminar = scanner.nextInt();

                    System.out.print("Ingrese el período (0-13): ");
                    int periodoEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Llama al método eliminarCurso de la instancia de Horario para eliminar el
                    // curso del horario
                    lab.eliminarCurso(diaEliminar, periodoEliminar);
                    break;
                case 4:
                    System.out.println("Mostrar el profesor en un día y horario determinado:");

                    // Solicitar al usuario el día y período para buscar al profesor
                    System.out.print("Ingrese el día (0-6): ");
                    int diaBusqueda = scanner.nextInt();

                    System.out.print("Ingrese el período (0-13): ");
                    int periodoBusqueda = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Llama al método mostrarProfesorEnHorario de la instancia de Horario para
                    // mostrar el profesor
                    lab.mostrarProfesorEnHorario(diaBusqueda, periodoBusqueda);
                    break;
                case 5:
                    System.out.println("Mostrar los días en los que un profesor está al frente del laboratorio:");

                    // Solicitar al usuario el nombre del profesor para buscar sus días de clase
                    System.out.print("Ingrese el nombre del profesor: ");
                    String nombreProfesorBusqueda = scanner.nextLine();

                    // Llama al método mostrarDiasProfesor de la instancia de Horario para mostrar
                    // los días del profesor
                    lab.mostrarDiasProfesor(nombreProfesorBusqueda);
                    break;
                case 6:
                    System.out.println("Mostrar la responsabilidad de los profesores:");

                    // Llama al método mostrarResponsabilidadProfesores de la instancia de Horario
                    lab.mostrarResponsabilidadProfesores();
                    break;
                case 7:
                    lab.ponerDisponibleNuevoSemestre();
                    System.out.println("El laboratorio está disponible para el nuevo semestre.");
                    break;
                case 8:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 8.");
                    break;
            }
        }
    }
}
