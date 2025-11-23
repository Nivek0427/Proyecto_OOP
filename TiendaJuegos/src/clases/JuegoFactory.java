package clases;

public class JuegoFactory {

    public static Juego crearJuego(
            String tipo,
            String id,
            String nombre,
            double precio,
            PrecioStrategy strategy,
            String versionConsola
            
    ) {

        if (tipo == null) throw new IllegalArgumentException("Tipo nulo.");

        tipo = tipo.toLowerCase();

        switch (tipo) {
            case "play", "playstation" -> {
                return new JuegoPlay(id, nombre, precio, strategy, versionConsola);
            }
            case "xbox" -> {
                return new JuegoXbox(id, nombre, precio, strategy, versionConsola);
            }
            case "switch", "nintendo" -> {
                return new JuegoSwitch(id, nombre, precio, strategy, versionConsola);
            }
            default -> throw new IllegalArgumentException("Tipo de juego no válido: " + tipo);
        }
    }
}
