import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {
    private List<Tarea> listaTareas = new ArrayList<>();
    private int contadorId = 1; // ✅ Contador independiente del tamaño de la lista

    @Override
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        System.out.println("✅ Tarea agregada con éxito.");
    }

    @Override
    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("📋 No hay tareas registradas.");
        } else {
            System.out.println("\n📋 Lista de tareas:");
            System.out.println("─".repeat(50));
            listaTareas.forEach(System.out::println);
            System.out.println("─".repeat(50));
        }
    }

    @Override
    public void eliminarTarea(int id) {
        boolean encontrada = listaTareas.removeIf(t -> t.getId() == id);
        if (encontrada) {
            System.out.println("🗑️  Tarea con ID " + id + " eliminada.");
        } else {
            System.out.println("⚠️  No se encontró una tarea con ID " + id + ".");
        }
    }

    @Override
    public void marcarComoCompletada(int id) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) {
                t.setCompletado(true);
                System.out.println("✅ Tarea marcada como completada.");
                return;
            }
        }
        System.out.println("⚠️  Tarea con ID " + id + " no encontrada.");
    }

    public int getSiguienteId() {
        return contadorId++; // ✅ Siempre incrementa, nunca se repite
    }
}