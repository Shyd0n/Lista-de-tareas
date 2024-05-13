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

    public void MostrarTablero() {
        System.out.println("|| TABLERO " + this.nombre.toUpperCase() + " ||");
        for (int i = 0 ; i <= tareas.size() - 1 ; i++){
            tareas.get(i).MostrarTarea();
        }
    }

    public String getNombre() {
        return nombre;
    }

}
