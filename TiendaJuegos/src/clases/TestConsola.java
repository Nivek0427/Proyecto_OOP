package clases;

public class TestConsola {
    public static void main(String[] args) {

        System.out.println("==== PRUEBAS DE JUEGOS CON ESTRATEGIAS DE PRECIO ====\n");

        // Estrategias
        PrecioStrategy normal = new PrecioNormal();
        PrecioStrategy descuento10 = new PrecioDescuento(0.10); // 10%
        PrecioStrategy descuento25 = new PrecioDescuento(0.25); // 25%

        // Crear juegos
        Juego juegoPlay = JuegoFactory.crearJuego(
                "play",
                "001",
                "God of War Ragnarok",
                300000,
                descuento10,
                "ps4"
                
        );

        Juego juegoXbox = JuegoFactory.crearJuego(
                "xbox",
                "002",
                "Halo Infinite",
                250000,
                normal,
                "xbox series x"
        );

        Juego juegoSwitch = JuegoFactory.crearJuego(
                "switch",
                "003",
                "Zelda BOTW",
                280000,
                descuento25,
                "switch 1"
        );

        // Mostrar
        System.out.println("Juego Play: " + juegoPlay + " → Precio final: $" + juegoPlay.calcularPrecio());
        System.out.println("Juego Xbox: " + juegoXbox + " → Precio final: $" + juegoXbox.calcularPrecio());
        System.out.println("Juego Switch: " + juegoSwitch + " → Precio final: $" + juegoSwitch.calcularPrecio());

        System.out.println("\n==== FIN PRUEBA ====");
    }
}
