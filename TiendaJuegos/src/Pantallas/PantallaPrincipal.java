package Pantallas;

/**
 *
 * @author Alexis
 */

import javax.swing.*;
import java.awt.*;


public class PantallaPrincipal extends JFrame {

    public PantallaPrincipal() {
        setTitle("Tienda de Juegos 🎮");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Juegos
        JMenu menuJuegos = new JMenu("Juegos");

        JMenuItem itemXbox = new JMenuItem("Agregar juego de Xbox");
        JMenuItem itemPlay = new JMenuItem("Agregar juego de PlayStation");
        JMenuItem itemSwitch = new JMenuItem("Agregar juego de Nintendo Switch");

        menuJuegos.add(itemXbox);
        menuJuegos.add(itemPlay);
        menuJuegos.add(itemSwitch);

        // Menú Carrito
        JMenu menuCarrito = new JMenu("Carrito");
        JMenuItem itemVerCarrito = new JMenuItem("Ver carrito 🛒");
        
        menuCarrito.add(itemVerCarrito);
        
        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");

        menuAyuda.add(itemAcercaDe);
        
        // Agregar menús a la barra
        menuBar.add(menuJuegos);
        menuBar.add(menuCarrito);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        // Panel central bonito
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblBienvenida = new JLabel("✨ Bienvenido a la Tienda de Juegos ✨", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblBienvenida, BorderLayout.CENTER);

        add(panel);

        // Acciones de menú
        itemXbox.addActionListener(e -> new FormXbox().setVisible(true));
        itemPlay.addActionListener(e -> new FormPlay().setVisible(true));
        itemSwitch.addActionListener(e -> new FormSwitch().setVisible(true));
        itemVerCarrito.addActionListener(e -> new FormCarrito().setVisible(true));
        // Acción del "Acerca de"
        itemAcercaDe.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Tienda de Juegos v3.0\nHecho por Kevin, Dainer y Breyner",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PantallaPrincipal().setVisible(true);
        });
    }
}
