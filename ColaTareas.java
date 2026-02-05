public class ColaTareas {

    private Tarea[] cola;
    private int frente;
    private int finalCola;
    private int contador;

    public ColaTareas() {
        cola = new Tarea[20];
        frente = 0;
        finalCola = -1;
        contador = 0;
    }

    public boolean estaVacia() {
        return contador == 0;
    }

    public boolean estaLlena() {
        return contador == cola.length;
    }

    public void encolar(Tarea tarea) {
        if (estaLlena()) {
            System.out.println("❌ La cola está llena");
            return;
        }
        finalCola++;
        cola[finalCola] = tarea;
        contador++;
    }

    public Tarea desencolar() {
        if (estaVacia()) {
            System.out.println("❌ La cola está vacía");
            return null;
        }
        Tarea tarea = cola[frente];
        frente++;
        contador--;
        return tarea;
    }

    public Tarea verFrente() {
        if (estaVacia()) {
            return null;
        }
        return cola[frente];
    }

    public int contarTareas() {
        return contador;
    }

    // 🔍 Método adicional
    public void buscarPorPrioridad(int prioridad) {
        if (estaVacia()) {
            System.out.println("No hay tareas en la cola.");
            return;
        }

        int encontradas = 0;
        System.out.println("Buscando tareas con prioridad " + prioridad + ":");

        for (int i = frente; i <= finalCola; i++) {
            if (cola[i].getPrioridad() == prioridad) {
                System.out.println("- " + cola[i].getTitulo() +
                                   " (" + cola[i].getProgramador() + ")");
                encontradas++;
            }
        }

        if (encontradas == 0) {
            System.out.println("No se encontraron tareas con esa prioridad.");
        } else {
            System.out.println("Total encontradas: " + encontradas + " tareas");
        }
    }

    public void mostrarTodasLasTareas() {
    if (estaVacia()) {
        System.out.println("No hay tareas en la cola.");
        return;
    }

    System.out.println("Tareas en la cola:");
    for (int i = frente; i <= finalCola; i++) {
        cola[i].mostrar();
        System.out.println("-----------------------------");
    }
}

}