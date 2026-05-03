public interface Accionable {
    void agregarTarea(Tarea tarea);
    void listarTareas();
    void eliminarTarea(int id);
    void marcarComoCompletada(int id);
}
    