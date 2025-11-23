package Pantallas;

/**
 *
 * @author Alexis
 */

import clases.Carrito;
import clases.Juego;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormCarrito extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTotal;
    private JButton btnVaciar, btnPagar;

    public FormCarrito() {
        setTitle("Carrito de Compras 🛒");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo de tabla
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Consola", "Precio"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        // Panel inferior con total y botones
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: $0.0");
        btnVaciar = new JButton("Vaciar carrito");
        btnPagar = new JButton("Pagar");

        panelInferior.add(lblTotal);
        panelInferior.add(btnVaciar);
        panelInferior.add(btnPagar);

        add(scroll, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Cargar los juegos del carrito
        actualizarTabla();

        // Acción de vaciar
        btnVaciar.addActionListener(e -> {
            Carrito.vaciar();
            actualizarTabla();
        });

        // Acción de pagar
        btnPagar.addActionListener(e -> {
            if (Carrito.getJuegos().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El carrito está vacío.");
            } else {
                new FormFactura().setVisible(true);
                dispose(); // cerramos el carrito
            }
        });
    }

    private void actualizarTabla() {
    modelo.setRowCount(0); // limpiar tabla
    double total = 0;

    for (Juego j : Carrito.getJuegos()) {
        double precioCalc = j.calcularPrecio(); // ✔ Usa Strategy

        modelo.addRow(new Object[]{
                j.getId(),
                j.getNombre(),
                j.getConsola(),
                precioCalc
        });

        total += precioCalc;
    }

    lblTotal.setText("Total: $" + total);
}

}
