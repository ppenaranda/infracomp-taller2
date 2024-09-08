
import java.util.Scanner;

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

        Scanner  sc = new Scanner(System.in);

        System.out.println("Ingrese el número de Threads");
        int numThreads = sc.nextInt();
        Id idManejador = new Id(numThreads);

        for (int i = 0; i < numThreads; i++){
            T hilo = new T(idManejador);
            hilo.start();
        }
    }
}