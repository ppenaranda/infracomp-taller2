public class Fabrica {
    public static void main(String[] args) {
        //ESTOS SON VALORES DE EJMPLO, FALTA AGREGAR EL Input
        int capDepProd = 10;
        int capDepDist = 10;
        int numProductos = 10;

        Buffer depositoProd = new Buffer(capDepProd);
        Buffer cintaTransportadora = new Buffer(1); 
        Buffer depositoDist = new Buffer(capDepDist);

        new Productor(depositoProd, "A", numProductos).start();
        new Productor(depositoProd, "A", numProductos).start();
        new Productor(depositoProd, "B", numProductos).start();
        new Productor(depositoProd, "B", numProductos).start();

        new OperarioInterno1(depositoProd, cintaTransportadora).start();
        new OperarioInterno2(cintaTransportadora, depositoDist).start();

        new Distribuidor(depositoDist, "A").start();
        new Distribuidor(depositoDist, "A").start();
        new Distribuidor(depositoDist, "B").start();
        new Distribuidor(depositoDist, "B").start();
    }
}
