public class BigStatek extends Statek{

    public BigStatek(String nazwa, String portMatka, String skadK, String dokatK) {
        super(nazwa, portMatka, skadK, dokatK);
        this.numerS = nr;
        Numer();
        this.maxToxic = 12;
        this.maxCiezkich = 22;
        this.maxElektro = 7;
        this.maxAllK = 30;
        this.maxW = 20000.0;
    }
}
