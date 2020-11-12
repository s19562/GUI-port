public class ToxicCK extends CiezkiK{

    boolean przecieka;
    boolean certyfikat;



    public ToxicCK(Nadawca nadawca, double wagaAll, double dl, String kolor, boolean naklejka, double gruboscDna, boolean przecieka , boolean certyfikat) {
        super(nadawca, wagaAll, dl, kolor, naklejka, gruboscDna);
        this.przecieka = przecieka;
        this.certyfikat = certyfikat;


    }
}

