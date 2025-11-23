package clases;

public class JuegoPlay extends Juego {
    private String versionPlay;

    public JuegoPlay(String id, String nombre, double precio, PrecioStrategy strategy, String versionPlay) {
        super(id, nombre, precio, strategy);
        this.versionPlay = versionPlay;
    }


    public String getVersionPlay() { return versionPlay; }
    public void setVersionPlay(String versionPlay) { this.versionPlay = versionPlay; }

    @Override
    public String getConsola() {
        return versionPlay;
    }

    @Override
    public void inicializar() {
        setNombre("");
        setPrecio(0);
        versionPlay = "";
    }

    @Override
    public void guardar() {
        System.out.println("Juego Play guardado: " + toString());
    }

    @Override
    public double calcular() {
        return calcularPrecio();
    }

    @Override
    public String toString() {
        return "[Play " + versionPlay + "] " + super.toString();
    }
}
