package clases;

public class PrecioNormal implements PrecioStrategy {

    @Override
    public double calcularPrecio(Juego juego) {
        return juego.getPrecio();
    }
}
