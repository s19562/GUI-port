import java.time.LocalDateTime;

public class MagazynWatek extends Thread{
    int ile;
    int licz =0;
    LocalDateTime dataPrzyj;
    Kontener k;

    public MagazynWatek(int ile , Kontener k , LocalDateTime dataPrzyj){
        this.ile =ile;
        this.dataPrzyj = dataPrzyj;
        this.k = k;
    }


    public void run(){
        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            licz++;
        }
    }
}
