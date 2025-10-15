import java.nio.Buffer;

public class MainPedidos {



    public static void main(String[] args) throws InterruptedException {

        ColaPedidos colaPedidos = new ColaPedidos();


        //Crear Productores (clientes)
        ProductorPedidos[] productorPedidos = new ProductorPedidos[10];
        for(int i = 0; i< productorPedidos.length;i++){
            productorPedidos[i] = new ProductorPedidos(colaPedidos);
        }

        //Crear Consumidores (trabajadores)
        ConsumidorPedidos[] consumidorPedidos = new ConsumidorPedidos[5];
        for(int i = 0; i< consumidorPedidos.length;i++){
            consumidorPedidos[i] = new ConsumidorPedidos(colaPedidos);
        }

        for(ConsumidorPedidos c : consumidorPedidos){
            c.start();
        }
        for(ProductorPedidos p : productorPedidos){
            p.start();
        }

        for(ConsumidorPedidos c : consumidorPedidos){
            c.join();
        }
        for(ProductorPedidos p : productorPedidos){
            p.join();
        }

        System.out.println("Todos los productores y los consumidores han sido creados: ");
    }
}