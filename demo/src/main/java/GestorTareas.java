
import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {
    private List<Tarea> listaTareas = new ArrayList<>();

    @Override
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        System.out.println("Tarea agregada con éxito.");
    }

    @Override
    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            listaTareas.forEach(System.out::println);
        }
    }

    @Override
    public void eliminarTarea(int id) {
        listaTareas.removeIf(t -> t.getId() == id);
        System.out.println("Tarea con ID " + id + " eliminada.");
    }

    @Override
    public void marcarComoCompletada(int id) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) {
                t.setCompletado(true);
                System.out.println("Tarea marcada como completada.");
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }

    public int getSiguienteId() {
        return listaTareas.size() + 1;
    }
}