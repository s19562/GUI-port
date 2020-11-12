import java.util.Comparator;

public class StatekComparator implements Comparator<Statek> {
    @Override
    public int compare(Statek st1, Statek st2) {
       return st1.nazwa.compareTo(st2.nazwa);
    }

}
