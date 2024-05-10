package verificaiarossi;

public class Pilota extends Thread{
    private String nome;
    private Spogliatoio s;
    private GoKart g;

    public Pilota(String nome, Spogliatoio s, GoKart g) {
        this.nome = nome;
        this.s = s;
        this.g = g;
    }

    @Override
    public void run() {
        try {
            double tempoCambio = s.entra(this);;
            this.sleep((long)tempoCambio);
            s.esci(this);
            g.sali(this);
            double nGiri = Math.random() * 4 + 1;
            for (int i = 0; i < nGiri; i++) {
                double tempoGiro = Math.random() * 1000 + 1000;
                this.sleep((long)tempoGiro);
                System.out.println(nome + " ha terminato il giro " + (i + 1) + " di " + ((int)nGiri+1) + " (" + tempoGiro/1000 + "s)");
            }
            g.scendi(this);
            tempoCambio = s.entra(this);
            sleep((long)tempoCambio);
            s.esci(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    
    
}
