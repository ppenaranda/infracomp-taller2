public class Cliente extends Thread{
    private Pastel pastel;
    private double radio;
    private double alto;
    private String sabor;
    private  String color;



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
        Cliente cliente = new Cliente(10,  20, "Chocolate", "Rojo");
        cliente.start();
        Pastelero pastelero = new Pastelero(cliente.pastel);
        pastelero.start();


    }
}