public class TransportStatek extends Statek{

    public TransportStatek(String nazwa, String portMatka, String skadK, String dokatK) {
        super(nazwa, portMatka, skadK, dokatK);
        this.numerS = nr;
        Numer();
        this.maxToxic = 6;
        this.maxCiezkich = 14;
        this.maxElektro = 4;
        this.maxAllK = 20;
        this.maxW = 10000.0;
    }
}
