import java.util.ArrayList;

public class Tablero {
    private String nombre;
    ArrayList<Tarea> tareas = new ArrayList<Tarea>();
    
    public Tablero(String nombre) {
        this.nombre = nombre;
    }

    public void AñadirTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public String MostrarTablero() {
        String tablero = "|| TABLERO " + this.nombre.toUpperCase() + " ||\n";

        for (int i = 0 ; i <= tareas.size() - 1 ; i++){
            tablero = tablero + tareas.get(i).MostrarTarea();
        }
        return tablero;
    }

    public String getNombre() {
        return nombre;
    }

}
