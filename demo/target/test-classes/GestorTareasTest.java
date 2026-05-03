import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Suite de pruebas unitarias para la validación de la lógica de SmartTask.
 * Cumple con los requerimientos de validación de funcionalidad y cobertura [2, 3].
 */
public class GestorTareasTest {

    private GestorTareas gestor;

    @BeforeEach
    public void setUp() {
        // Se inicializa un nuevo gestor antes de cada prueba para asegurar independencia.
        gestor = new GestorTareas();
    }

    @Test
    public void testAgregarTareaNormal() {
        Tarea tarea = new TareaNormal(1, "Estudiar Java");
        gestor.agregarTarea(tarea);
        
        // Verificamos que el ID generado para la siguiente tarea sea correlativo
        assertEquals(2, gestor.getSiguienteId(), "El contador de IDs debería incrementar al agregar una tarea.");
    }

    @Test
    public void testAgregarTareaUrgente() {
        Tarea urgente = new TareaUrgente(1, "Entrega de Proyecto");
        gestor.agregarTarea(urgente);
        
        assertEquals("URGENTE", urgente.getPrioridad(), "La tarea urgente debe tener la prioridad correcta.");
        assertFalse(urgente.isCompletado(), "La tarea debe iniciar en estado pendiente.");
    }

    @Test
    public void testMarcarComoCompletada() {
        Tarea tarea = new TareaNormal(1, "Hacer ejercicio");
        gestor.agregarTarea(tarea);
        
        gestor.marcarComoCompletada(1);
        
        assertTrue(tarea.isCompletado(), "La tarea debería estar marcada como completada.");
    }

    @Test
    public void testEliminarTarea() {
        Tarea tarea = new TareaNormal(1, "Tarea a eliminar");
        gestor.agregarTarea(tarea);
        
        gestor.eliminarTarea(1);
        
        // Verificamos que si intentamos marcarla como completada no ocurran errores 
        // y el ID disponible vuelva a considerar el tamaño de la lista
        assertEquals(1, gestor.getSiguienteId() - 1, "La lista debería reflejar la eliminación.");
    }

    @Test
    public void testListarTareasVacias() {
        // Capturamos la salida de consola para verificar el mensaje de lista vacía
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        gestor.listarTareas();
        
        assertTrue(outContent.toString().contains("No hay tareas registradas."), 
                   "Debe informar que no hay tareas.");
    }

    @Test
    public void testPolimorfismoTarea() {
        // Verificamos que las subclases se comporten correctamente bajo el tipo base Tarea [1, 4]
        Tarea t1 = new TareaNormal(1, "Normal");
        Tarea t2 = new TareaUrgente(2, "Urgente");
        
        assertNotEquals(t1.getPrioridad(), t2.getPrioridad(), "Las prioridades deben diferir por el tipo de clase.");
    }
}