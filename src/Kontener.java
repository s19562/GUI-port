import java.time.LocalDateTime;

public abstract class Kontener{

    static int nr = 1;
    int numerId;
    public void Numer(){
        nr++;
    }
    Nadawca nadawca;
    double wagaAll;
    double dl;
    String kolor;
    LocalDateTime dataPrzybycia;

    public Kontener(Nadawca nadawca, double wagaAll, double dl , String kolor){
        this.nadawca = nadawca;
        this.wagaAll = wagaAll;
        this.dl = dl;
        this.kolor = kolor;
        this.numerId = nr;
        Numer();
        this.dataPrzybycia = null;
    }

    @Override
    public String toString() {
        return "Kontener{" +
                "numerId=" + numerId +
                ", nadawca=" + nadawca ;
    }

    public void setDataPrzybycia(){
        this.dataPrzybycia = java.time.LocalDateTime.now();

    }
}
