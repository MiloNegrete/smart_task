import java.util.Scanner;

/**
 * Clase principal que actúa como el punto de entrada de la aplicación SmartTask.
 * 
 * Esta herramienta está diseñada para permitir a estudiantes y trabajadores gestionar
 * sus tareas diarias (agregar, listar, completar y eliminar) desde la consola.
 * La implementación sigue una estructura modular y escalable para facilitar su
 * evolución futura.
 * 
 * @author Milo
 * @version 1.1
 */
public class SmartTask {

    /**
     * Punto de inicio de la aplicación.
     * Gestiona el flujo principal del programa y el ciclo de vida del menú interactivo.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados actualmente).
     */
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("╔══════════════════════════╗");
        System.out.println("║   Bienvenido a SmartTask  ║");
        System.out.println("╚══════════════════════════╝");

        do {
            System.out.println("\n--- SMART TASK MENU ---");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Marcar como Completada");
            System.out.println("4. Eliminar Tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // ✅ Manejo de entrada inválida en el menú
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("⚠️  Opción inválida. Por favor ingresa un número del 1 al 5.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine().trim();

                    // ✅ Validar que el nombre no esté vacío
                    if (nombre.isEmpty()) {
                        System.out.println("⚠️  El nombre de la tarea no puede estar vacío.");
                        break;
                    }

                    System.out.print("¿Es urgente? (s/n): ");
                    String respuesta = scanner.nextLine().trim().toLowerCase();

                    // ✅ Validar que la respuesta sea s o n
                    if (!respuesta.equals("s") && !respuesta.equals("n")) {
                        System.out.println("⚠️  Respuesta inválida. Escribe 's' para sí o 'n' para no.");
                        break;
                    }

                    boolean esUrgente = respuesta.equals("s");
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
                    // ✅ Manejo de entrada inválida en ID
                    if (scanner.hasNextInt()) {
                        gestor.marcarComoCompletada(scanner.nextInt());
                        scanner.nextLine();
                    } else {
                        System.out.println("⚠️  El ID debe ser un número entero.");
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    // ✅ Manejo de entrada inválida en ID
                    if (scanner.hasNextInt()) {
                        gestor.eliminarTarea(scanner.nextInt());
                        scanner.nextLine();
                    } else {
                        System.out.println("⚠️  El ID debe ser un número entero.");
                        scanner.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("\n👋 Saliendo de SmartTask. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("⚠️  Opción no válida. Elige entre 1 y 5.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}