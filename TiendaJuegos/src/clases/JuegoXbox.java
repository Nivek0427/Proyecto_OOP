package clases;

public class JuegoXbox extends Juego {
    private String versionXbox;

    public JuegoXbox(String id, String nombre, double precio, PrecioStrategy strategy, String versionXbox) {
        super(id, nombre, precio, strategy);
        this.versionXbox = versionXbox;
    }

    public String getVersionXbox() { return versionXbox; }
    public void setVersionXbox(String versionXbox) { this.versionXbox = versionXbox; }

    @Override
    public String getConsola() {
        return versionXbox;
    }

    @Override
    public void inicializar() {
        setNombre("");
        setPrecio(0);
        versionXbox = "";
    }

    @Override
    public void guardar() {
        System.out.println("Juego Xbox guardado: " + toString());
    }

    @Override
    public double calcular() {
        return calcularPrecio();
    }

    @Override
    public String toString() {
        return "[Xbox " + versionXbox + "] " + super.toString();
    }
}
