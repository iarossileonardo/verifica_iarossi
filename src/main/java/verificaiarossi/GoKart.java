package verificaiarossi;

public class GoKart {
    private int kartLiberi = 4;

    public synchronized void sali(Pilota p) throws InterruptedException{
        while (kartLiberi == 0) {
            wait();
        }
        kartLiberi--;

        System.out.println(p.getNome() + " è salito su un Go-kart..." + kartLiberi + " kart liberi");
    }

    public synchronized void scendi(Pilota p){
        kartLiberi++;
        notifyAll();
        System.out.println(p.getNome() + " è sceso dal Go-Kart..." + kartLiberi + " kart liberi");
    }
}
