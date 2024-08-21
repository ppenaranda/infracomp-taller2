public class Id{
    private int currentId = 0;
    private final int maxId;

    public Id(int maxId){
        this.maxId = maxId;
    }

    public synchronized int darId() {
        if (currentId < maxId){
            return currentId++;
        } else {
            throw new IllegalStateException("Todos los Ids han sido ocupados");
        }
    }
}