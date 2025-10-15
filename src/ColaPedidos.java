import java.util.LinkedList;
import java.util.Queue;

public class ColaPedidos {
    private Queue<Integer> cola = new LinkedList<Integer>();
    private int capacidad=5;

    public synchronized void nuevoPedido(int pedido) throws InterruptedException {
        //Si la cola esta llena, se espera
        while(cola.size() == capacidad){
            //Espera si la colaPedidos esta lleno
            wait();
            //hola
        }

        //Si hay especio se añade a la cola
        cola.add(pedido);
        System.out.println("Pedido cola: " + pedido);

        //Avisamos a los consumidores
        notifyAll();
    }

    public synchronized String procesarPedido() throws InterruptedException {
        //Mientras la cola esta vacia el trajador debe esperar
        while(cola.isEmpty()){
            //El trabajador debe esperar
            wait();
        }
        String pedido = String.valueOf(cola.poll());
        System.out.println("Pedido cola: " + pedido);

        //Avisamos al trabajador de que hay pedido
        notifyAll();

        return pedido;
    }
    private Queue<Integer> getCola() {
        return cola;
    }
}
