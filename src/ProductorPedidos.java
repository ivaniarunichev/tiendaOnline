public class ProductorPedidos extends Thread {
    private ColaPedidos colaPedidos; //colaPedidos compartido
    private String nombreCliente;

    //Constructor compartido
    public ProductorPedidos(ColaPedidos colaPedidos, String nombreCliente) {
        this.colaPedidos = colaPedidos;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        try {
            //Bucle generando como ejemplo 100 pedidos
            for (int i = 1; i <= 100; i++) {
                //Y por cada pedido se tendrá un nombre con el siguiente estilo
                String pedido = "Pedido " + i + " de " + nombreCliente;

                //Lo mostramos por pantalla
                System.out.println(pedido);
                colaPedidos.nuevoPedido(i);

                //Despues de cada pedido se duerme un tiempo
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
