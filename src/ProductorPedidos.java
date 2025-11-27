public class ProductorPedidos extends Thread {
    private ColaPedidos cola;
    private String nombreCliente;


    //Constructor compartido
    public ProductorPedidos(ColaPedidos cola, String nombreCliente){
        this.cola = cola;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        try {
            //Bucle generando como ejemplo 100 pedidos
            for (int i = 1; i <= 10; i++) {
                //Y por cada pedido se tendrá un nombre con el siguiente estilo
                String pedido = "Pedido " + i + " de " + nombreCliente;

                //Lo mostramos por pantalla
                cola.nuevoPedido(pedido);

                //Despues de cada pedido se duerme un tiempo
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
