import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main (String[] args) {
        String nombre;
        String descripcion;
        int comp;
        ArrayList<Tablero> tableros = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca uno de los siguientes números:");
            System.out.println("1: Crear un nuevo tablero.");
            System.out.println("2: Modificar un tablero.");
            System.out.println("3: Mostrar un tablero.");
            System.out.println("4: Salir del programa.");
            comp = sc.nextInt();
            int i;
            int e;

            switch(comp) {
                case 1:
                    System.out.println("Introduzca el nombre del tablero a crear:");
                    sc.nextLine();
                    nombre = sc.nextLine();
                    tableros.add(new Tablero(nombre));
                    System.out.println("Tablero " + nombre + " creado.");
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del tablero a modificar:");
                    sc.nextLine();
                    nombre = sc.nextLine();
                    int comp2;
                    for(i = 0 ; i < tableros.size() ; i++){
                        if (tableros.get(i).getNombre().equals(nombre)) {
                            break;
                        }
                    }
                    if (i == tableros.size()) {
                        System.out.println("No existe tablero con ese nombre.");
                    }
                    else {
                        do{
                            System.out.println("Introduzca uno de los siguientes números:"); 
                            System.out.println("1: Añadir una nueva tarea.");
                            System.out.println("2: Eliminar una tarea.");
                            System.out.println("3: Salir del modo de edición de tablero.");
                            comp2 = sc.nextInt();

                            switch(comp2) {
                                case 1:
                                    System.out.println("Introduzca el nombre de la tarea:");
                                    sc.nextLine();
                                    nombre = sc.nextLine();
                                    System.out.println("Introduzca la descripción de la tarea:");
                                    descripcion = sc.nextLine();
                                    tableros.get(i).AñadirTarea(new Tarea(nombre , descripcion));
                                    System.out.println("La tarea " + nombre + " ha sido creada.");
                                    break;
                                case 2:
                                    boolean tarExiste = false;
                                    System.out.println("Introduzca el nombre de la tarea a eliminar:");
                                    sc.nextLine();
                                    nombre = sc.nextLine();
                                    for(e = 0 ; e < tableros.get(i).tareas.size() ; e++) {
                                        if (tableros.get(i).tareas.get(e).getNombre().equals(nombre)) {
                                            tableros.get(i).tareas.remove(e);
                                            tarExiste = true;
                                            System.out.println("La tarea " + nombre + " ha sido eliminada.");
                                            break;
                                        }
                                    }
                                    if (!tarExiste){
                                        System.out.println("No existe la tarea " + nombre + ".");
                                    }
                                    break;
                                case 3: 
                                    System.out.println("Saliendo del modo de edición de tablero."); 
                            }
                        }while(comp2 != 3);
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el nombre del tablero que se quiere visualizar:");
                    sc.nextLine();
                    nombre = sc.nextLine();
                    for(i = 0 ; i < tableros.size() ; i++){
                        if (tableros.get(i).getNombre().equals(nombre)) {
                            break;
                        }
                    }
                    if (i == tableros.size()) {
                        System.out.println("No existe tablero con ese nombre.");
                        break;
                    }
                    tableros.get(i).MostrarTablero();
                    break;
                case 4: 
                    System.out.println("Finalizando programa.");
            }
        }while(comp != 4);

    }

}