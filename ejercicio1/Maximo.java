public class Maximo {
    private int maximo = 0;
    
    public synchronized void anotar (int n){
        if (n > this.maximo)
        this.maximo = n;
    }

    public synchronized int darMaximo(){
        return this.maximo;
    }
}