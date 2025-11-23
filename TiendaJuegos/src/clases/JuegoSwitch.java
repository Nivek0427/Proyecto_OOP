package clases;

public class JuegoSwitch extends Juego {
    private String versionSwitch;

    public JuegoSwitch(String id, String nombre, double precio, PrecioStrategy strategy , String versionSwitch){
        super(id, nombre, precio, strategy);
        this.versionSwitch = versionSwitch;
    }

    public String getVersionSwitch() { return versionSwitch; }
    public void setVersionSwitch(String versionSwitch) { this.versionSwitch = versionSwitch; }

    @Override
    public String getConsola() {
        return versionSwitch;
    }

    @Override
    public void inicializar() {
        setNombre("");
        setPrecio(0);
        versionSwitch = "";
    }

    @Override
    public void guardar() {
        System.out.println("Juego Switch guardado: " + toString());
    }

    @Override
    public double calcular() {
        return calcularPrecio();
    }

    @Override
    public String toString() {
        return "[Switch " + versionSwitch + "] " + super.toString();
    }
}
