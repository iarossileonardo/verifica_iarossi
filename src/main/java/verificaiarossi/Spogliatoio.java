package verificaiarossi;

public class Spogliatoio {
    private int postiLiberi = 2;

    public synchronized void entra(Pilota p) throws InterruptedException{
        while (postiLiberi == 0) {
            wait();
        }
        postiLiberi--;

        System.out.println(p.getNome() + " entra nello spogliatoio e lo occuopa per 1s..." + postiLiberi + " posti liberi");
    }

    public synchronized void esci(Pilota p){
        postiLiberi++;
        notifyAll();
        System.out.println(p.getNome() + " esce dallo spogliatoio..." + postiLiberi + " posti liberi");
    }
}
