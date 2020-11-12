import java.util.ArrayList;

public class ParoStatek extends Statek{


    public ParoStatek(String nazwa, String portMatka, String skadK, String dokatK) {
        super(nazwa, portMatka, skadK, dokatK);
        this.numerS = nr;
        Numer();
        this.maxToxic = 3;
        this.maxCiezkich = 7;
        this.maxElektro = 2;
        this.maxAllK = 10;
        this.maxW = 5000.0;

    }



}
