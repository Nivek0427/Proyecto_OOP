package clases;

/**
 *
 * @author Alexis
 */

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private static List<Juego> juegos = new ArrayList<>();

    public static void agregarJuego(Juego juego) {
        juegos.add(juego);
    }

    // Devuelve la lista 
    public static List<Juego> getJuegos() {
        return juegos;
        // return new ArrayList<>(juegos);
    }

    public static double calcularTotal() {
        return juegos.stream().mapToDouble(Juego::getPrecio).sum();
    }

    public static void vaciar() {
        juegos.clear();
    }
}
