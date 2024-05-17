import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfaz extends JFrame{
    ArrayList<Tablero> tablerosLista = new ArrayList<>();
    public Interfaz(){
        setTitle("Lista de tareas");
        setMinimumSize(new Dimension(500 , 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("LISTA DE TAREAS");
        Font fuenteTitulo = new Font("Arial" , Font.PLAIN , 20);
        titulo.setFont(fuenteTitulo);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(titulo , BorderLayout.NORTH);

        JPanel tableros = new JPanel();
        JLabel tablero = new JLabel("Nombre del tablero");
        JTextField nombreTablero = new JTextField(15);
        tableros.add(tablero);
        tableros.add(nombreTablero);

        JPanel tareas = new JPanel();
        JLabel tarea = new JLabel("Nombre de la tarea");
        JTextField nombreTarea = new JTextField(15);
        tareas.add(tarea);
        tareas.add(nombreTarea);

        JPanel contenido = new JPanel(new GridLayout(7 , 1));

        JTextArea panel = new JTextArea();

        JLabel botonesTableroTexto = new JLabel("Botones de tablero");
        botonesTableroTexto.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel botonesTablero = new JPanel();
        JButton botonCrear = new JButton("Crear tablero");
        JButton botonMostrar = new JButton("Mostrar tablero");
        botonesTablero.add(botonCrear);
        botonesTablero.add(botonMostrar);

        JLabel botonesTareaTexto = new JLabel("Botones de tarea");
        botonesTareaTexto.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel botonesTarea = new JPanel();
        JButton botonAñadir = new JButton("Añadir tarea");
        JButton botonEliminar = new JButton("Eliminar tarea");

        botonCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTablero.getText();
                tablerosLista.add(new Tablero(nombre));
                panel.setText("Tablero " + nombre + " creado.");
            }
        });

        botonMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTablero.getText();
                int i = 0;
                for(i = 0; i < tablerosLista.size() ; i++){
                    if (tablerosLista.get(i).getNombre().equals(nombre)) {
                        break;
                    }
                }
                if (i == tablerosLista.size()) {
                    panel.setText("No existe tablero con ese nombre.");
                }
                panel.setText(tablerosLista.get(i).MostrarTablero());
            }
        });

        botonAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTablero.getText();
                int i = 0;
                for(i = 0; i < tablerosLista.size() ; i++){
                    if (tablerosLista.get(i).getNombre().equals(nombre)) {
                        String nombreTareaBoton = nombreTarea.getText();
                        tablerosLista.get(i).AñadirTarea(new Tarea(nombreTareaBoton));
                        panel.setText("La tarea " + nombreTareaBoton + " ha sido creada.");
                        break;
                    }
                }
                if (i == tablerosLista.size()) {
                    panel.setText("No existe tablero con ese nombre.");
                }

            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    boolean tarExiste = false;
                    String nombre = nombreTablero.getText();
                    int i;
                    int o;
                    for(i = 0; i < tablerosLista.size() ; i++){
                        if (tablerosLista.get(i).getNombre().equals(nombre)) {
                            String nombreTareaBoton = nombreTarea.getText();
                            for(o = 0 ; o < tablerosLista.get(i).tareas.size() ; o++) {
                                if (tablerosLista.get(i).tareas.get(o).getNombre().equals(nombreTareaBoton)) {
                                    tablerosLista.get(i).tareas.remove(o);
                                    tarExiste = true;
                                    panel.setText("La tarea " + nombreTareaBoton + " ha sido eliminada.");
                                    break;
                                }
                            }
                            if (!tarExiste){
                                panel.setText("No existe la tarea " + nombreTareaBoton + ".");
                            }
                        }
                    }
            }
        });

        botonesTarea.add(botonAñadir);
        botonesTarea.add(botonEliminar);

        contenido.add(tableros);
        contenido.add(tareas);
        contenido.add(panel);
        contenido.add(botonesTableroTexto);
        contenido.add(botonesTablero);
        contenido.add(botonesTareaTexto);
        contenido.add(botonesTarea);

        setContentPane(contenido);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Interfaz();
    }
}


