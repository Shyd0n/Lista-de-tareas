public class Tarea {
    private String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    public String MostrarTarea() {
       return(nombre +"\n");
    }

    public String getNombre() {
        return nombre;
    }

}
