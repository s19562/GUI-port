import java.time.LocalDateTime;

public class IrresponsibleSenderWithDangerousGoods extends Exception{

Kontener k;
LocalDateTime dataP;
LocalDateTime dataU;

IrresponsibleSenderWithDangerousGoods(Kontener k , LocalDateTime dataP, LocalDateTime dataU){
    this.k =k;
    this.dataP = dataP;
    this.dataU = dataU;
}



    @Override
    public String toString() {
        return "IrresponsibleSenderWithDangerousGoods{" +
                k + " data przyjecia  : "+dataP + " data utylizacji : "+ dataU;
    }
}
