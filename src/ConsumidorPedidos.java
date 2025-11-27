import java.io.IOException;

public class ConsumidorPedidos extends Thread {

    private ColaPedidos cola;
    private String nombreTrabajador;

    public ConsumidorPedidos(ColaPedidos cola, String nombreTrabajador){
        this.cola = cola;
        this.nombreTrabajador = nombreTrabajador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String pedido = cola.procesarPedido();
                System.out.println(nombreTrabajador + " prepara " + pedido);
                Thread.sleep(1000); // simula tiempo de trabajo

                // Llamada al proceso externo generaFactura.jar
                generarFactura(pedido);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generarFactura(String pedido) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "generaFactura.jar", pedido);
            pb.inheritIO();
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
