public abstract class Tarea {
    private int id;
    private String nombre;
    private String prioridad;
    private boolean completado;

    public Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
    public String getPrioridad() { return prioridad; }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " | Prioridad: " + prioridad + 
               " | Estado: " + (completado ? "Completada" : "Pendiente");
    }
}