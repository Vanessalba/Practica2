
package practica2;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Practica2 extends JFrame {
    //clientes

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    int indice=0;

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel puntosLabel;

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    private JTextField puntosField;

    private JButton atrasButton;
    private JButton adelanteButton;

    private boolean focusIsSet = false;

    public Practica2() {
        super("Practica");
        clientes.add(new Cliente(1, "Ana", 20, 150.5));
        clientes.add(new Cliente(2, "Luis", 25, 200.75));
        clientes.add(new Cliente(3, "Maria", 30, 350.0));

        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero: ");
        nombreLabel = new JLabel("Nombre: ");
        edadLabel = new JLabel("Edad: ");
        puntosLabel = new JLabel("Puntos: ");

        //Campo donde vamos a introducir el número
        numeroField = new JTextField(10);
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);

        edadField = new JTextField(10);
        edadField.setEditable(false);
        edadField.setForeground(Color.BLUE);
       
        puntosField = new JTextField(10);
        puntosField.setEditable(false);
        puntosField.setForeground(Color.GREEN);

        //establezco los valores para que aparezca el primer cliente tras ejecutar
        nombreField.setText(clientes.get(indice).getNombre());
        numeroField.setText(String.valueOf(clientes.get(indice).getNumero()));
        edadField.setText(String.valueOf(clientes.get(indice).getEdad()));
        puntosField.setText(String.valueOf(clientes.get(indice).getPuntos()));
     
        atrasButton = new JButton("ATRAS");
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.print("atras");
                if(indice>0){
                    indice--;                    
                }
               
                nombreField.setText(clientes.get(indice).getNombre());
                numeroField.setText(String.valueOf(clientes.get(indice).getNumero()));
                edadField.setText(String.valueOf(clientes.get(indice).getEdad()));
                puntosField.setText(String.valueOf(clientes.get(indice).getPuntos()));
               
            }
        });

        adelanteButton = new JButton("SIGUIENTE");
        adelanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                System.out.print("siguiente");
                if(indice < clientes.size()-1){
                    indice++;
                }
               
                nombreField.setText(clientes.get(indice).getNombre());
                numeroField.setText(String.valueOf(clientes.get(indice).getNumero()));
                edadField.setText(String.valueOf(clientes.get(indice).getEdad()));
                puntosField.setText(String.valueOf(clientes.get(indice).getPuntos()));
            }
        });

        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);
        labelPane.add(puntosLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        fieldPane.add(puntosField);

        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new GridLayout(1, 0));
        botonesPane.add(atrasButton);
        botonesPane.add(adelanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane, BorderLayout.SOUTH);

        setContentPane(contentPane);  //this.setContentPane(contentPane);
        // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Practica2 app = new Practica2();

                //Este WindowListener ya solo sirve para poner el foco.
                //(Para cerrar la ventana ya no hace falta: setDefaultCloseOperation.)
                app.addWindowListener(new WindowAdapter() {
                    //Pone el focus (foco de atencion)
                    public void windowActivated(WindowEvent e) {

                    }
                });
                app.pack();
                app.setVisible(true);
            }
        });
    }

}
