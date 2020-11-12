import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    static ArrayList<Nadawca> nadawcaLista = new ArrayList<>();
    static ArrayList<Statek> statkiLista = new ArrayList<>();

    public static int menu() {
            Scanner sc = new Scanner(System.in);

            System.out.println("MENU : ");
            System.out.println("0 = Koniec bez zapisu !!!");
            System.out.println("1 = Stwórz nowy statek ");
            System.out.println("2 = Wyświetl listę statkow ");
            System.out.println("3 = Stwórz nowy kontener");
            System.out.println("4 = Wyświetl listę kontenerów w Magazynie");
            System.out.println("5 = Załaduj dany kontener na dany statek");
            System.out.println("6 = Wyświetl listę kontenerów na danym statku");
            System.out.println("7 = Usuń kontener z Magazynu");
            System.out.println("8 = Rozładuj dany statek na pociąg");
            System.out.println("9 = Rozładuj dany statek do Magazynu");

            int odp = sc.nextInt();
            return odp;
        }


        public static void main(String[] args) throws IOException, IrresponsibleSenderWithDangerousGoods {



            Magazyn magazyn = new Magazyn(10);

            try {

                int wybor = menu();
                while (wybor != 0) {
                    switch (wybor) {
                        case 1:
                            statkiLista.add(newStatek());
                            System.out.println("Statek dodany");
                            break;

                        case 2:
                            sortStatki();
                            statkiLista.forEach(s -> System.out.print(s + " \n "));
                            break;

                        case 3:
                            magazyn.addKontenerToMagazyn(newKontener());
                            System.out.println("Kontener dodany do Magazynu chyba ze wyskoczyło ze nie ma miejsca");
                            break;

                        case 4:
                            Collections.sort(magazyn.kontenery , new MagazynComparator().reversed());
                            magazyn.kontenery.forEach(kontener -> System.out.println(kontener + " \n "));
                            magazyn.czasy.forEach(czas -> System.out.println(czas.k +" do utylizacji "+(czas.ile-czas.licz)+ "dni"));
                            break;

                        case 5:
                            statkiLista.forEach(s -> System.out.print(s + " \n "));
                            System.out.println("Wybierz numer id statku na który chcesz załadować kontener : ");
                            Scanner sc = new Scanner(System.in);
                            int id = sc.nextInt();
                            Statek statek = null;
                            for (int i = 0; i < statkiLista.size(); i++) {
                                if (statkiLista.get(i).numerS == id) {
                                    statek = statkiLista.get(i);
                                }
                            }
                            System.out.println("Wybierz numer id kontenera który chcesz załadować na wskazany statek : ");
                            int idK = sc.nextInt();
                            Kontener kontener = null;
                            for (int i = 0; i < magazyn.kontenery.size(); i++) {
                                if (magazyn.kontenery.get(i).numerId == idK) {
                                    kontener = magazyn.kontenery.get(i);
                                }
                            }

                            assert statek != null;
                            if(statek.metodaZaładunku(kontener)){
                                magazyn.usunKontenerZMag(kontener);
                            }

                            break;

                        case 6:
                            statkiLista.forEach(s -> System.out.print(s + " \n "));
                            System.out.println("Wybierz numer id statku którego stan kontenerów chcesz sprawdzić : ");
                            Scanner sc1 = new Scanner(System.in);
                            int id1 = sc1.nextInt();
                            Statek statek1 = null;
                            for (int i = 0; i < statkiLista.size(); i++) {
                                if (statkiLista.get(i).numerS == id1) {
                                    statek1 = statkiLista.get(i);
                                }
                            }
                            assert statek1 != null;
                            statek1.metodaSortKontenery();
                            statek1.załadunek.forEach(k -> System.out.println(k + " \n "));
                            break;

                        case 7:
                            System.out.println("Wybierz numer id kontenera który chcesz usunąć : ");
                            Scanner sc2 = new Scanner(System.in);
                            int idKK = sc2.nextInt();
                            Kontener kontener1 = null;
                            for (int i = 0; i < magazyn.kontenery.size(); i++) {
                                if (magazyn.kontenery.get(i).numerId == idKK) {
                                    kontener1 = magazyn.kontenery.get(i);
                                }
                            }
                            magazyn.usunKontenerZMag(kontener1);
                            break;

                        case 8:
                            statkiLista.forEach(s -> System.out.print(s + " \n "));
                            System.out.println("Wybierz numer id statku który chcesz rozładować na pociąg : ");
                            Scanner sc3 = new Scanner(System.in);
                            int id3 = sc3.nextInt();
                            Statek statek3 = null;
                            for (int i = 0; i < statkiLista.size(); i++) {
                                if (statkiLista.get(i).numerS == id3) {
                                    statek3 = statkiLista.get(i);
                                }
                            }
                            assert statek3 != null;
                            statek3.rozladujNaPociag();
                            break;

                        case 9:
                            statkiLista.forEach(s -> System.out.print(s + " \n "));
                            System.out.println("Wybierz numer id statku który chcesz rozładować do Magazynu : ");
                            Scanner sc4 = new Scanner(System.in);
                            int id4 = sc4.nextInt();
                            Statek statek4 = null;
                            for (int i = 0; i < statkiLista.size(); i++) {
                                if (statkiLista.get(i).numerS == id4) {
                                    statek4 = statkiLista.get(i);
                                }
                            }

                            for(int i=0; i< statek4.załadunek.size(); i++){
                                if(!statek4.załadunek.get(i).nadawca.sprawdzOstrzezenie()){
                                    System.out.println("nakaz odesłania kontenera do nadawcy !!! ");
                                }else{
                                    if(magazyn.addKontenerToMagazyn(statek4.załadunek.get(i))){
                                        statek4.usunKontenerZStatku(statek4.załadunek.get(i));
                                    }

                                }
                            }
                            break;



                    }
                    System.out.println("\n Wciśnij ENTER aby wrócić do MENU ... ");
                    System.in.read();
                    wybor = menu();

                }
            }catch(IOException | IrresponsibleSenderWithDangerousGoods e){
                throw e;
            }

        }

        public static Statek newStatek() {

            Scanner sc = new Scanner(System.in);

            System.out.println("Podaj odpowiednio :");
            System.out.println("nazwę statku : ");
            String name = sc.nextLine();
            System.out.println("nazwę portu matki statku :");
            String namePort = sc.nextLine();
            System.out.println("skąd wypłynie :");
            String skad = sc.nextLine();
            System.out.println("dokąd płynie :");
            String dokad = sc.nextLine();

            System.out.println("Podaj jaki typ statku chcesz stworzayć : " + "\n" +
                    "1 = Mini Statek " + "\n" +
                    "2 = Paro-Statek " + "\n" +
                    "3 = Normal Statek " + "\n" +
                    "4 = Big Statek " + "\n" +
                    "5 = Transportowy Statek " + "\n" +
                    "6 = Nowy Typ Statku");

            System.out.println();
            int odp = sc.nextInt();


            switch (odp) {
                case 1 -> {
                    MiniStatek statek1 = new MiniStatek(name, namePort, skad, dokad);
                    return statek1;
                }
                case 2 -> {
                    ParoStatek statek2 = new ParoStatek(name, namePort, skad, dokad);
                    return statek2;
                }
                case 3 -> {
                    NormalStatek statek3 = new NormalStatek(name, namePort, skad, dokad);
                    return statek3;
                }
                case 4 -> {
                    BigStatek statek4 = new BigStatek(name, namePort, skad, dokad);
                    return statek4;
                }
                case 5 -> {
                    TransportStatek statek5 = new TransportStatek(name, namePort, skad, dokad);
                    return statek5;
                }
                case 6 -> {
                    System.out.println("Podaj odpowiednio : ");
                    System.out.println("maksymalna ilosc kontenerow Toksycznych : ");
                    int maxToxic = sc.nextInt();
                    System.out.println("maksymalna ilosc kontenerow Cieżkich :");
                    int maxCiezkich = sc.nextInt();
                    System.out.println("maksymalna ilosc kontenerow Elektrycznych:");
                    int maxElektor = sc.nextInt();
                    System.out.println("maksymalna ilosc kontenerow All :");
                    int maxAllK = sc.nextInt();
                    System.out.println("maksymalna siłę nośną :");
                    double maxW = sc.nextDouble();
                    NewStatek statek6 = new NewStatek(name, namePort, skad, dokad, maxToxic, maxCiezkich, maxElektor, maxAllK, maxW);
                    return statek6;
                }
            }
            return null;
        }

        public static Kontener newKontener() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz opcje : ");
            System.out.println("1 = nowy nadawca");
            System.out.println("2 = istniejący nadawca");
            int odp = sc.nextInt();
            Nadawca nadawca =null;

            if(odp == 1) {
                nadawcaLista.add(newNadawca());
                nadawca = nadawcaLista.get(nadawcaLista.size() - 1);

            }else if(odp == 2) {
                    System.out.println("Wpisz numer id nadawcy kontenera : ");
                    nadawcaLista.forEach(n -> System.out.print(n + " | "));
                    int nadId = sc.nextInt();


                    for (int i = 0; i < nadawcaLista.size(); i++) {
                        if (nadawcaLista.get(i).numerId == nadId) {
                            nadawca = nadawcaLista.get(i);
                        }
                    }
            }

                    System.out.println("Podaj odpowiednio :");
                    System.out.println("wage kontenera : ");
                    double wagaAll = sc.nextDouble();
                    System.out.println("długość kontenera :");
                    double dl = sc.nextDouble();
                    System.out.println("kolor kontenera :");
                    String kolor = sc.nextLine();

                    System.out.println("Podaj jaki typ kontenera chcesz stworzayć : " + "\n" +
                            "1 = Podstawowy kontener " + "\n" +
                            "2 = Ciekły kontener " + "\n" +
                            "3 = Ciężki kontener " + "\n" +
                            "4 = Kontener na materiały wybuchowe " + "\n" +
                            "5 = Kontener chłodniczy " + "\n" +
                            "6 = Kontener na toksyny ciekłe"+ "\n" +
                            "7 = Kontener na toksyny sypkie ");

                    System.out.println();
                    int jaki = sc.nextInt();


            switch (jaki) {
                case 1 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka = sc.nextBoolean();
                    PodstawowyK kontener = new PodstawowyK(nadawca, wagaAll, dl, kolor, naklejka);
                    return kontener;
                }
                case 2 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka1 = sc.nextBoolean();
                    System.out.println("Podaj czy kontener przecieka (boolean) :");
                    Boolean przecieka = sc.nextBoolean();
                    CiekleK kontener1 = new CiekleK(nadawca, wagaAll, dl, kolor, naklejka1, przecieka);
                    return kontener1;
                }
                case 3 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka2 = sc.nextBoolean();
                    System.out.println("Podaj grubość dna kontenera :");
                    double gruboscD = sc.nextDouble();
                    CiezkiK kontener2 = new CiezkiK(nadawca, wagaAll, dl, kolor, naklejka2, gruboscD);
                    return kontener2;
                }
                case 4 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka3 = sc.nextBoolean();
                    System.out.println("Podaj grubość dna kontenera :");
                    double gruboscD1 = sc.nextDouble();
                    System.out.println("Podaj wage materiałów wybuchowych :");
                    double wagaMatW = sc.nextDouble();
                    WybuchK kontener3 = new WybuchK(nadawca, wagaAll, dl, kolor, naklejka3, gruboscD1, wagaMatW);
                    return kontener3;
                }
                case 5 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka4 = sc.nextBoolean();
                    System.out.println("Podaj grubość dna kontenera :");
                    double gruboscD2 = sc.nextDouble();
                    System.out.println("Podaj ilość kabli w kontenerze :");
                    int iloscKabli = sc.nextInt();
                    ChlodniczyK kontener4 = new ChlodniczyK(nadawca, wagaAll, dl, kolor, naklejka4, gruboscD2, iloscKabli);
                    return kontener4;
                }
                case 6 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka5 = sc.nextBoolean();
                    System.out.println("Podaj grubość dna kontenera :");
                    double gruboscD3 = sc.nextDouble();
                    System.out.println("Podaj czy kontener przecieka (boolean) :");
                    Boolean przecieka1 = sc.nextBoolean();
                    System.out.println("Podaj czy kontener posiada certyfikat (boolean) :");
                    boolean certyfikat = sc.nextBoolean();
                    ToxicCK kontener5 = new ToxicCK(nadawca, wagaAll, dl, kolor, naklejka5, gruboscD3, przecieka1, certyfikat);
                    return kontener5;
                }
                case 7 -> {
                    System.out.println("Podaj czy kontener ma najklejke (boolean) :");
                    Boolean naklejka6 = sc.nextBoolean();
                    System.out.println("Podaj grubość dna kontenera :");
                    double gruboscD4 = sc.nextDouble();
                    System.out.println("Podaj czy kontener posiada certyfikat (boolean) :");
                    boolean zElektro = sc.nextBoolean();
                    ToxicSK kontener6 = new ToxicSK(nadawca, wagaAll, dl, kolor, naklejka6, gruboscD4, zElektro);
                    return kontener6;
                }
            }



            return null;
        }

        public static Nadawca newNadawca () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj odpowiednio : ");
            System.out.println("imie nadawcy : ");
            String imie = sc.nextLine();
            System.out.println("nazwisko nadawcy : ");
            String nazwisko = sc.nextLine();
            System.out.println("pesel nadawcy : ");
            String pesel = sc.nextLine();
            System.out.println("adres nadawcy : ");
            String adres = sc.nextLine();
            System.out.println("data urodzenia nadawcy : ");
            String dataU = sc.nextLine();

            Nadawca nadawca = new Nadawca(imie, nazwisko, pesel, adres, dataU);
            return nadawca;
        }

        public static void sortStatki(){
        Collections.sort(statkiLista, new StatekComparator().reversed());
            for(Statek s:statkiLista){
                System.out.println("posortowane statki");
                System.out.println(s);
            }
        }



}


