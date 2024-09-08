public class Productor extends Thread {
    private final Buffer deposito;
    private final String tipoProducto;
    private final int numProductos;

    public Productor(Buffer deposito, String tipoProducto, int numProductos) {
        this.deposito = deposito;
        this.tipoProducto = tipoProducto;
        this.numProductos = numProductos;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numProductos; i++) {
                synchronized (deposito) {
                    deposito.almacenar(tipoProducto);
                    deposito.notifyAll(); // Notifica a los operarios internos
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
