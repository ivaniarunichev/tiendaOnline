import java.util.LinkedList;
import java.util.Queue;

public class ColaPedidos {
    private Queue<String> pedidos = new LinkedList<String>();
    private int capacidad;

    public ColaPedidos(int capacidad) {
        this.capacidad = capacidad;
    }

    public synchronized void nuevoPedido(String pedido) throws InterruptedException {
        //Si la cola esta llena, se espera
        while(pedidos.size() == capacidad){
            //Espera si la colaPedidos esta lleno
            wait();
        }

        //Si hay especio se añade a la cola
        pedidos.add(pedido);
        System.out.println("Nuevo pedido: " + pedido);

        //Avisamos a los consumidores
        notifyAll();
    }

    public synchronized String procesarPedido() throws InterruptedException {
        //Mientras la cola esta vacia el trajador debe esperar
        while(pedidos.isEmpty()){
            //El trabajador debe esperar
            wait();
        }
        String pedido = String.valueOf(pedidos.poll());
        System.out.println("Pedido procesado: " + pedido);

        //Avisamos al trabajador de que hay pedido
        notifyAll();

        return pedido;
    }
}
