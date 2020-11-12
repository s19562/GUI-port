
import java.util.ArrayList;
import java.util.Collections;


public abstract class Statek extends Thread implements MetodyS  {

    static int nr = 1;
    int numerS;
    String nazwa;
    String portMatka;
    String skadK , dokatK;

    int maxToxic;
    int maxCiezkich;
    int maxElektro;
    int maxAllK;
    double maxW;

    public void Numer(){
        nr++;
    }

    public Statek(String nazwa , String portMatka, String skadK , String dokatK){
        this.numerS = nr;
        this.nazwa = nazwa;
        this.portMatka = portMatka;
        this.skadK = skadK;
        this.dokatK = dokatK;
    }




    ArrayList<Kontener> załadunek = new ArrayList<>();

    int liczniK = 0;
    double licznikW = 0.0;
    int licznikToxic = 0;
    int licznikCiezkich =0;
    int licznikElektor =0;

    @Override
    public boolean metodaCzyZatonie(Kontener kontener) {
        licznikW = licznikW + kontener.wagaAll;
        liczniK ++;

        if(this.maxAllK >= liczniK & this.maxW >= licznikW){
            if(kontener instanceof CiezkiK){
                licznikCiezkich ++;
                if(licznikCiezkich > this.maxCiezkich){
                    System.out.println("za dużo cięzkich");
                    return false;
                }

                if(kontener instanceof ToxicSK | kontener instanceof ToxicCK | kontener instanceof WybuchK){
                    licznikToxic ++;
                    if(licznikToxic> this.maxToxic){
                        System.out.println("za dużo toksycznych");
                        return false;
                    }
                }

                if (kontener instanceof ChlodniczyK){
                    licznikElektor ++;
                    if(licznikElektor>this.maxElektro){
                        System.out.println("za dużo elektrycznych");
                        return false;
                    }

                }

            }
            return true;
        }
        System.out.println("Za dużo kontenerów na statku");
        return false;
    }

    @Override
    public boolean metodaZaładunku(Kontener kontener) {

        if(metodaCzyZatonie(kontener)) {
            załadunek.add(kontener);
            return true;
        }else
            System.out.println("kontener się nie mieści");
        return false;

    }


    public void metodaSortKontenery(){
        Collections.sort(załadunek, new KontenerComparator());
        for(Kontener k:załadunek){
            System.out.println("posortowane kontenery");
            System.out.println(k);
        }
    }

    public void rozladujNaPociag() {

            while (załadunek.size() != 0) {
                for (int i = 0; i < 10; i++) {
                    this.załadunek.remove(załadunek.get(i));
                }
                try {
                    Thread.sleep(30000);
                }catch(InterruptedException e){
                }
            }

    }

    public void usunKontenerZStatku(Kontener k){
        załadunek.remove(k);
    }

    @Override
    public String toString() {
        return "id = "+this.numerS + " nazwa = "+this.nazwa;
    }
}
