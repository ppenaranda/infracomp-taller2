
import java.util.Scanner;

public class Cliente extends Thread{
    private final Pastel pastel;
    private final double radio;
    private final double alto;
    private final String sabor;
    private final String color;



    public Cliente(double radio, double alto, String sabor, String color){
       this.radio = radio;
       this.alto = alto;
       this.sabor = sabor;
       this.color =  color;
        this.pastel = new Pastel();
    }

    @Override
    public void run(){
        synchronized (pastel){
            pastel.hacerPedido(radio, alto, sabor, color);
            System.out.println("El cliente ha pedido un pastel");

            try {
                System.out.println("El  cliente espera a que se le entregue el pastel");

                pastel.wait();
            } catch (InterruptedException ex) {}

            System.out.println("El cliente ya recibió su pastel");
            System.out.println("Detalles del pastel: " + pastel.consultarDetallesPedido());

        }
    }

    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Ingrese el radio del pastel: (cm)");
        double radio = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el alto del pastel: (cm)");
        double alto = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el sabor del pastel: ");
        String sabor = scanner.nextLine();
        System.out.println("Ingrese el color del pastel: ");
        String color = scanner.nextLine();
        Cliente cliente = new Cliente(radio, alto, sabor, color);

        cliente.start();
        Pastelero pastelero = new Pastelero(cliente.pastel);
        pastelero.start();
    }
}