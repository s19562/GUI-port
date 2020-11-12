import java.util.Comparator;

public class KontenerComparator implements Comparator<Kontener> {

    public int compare(Kontener k1 ,Kontener k2){
        if(k1.wagaAll > k2.wagaAll){
            return 1;
        }else{
            return -1;
        }
    }
}
