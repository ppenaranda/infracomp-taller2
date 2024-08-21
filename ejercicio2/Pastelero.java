
import java.util.Random;

public class Pastelero extends Thread{
    private final Pastel pastel;

    public Pastelero(Pastel pastel){
        this.pastel = pastel;
    }

    @Override
    public void run(){
        synchronized (pastel){
        try {
            while (!pastel.consultarEstadoPedido()){
                System.out.println("El Cliente aún no ha hecho el pedido.  Esperando...");
               Pastelero.sleep(5000);
                }    
            System.out.println("El pastelero empezó a preparar el pastel. ");
            Random rand = new Random();
            int tiempoPrep = rand.nextInt(11) + 5;
            System.out.println("El tiempo de preparación aproximado es de: "  + tiempoPrep + " segundos.");

            Pastelero.sleep(tiempoPrep * 1000);

            System.out.println("El pastelero terminó de preparar el pastel. ");
            pastel.notify();

            } catch (InterruptedException ex) {}
        }
    }
}