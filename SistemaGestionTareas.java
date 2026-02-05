public class SistemaGestionTareas {
    
    public static void main(String[] args) {
        // PUNTO 3.1: Crear una instancia de ColaTareas
        ColaTareas cola = new ColaTareas();
        
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE GESTIÓN DE TAREAS - FIFO        ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        
        // PUNTO 3.2: Agregar al menos 5 tareas con diferentes prioridades
        System.out.println("\n>>> Agregando tareas a la cola...\n");
        
        cola.encolar(new Tarea(1, "Corregir bug en login", "Carlos", 3));
        cola.encolar(new Tarea(2, "Actualizar documentación", "Ana", 1));
        cola.encolar(new Tarea(3, "Implementar API REST", "Luis", 3));
        cola.encolar(new Tarea(4, "Revisar código", "María", 2));
        cola.encolar(new Tarea(5, "Optimizar base de datos", "Pedro", 3));
        
        // Separador
        System.out.println("\n" + "=".repeat(50));
        
        // PUNTO 3.3: Mostrar la tarea que está al frente de la cola
        System.out.println("\n>>> Próxima tarea a realizar:\n");
        Tarea tareaFrente = cola.verFrente();
        if (tareaFrente != null) {
            tareaFrente.mostrar();
        }
        
        // Separador
        System.out.println("\n" + "=".repeat(50));
        
        // PUNTO 3.4: Atender (desencolar) las dos primeras tareas
        System.out.println("\n>>> Atendiendo tareas...\n");
        
        System.out.println("Atendiendo primera tarea:");
        Tarea tarea1 = cola.desencolar();
        if (tarea1 != null) {
            System.out.println("  ✓ Tarea completada: " + tarea1.getTitulo() + " (ID: " + tarea1.getId() + ")");
        }
        
        System.out.println("\nAtendiendo segunda tarea:");
        Tarea tarea2 = cola.desencolar();
        if (tarea2 != null) {
            System.out.println("  ✓ Tarea completada: " + tarea2.getTitulo() + " (ID: " + tarea2.getId() + ")");
        }
        
        // Separador
        System.out.println("\n" + "=".repeat(50));
        
        // PUNTO 3.5: Buscar y mostrar todas las tareas con prioridad ALTA (3)
        cola.buscarPorPrioridad(3);
        
        // Separador
        System.out.println("\n" + "=".repeat(50));
        
        // PUNTO 3.6: Mostrar cuántas tareas quedan pendientes en la cola
        System.out.println("\n>>> Estado final de la cola:\n");
        System.out.println("Tareas pendientes: " + cola.contarTareas());
        
        // Información adicional: Mostrar todas las tareas restantes
        System.out.println("\nDetalle de tareas pendientes:");
        if (cola.contarTareas() > 0) {
            cola.mostrarTodasLasTareas();
        } else {
            System.out.println("  No hay tareas pendientes.");
        }
        
        // Separador final
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n>>> Demostración adicional de funcionalidades:\n");
        
        // Demostrar búsqueda con otras prioridades
        System.out.println("Buscando tareas con prioridad MEDIA (2):");
        cola.buscarPorPrioridad(2);
        
        System.out.println("\nBuscando tareas con prioridad BAJA (1):");
        cola.buscarPorPrioridad(1);
        
        // Procesar las tareas restantes
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n>>> Procesando todas las tareas restantes:\n");
        
        int tareasProcesadas = 0;
        while (!cola.estaVacia()) {
            Tarea tarea = cola.desencolar();
            if (tarea != null) {
                tareasProcesadas++;
                System.out.println("Procesando tarea #" + tareasProcesadas + ":");
                System.out.println("  " + tarea.getTitulo() + " - Asignado a: " + tarea.getProgramador());
            }
        }
        
        System.out.println("\n✓ Todas las tareas han sido procesadas.");
        System.out.println("Tareas pendientes: " + cola.contarTareas());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n¡Sistema de Gestión de Tareas finalizado!");
    }
}
