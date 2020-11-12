import java.util.ArrayList;

public class Magazyn {

    ArrayList<Kontener> kontenery;
    ArrayList<MagazynWatek> czasy;

    int miejsce;

    public Magazyn (int miejsce){
        this.miejsce = miejsce;
    }


    int licznikK=0;

    public boolean addKontenerToMagazyn(Kontener kontener) throws IrresponsibleSenderWithDangerousGoods {
        licznikK++;
        if(licznikK <= miejsce){
            kontenery.add(kontener);
            kontener.setDataPrzybycia();

            if(kontener instanceof WybuchK){
                MagazynWatek mW = new MagazynWatek(5, kontener, java.time.LocalDateTime.now());
                mW.start();
                czasy.add(mW);
                if(mW.licz > mW.ile){
                    IrresponsibleSenderWithDangerousGoods o = new IrresponsibleSenderWithDangerousGoods(kontener , mW.dataPrzyj , mW.dataPrzyj.plusDays(5));
                    kontener.nadawca.dodajOstrzezenie(o);
                    kontenery.remove(kontener);
                    throw o;

                }
            }
            if(kontener instanceof ToxicCK){
                MagazynWatek mW = new MagazynWatek(10, kontener, java.time.LocalDateTime.now());
                mW.start();
                czasy.add(mW);
                if(mW.licz > mW.ile){
                    IrresponsibleSenderWithDangerousGoods o = new IrresponsibleSenderWithDangerousGoods(kontener , mW.dataPrzyj , mW.dataPrzyj.plusDays(10));
                    kontener.nadawca.dodajOstrzezenie(o);
                    kontenery.remove(kontener);
                    throw o;

                }
            }

            if(kontener instanceof ToxicSK){
                MagazynWatek mW = new MagazynWatek(14, kontener, java.time.LocalDateTime.now());
                mW.start();
                czasy.add(mW);
                if(mW.licz > mW.ile){
                    IrresponsibleSenderWithDangerousGoods o = new IrresponsibleSenderWithDangerousGoods(kontener , mW.dataPrzyj , mW.dataPrzyj.plusDays(14));
                    kontener.nadawca.dodajOstrzezenie(o);
                    kontenery.remove(kontener);
                    throw o;

                }
            }

            return true;

        }else

            System.out.println("Nie ma miejsca w magazynie sorry ale zabieraj swój kontener elo.");
        return false;
    }

    public void usunKontenerZMag(Kontener kontener){
       for(Kontener k:kontenery){
           if(k.numerId == kontener.numerId){
               kontenery.remove(k);
           }
        }
    }



}
