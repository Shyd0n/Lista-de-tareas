public class Tarea {
    private String nombre;
    private String descripcion;

    public Tarea(String nombre , String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void MostrarTarea() {
       System.out.println(nombre + ": " + descripcion);
    }

    public String getNombre() {
        return nombre;
    }

}
