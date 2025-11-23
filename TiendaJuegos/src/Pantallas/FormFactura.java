package Pantallas;

/**
 *
 * @author Alexis
 */

import clases.Carrito;
import clases.Juego;
import javax.swing.*;
import java.awt.*;

public class FormFactura extends JFrame {
    public FormFactura() {
        setTitle("Factura 🧾");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        double total = 0;
        StringBuilder sb = new StringBuilder("------ FACTURA ------\n\n");

        for (Juego j : Carrito.getJuegos()) {

            double precioCalc = j.calcularPrecio();  // ✔ Usa strategy correctamente

            sb.append("ID: ").append(j.getId())
              .append(" | ").append(j.getNombre())
              .append(" | ").append(j.getConsola())
              .append(" | $").append(precioCalc)
              .append("\n");

            total += precioCalc;
        }

        sb.append("\nTOTAL A PAGAR: $").append(total).append("\n");
        sb.append("\n¡Gracias por tu compra 💖!");

        area.setText(sb.toString());

        add(new JScrollPane(area), BorderLayout.CENTER);

        // Vaciar carrito después de generar la factura
        Carrito.vaciar();
    }
}
