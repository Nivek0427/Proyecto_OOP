package Pantallas;

/**
 *
 * @author Alexis
 */

import clases.Carrito;
import clases.JuegoSwitch;
import clases.PrecioNormal;
import java.awt.*;
import javax.swing.*;

public class FormSwitch extends JFrame {
    private JTextField txtId, txtNombre, txtPrecio;
    private JComboBox<String> comboConsola;
    private JButton btnAgregar;

    public FormSwitch() {
        setTitle("Agregar juego de Nintendo Switch");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(crearFila("ID:", txtId = new JTextField(10)));
        panel.add(crearFila("Nombre:", txtNombre = new JTextField(10)));
        panel.add(crearFila("Precio:", txtPrecio = new JTextField(10)));

        // Consolas disponibles
        comboConsola = new JComboBox<>(new String[]{"Switch 1", "Switch 2"});
        panel.add(crearFila("Consola:", comboConsola));

        btnAgregar = new JButton("Añadir al carrito 🛒");
        panel.add(btnAgregar);

        add(panel);

        // Acción
        btnAgregar.addActionListener(e -> {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String precioStr = txtPrecio.getText().trim();

            if (id.isEmpty() || nombre.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Todos los campos deben estar llenos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double precio;
            try {
                precio = Double.parseDouble(precioStr);
                if (precio < 0) {
                    JOptionPane.showMessageDialog(this,
                            "El precio no puede ser negativo.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "El precio debe ser un número válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String consola = (String) comboConsola.getSelectedItem();

            // Crear objeto y añadir al carrito (✔ ahora con strategy)
            JuegoSwitch juego = new JuegoSwitch(id, nombre, precio, new PrecioNormal(), consola);
            Carrito.agregarJuego(juego);

            JOptionPane.showMessageDialog(this,
                    "Juego agregado al carrito con éxito 🛒️",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            dispose();
        });
    }

    private JPanel crearFila(String label, JComponent field) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila.add(new JLabel(label));
        fila.add(field);
        return fila;
    }
}
