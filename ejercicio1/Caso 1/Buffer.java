import java.util.ArrayList;

public class Buffer {
    private final int capacidad;
    private final ArrayList<String> buff;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.buff = new ArrayList<>();
    }


    public synchronized void almacenar(String prod) throws InterruptedException {
        while (buff.size() == capacidad) {
            wait(); 
        }
        buff.add(prod); //ACA SE AGREGA AL BUFFER EL PRODUCTO
        notifyAll(); 
    }

    public synchronized String retirar(String tipoProducto) throws InterruptedException {
        // Si el buffer está vacío, el hilo que llama a este método se queda esperando

        while (buff.isEmpty() || (tipoProducto != null && !buff.get(0).equals(tipoProducto))) {
            wait(); 
        }

        String prod = buff.remove(0); // ACA SE RETIRA DEL BUFFER EL PRODUCTO

        notifyAll(); //  Se avisa a los demás hilos que el buffer no está vacío

        return prod;
    }

    public synchronized boolean estaVacio() {
        return buff.isEmpty();
    }
}
