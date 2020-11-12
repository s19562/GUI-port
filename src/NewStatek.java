public class NewStatek extends Statek{

        public NewStatek(String nazwa, String portMatka, String skadK, String dokatK, int maxToxic,int maxCiezkich, int maxElektro , int maxAllK, double maxW) {

            super(nazwa, portMatka, skadK, dokatK);
            this.numerS = nr;
            Numer();
            this.maxToxic = maxToxic;
            this.maxCiezkich = maxCiezkich;
            this.maxElektro = maxElektro;
            this.maxAllK = maxAllK;
            this.maxW = maxW;

        }
    }
