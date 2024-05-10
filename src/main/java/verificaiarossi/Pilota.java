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
            s.entra(this);
            double tempoCambio = Math.random() * 0.500 + 1000;
            this.sleep(1000);
            s.esci(this);
            g.sali(this);
            for (int i = 0; i < 5; i++) {
                double tempoGiro = Math.random() * 1000 + 1;
                this.sleep((long)tempoGiro);
                System.out.println(nome + " ha terminato il giro " + (i + 1) + " (" + tempoGiro + "s)");
            }
            g.scendi(this);
            s.entra(this);
            sleep(1000);
            s.esci(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    
    
}
