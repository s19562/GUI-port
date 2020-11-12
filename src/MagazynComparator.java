import java.util.Comparator;

public class MagazynComparator implements Comparator<Kontener> {


    public int compare(Kontener k1 , Kontener k2) {

    if(k1.dataPrzybycia == k2.dataPrzybycia){
        return k1.nadawca.imie.compareTo(k2.nadawca.imie);
    }
        return k1.dataPrzybycia.compareTo(k2.dataPrzybycia);

    }


}
