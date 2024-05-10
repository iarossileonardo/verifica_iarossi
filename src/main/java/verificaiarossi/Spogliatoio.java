package verificaiarossi;

public class Spogliatoio {
    private int postiLiberi = 2;

    public synchronized double entra(Pilota p) throws InterruptedException{
        while (postiLiberi == 0) {
            wait();
        }
        postiLiberi--;

        double tempoCambio = Math.random() * 500 + 500;

        System.out.println(p.getNome() + " entra nello spogliatoio e lo occupa per " + ((float)tempoCambio/1000) + "s..." + postiLiberi + " posti liberi");

        return tempoCambio;
    }

    public synchronized void esci(Pilota p){
        postiLiberi++;
        notifyAll();
        System.out.println(p.getNome() + " esce dallo spogliatoio..." + postiLiberi + " posti liberi");
    }
}
