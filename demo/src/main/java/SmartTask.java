import java.util.Scanner;

/**
 * Clase principal que actúa como el punto de entrada de la aplicación <b>SmartTask</b>.
 * 
 * Esta herramienta está diseñada para permitir a estudiantes y trabajadores gestionar
 * sus tareas diarias (agregar, listar, completar y eliminar) desde la consola [5, 6].
 * La implementación sigue una estructura modular y escalable para facilitar su
 * evolución futura [6].
 * 
 * @author Milo
 * @version 1.0
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html">Documentación oficial JavaDoc</a>
 */
public class SmartTask {

    /**
     * Punto de inicio de la aplicación. 
     * 
     * Este método gestiona el flujo principal del programa, inicializando el 
     * <b>GestorTareas</b> y controlando el ciclo de vida del menú interactivo 
     * a través de la entrada de usuario por consola [1, 7, 8].
     * 
     * @param args Argumentos de la línea de comandos (no utilizados actualmente).
     */
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SMART TASK MENU ---");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Marcar como Completada");
            System.out.println("4. Eliminar Tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    System.out.print("¿Es urgente? (s/n): ");
                    boolean esUrgente = scanner.nextLine().equalsIgnoreCase("s");
                    
                    // Aplicación de polimorfismo al instanciar diferentes tipos de tareas [8].
                    Tarea nueva = esUrgente ? 
                        new TareaUrgente(gestor.getSiguienteId(), nombre) : 
                        new TareaNormal(gestor.getSiguienteId(), nombre);
                    gestor.agregarTarea(nueva);
                    break;
                case 2:
                    gestor.listarTareas();
                    break;
                case 3:
                    System.out.print("ID de la tarea a completar: ");
                    gestor.marcarComoCompletada(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    gestor.eliminarTarea(scanner.nextInt());
                    break;
            }
        } while (opcion != 5);

        System.out.println("Saliendo de SmartTask...");
        scanner.close();
    }
}