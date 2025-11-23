package clases;

/**
 *
 * @author Alexis
 */

public abstract class Juego implements OperacionesJuego {
    private String id;
    private String nombre;
    private double precio;
    protected PrecioStrategy precioStrategy;

    public Juego(String id, String nombre, double precio, PrecioStrategy strategy) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.precioStrategy = strategy;
    }

    // Encapsulamiento
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public PrecioStrategy getPrecioStrategy() {
        return this.precioStrategy;
    }

    // Sobrecarga: precio normal
    // Sobrecarga: precio normal o strategy
public double calcularPrecio() {
    if (precioStrategy != null) {
        return precioStrategy.calcularPrecio(this);  // ✔ Correcto
    }
    return precio;
}


    // Sobrecarga: con descuento directo
    public double calcularPrecio(double descuento) {
        return precio - (precio * descuento);
    }

    // Cada subclase devuelve su consola (Xbox, Play, Nintendo, etc.)
    public abstract String getConsola();

    @Override
    public String toString() {
        return getNombre() + " - $" + calcularPrecio() + " (" + getConsola() + ")";
    }

    // Métodos de la interfaz
    @Override
    public abstract void inicializar();

    @Override
    public abstract void guardar();

    @Override
    public abstract double calcular();
}
