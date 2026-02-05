public class Tarea {

    private int id;
    private String titulo;
    private String programador;
    private int prioridad;

    public Tarea(int id, String titulo, String programador, int prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.programador = programador;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getProgramador() {
        return programador;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void mostrar() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Programador: " + programador);
        System.out.println("Prioridad: " + prioridad);
    }
}
