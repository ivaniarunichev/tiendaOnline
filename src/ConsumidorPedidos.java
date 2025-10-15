public class ConsumidorPedidos extends Thread {

    private ColaPedidos colaPedido;

    public ConsumidorPedidos(ColaPedidos colaPedido) {
        this.colaPedido = colaPedido;
    }

    private void facturaPedidos(){

    }

    public void run(){


        try {
            System.out.println(getName()+" Iniciando Pedido...");

            String pedido = colaPedido.procesarPedido();

            Thread.sleep(1000);

            System.out.println(getName()+" Pedido finalizado.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
