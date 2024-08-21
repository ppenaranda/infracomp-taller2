public class T extends Thread{
    private final Id  idManejador;
    private int id;

    public T(Id idManejador){
        this.idManejador = idManejador;
    }

    @Override
    public void run(){
        id = idManejador.darId();
        System.out.println("El id del Thread es: " + id);
    }

    public static void main(String[] args) {
        int numThreads = 10;
        Id idManejador = new Id(numThreads);

        for (int i = 0; i < numThreads; i++){
            T hilo = new T(idManejador);
            hilo.start();
        }
    }
}