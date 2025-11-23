package clases;

public class PrecioDescuento implements PrecioStrategy {

    private double descuento; // 0.10 = 10%

    public PrecioDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecio(Juego juego) {
        double base = juego.getPrecio();
        return base - (base * descuento);
    }
}
