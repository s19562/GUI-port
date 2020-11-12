public class NormalStatek extends Statek{

    public NormalStatek(String nazwa, String portMatka, String skadK, String dokatK) {
        super(nazwa, portMatka, skadK, dokatK);
        this.numerS = nr;
        Numer();
        this.maxToxic = 4;
        this.maxCiezkich = 8;
        this.maxElektro = 2;
        this.maxAllK = 12;
        this.maxW = 7000.0;
    }
}
