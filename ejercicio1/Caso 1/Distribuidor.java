public class Distribuidor extends Thread {
    private final Buffer deposito;
    private final String tipoProducto;

    public Distribuidor(Buffer deposito, String tipoProducto) {
        this.deposito = deposito;
        this.tipoProducto = tipoProducto;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (deposito) {
                    String producto = deposito.retirar(tipoProducto);
                    if (producto != null) {
                        // Procesa el producto
                        System.out.println("Se retiró el producto {producto}");
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
