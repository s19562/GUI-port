import java.util.ArrayList;

public class Nadawca  {

    String imie, nazwisko , pesel;
    String adres;
    String dataU; //tutaj poprawic na DateTime czy moze tak zostac ?

    static int nr = 1;
    int numerId;
    public void Numer(){
        nr++;
    }

    ArrayList<IrresponsibleSenderWithDangerousGoods> ostrzezenia = new ArrayList();

    public Nadawca(String imie , String nazwisko , String pesel , String adres ,String dataU){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataU = dataU;
        this.numerId = nr;
        Numer();
    }

    public boolean sprawdzOstrzezenie(){

        if(ostrzezenia.size() > 2){
            return false;
        }else {
            return true;
        }
    }

    public void dodajOstrzezenie(IrresponsibleSenderWithDangerousGoods o){
        ostrzezenia.add(o);
    }

    @Override
    public String toString() {
        return imie +" "+ nazwisko+ " index = "+numerId;
    }
}
