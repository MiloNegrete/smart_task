import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase abstracta que representa una tarea en el sistema SmartTask.
 * Define los atributos y comportamientos base para todos los tipos de tareas.
 * 
 * @author Milo
 * @version 1.1
 */
public abstract class Tarea {
    private int id;
    private String nombre;
    private String prioridad;
    private boolean completado;
    private LocalDateTime fechaCreacion; // ✅ Fecha de creación

    private static final DateTimeFormatter FORMATO_FECHA = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false;
        this.fechaCreacion = LocalDateTime.now(); // ✅ Se registra al crear la tarea
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
    public String getPrioridad() { return prioridad; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre +
               " | Prioridad: " + prioridad +
               " | Estado: " + (completado ? "✅ Completada" : "⏳ Pendiente") +
               " | Creada: " + fechaCreacion.format(FORMATO_FECHA);
    }
}