
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Pablo R Santiago Peñaranda - 201922871
// Lex Betancourt - 202110854
// Natalia Espitia - 202215087

public class T extends Thread{
    private static Maximo oMax = new Maximo();
    private int inicio;
    private static int[][] M;
    private static int NTHR;
    private int x;

    public T (int inicio, int x){
        this.inicio = inicio;
        this.x = x;
    }
    
    @Override
    public void run(){
        int miMax = -1;
        int final_ = this.inicio + this.x;
        
        if (final_ > M[0].length){
            final_ = M[0].length;
        }
        for (int i = this.inicio; i < final_; i++){
            if (miMax < M[0][i]){
            miMax = M[0][i];
            }     
        }
        oMax.anotar(miMax);
    }

    public static void generarMatriz(int n){
        M = new int[1][n];
        Random random = new Random();

        for (int i = 0; i < n; i++){
            M[0][i] = random.nextInt(10);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Scanner nVector =  new Scanner(System.in);
        System.out.println("Ingresar el número de tamaño de el vector: "); 
        int nVectorNumero = nVector.nextInt();

        Scanner nThreads = new Scanner(System.in);
        System.out.println("Ingresar el número de threads: ");  
        int nThreadsNumero = nThreads.nextInt();
        NTHR = nThreadsNumero;

        generarMatriz(nVectorNumero);
        System.out.println("El vector es: " + Arrays.deepToString(M));
        T [] ta = new T[NTHR];

        int x = (M[0].length)/NTHR;

        for (int i = 0; i < ta.length; i++){
            ta[i] = new T(x*i, x);
        }

        for (T ta1 : ta) {
            ta1.start();
        }

        for (T ta1 : ta) {
            ta1.join();
        }

        int maximo_ = oMax.darMaximo();
        System.out.println("El valor máximo del vector es: "+ maximo_);
    }
}