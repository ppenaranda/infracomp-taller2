public class OperarioInterno1 extends Thread {
    private final Buffer depositoProd;
    private final Buffer cintaTransportadora;

    public OperarioInterno1(Buffer depositoProd, Buffer cintaTransportadora) {
        this.depositoProd = depositoProd;
        this.cintaTransportadora = cintaTransportadora;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (depositoProd) {
                    if (!depositoProd.estaVacio()) {
                        String producto = depositoProd.retirar(null); // Retira cualquier producto
                        synchronized (cintaTransportadora) {
                            cintaTransportadora.almacenar(producto);
                        }
                    }
                }
                Thread.yield(); // Espera semi-activa
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
