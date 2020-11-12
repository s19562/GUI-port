public class ToxicSK extends CiezkiK {

    boolean zElektorwni;

    public ToxicSK(Nadawca nadawca, double wagaAll, double dl, String kolor, boolean naklejka, double gruboscDna, boolean zElektorwni) {
        super(nadawca, wagaAll, dl, kolor, naklejka, gruboscDna);
        this.zElektorwni = zElektorwni;
    }

}
