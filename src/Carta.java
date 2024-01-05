import java.util.Random;

public class Carta {
    private String nombre_carta;

    public String getNombre_carta() {
        return nombre_carta;
    }

    public void setNombre(String nombre_carta) {
        this.nombre_carta = nombre_carta;
    }

    public Carta(String nombre_carta) {
        this.nombre_carta = nombre_carta;
    }

    public void mostrarDescripcion() {
        System.out.println(" ESTA ES LA CARTA QUE SACASTE " + getNombre_carta());
    }

    public static Carta[] jugar() {
        Carta[] cartas = new Carta[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int numeroCarta = i + 1;
            if (random.nextBoolean()) {
                cartas[i] = new CartaNumerica("CARTA NUMERICA " + numeroCarta, numeroCarta);
            } else {
                cartas[i] = new CartaEspecial("CARTA ESPECIAL " + numeroCarta);
            }
        }

        return cartas;
    }
}

class CartaNumerica extends Carta {
    private int numero;

    public CartaNumerica(String nombre_carta, int numero) {
        super(nombre_carta);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

class CartaEspecial extends Carta {
    public CartaEspecial(String nombre_carta) {
        super(nombre_carta);
    }

    public void activarEfectoEspecial() {
        System.out.println("EFECTO DE LA CARTA " + getNombre_carta());
    }

    @Override
    public void mostrarDescripcion() {
        super.mostrarDescripcion();
        System.out.println("NUMERO ESPECIAL:  " + getNombre_carta());
    }
}

class Main {
    public static void main(String[] args) {
        Carta[] cartas = Carta.jugar();
        boolean detener = false;

        for (Carta carta : cartas) {
            carta.mostrarDescripcion();


            if (detener) {
                break;
            }

        }
    }
}