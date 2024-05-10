package verificaiarossi;

public class Main {
    public static void main(String[] args) {
        Spogliatoio s = new Spogliatoio();
        GoKart g = new GoKart();

        Pilota p[] = new Pilota[8];

        for (int i = 0; i < p.length; i++) {
            p[i] = new Pilota("Pilota-" + (i + 1), s, g);
        }

        for (int i = 0; i < p.length; i++) {
            p[i].start();
        }
    }
}