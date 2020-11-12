public class MiniStatek extends Statek{

    public MiniStatek(String nazwa, String portMatka, String skadK, String dokatK) {
        super(nazwa, portMatka, skadK, dokatK);
        this.numerS = nr;
        Numer();
        this.maxToxic = 1;
        this.maxCiezkich = 3;
        this.maxElektro = 1;
        this.maxAllK = 5;
        this.maxW = 2000.0;

    }

    @Override
    public String toString() {
        return super.toString() + " typ = Mini Statek";
    }
}
