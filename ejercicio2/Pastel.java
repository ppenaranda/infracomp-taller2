public class Pastel {
    private double radio;
    private double alto;
    private String sabor;
    private String color;
    private boolean pedidoRealizado;

    public Pastel(){
        this.pedidoRealizado = false;
    }

    public synchronized void hacerPedido(double radio, double alto, String  sabor, String color) {
        this.radio = radio;
        this.alto = alto;
        this.sabor = sabor;
        this.color = color;
        this.pedidoRealizado = true;
    }

    public synchronized String consultarDetallesPedido(){
        if (pedidoRealizado){
            return "\n Alto:  " + alto + "cm,\n Radio: " + radio + "cm, \n Sabor: " + sabor + "\n color:  " + color ;

        } else {
            return "No hay pedido realizado";
        }
    }

    public synchronized Boolean consultarEstadoPedido(){
        return pedidoRealizado;
    }

}
