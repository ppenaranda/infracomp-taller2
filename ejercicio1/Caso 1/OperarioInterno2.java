public class OperarioInterno2 extends Thread {
    private final Buffer cintaTransportadora;
    private final Buffer depositoDist;

    public OperarioInterno2(Buffer cintaTransportadora, Buffer depositoDist) {
        this.cintaTransportadora = cintaTransportadora;
        this.depositoDist = depositoDist;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (cintaTransportadora) {
                    if (!cintaTransportadora.estaVacio()) {
                        String producto = cintaTransportadora.retirar(null); // Retira cualquier producto
                        synchronized (depositoDist) {
                            depositoDist.almacenar(producto);
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
