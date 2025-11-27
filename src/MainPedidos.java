import java.nio.Buffer;

public class MainPedidos {
    public static void main(String[] args) throws InterruptedException {

        ColaPedidos cola = new ColaPedidos(5); // capacidad máxima 5

        // Crear productores
        for (int i = 1; i <= 10; i++) {
            new ProductorPedidos(cola, "Cliente" + i).start();
        }

        // Crear consumidores
        for (int i = 1; i <= 5; i++) {
            new ConsumidorPedidos(cola, "Trabajador" + i).start();
        }
    }
}