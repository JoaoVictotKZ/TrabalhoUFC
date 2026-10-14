package TrabalhoJava;

import java.util.Random;

public class Luta {
    private Lutador lutador1;
    private Lutador lutador2;
    private Lutador vencedor;

    public Luta(Lutador lutador1, Lutador lutador2) {
        if (lutador1 == lutador2) {
            throw new IllegalArgumentException("Um lutador não pode lutar contra si mesmo.");
        }
        if (!lutador1.getCategoria().equals(lutador2.getCategoria())){
            throw new IllegalArgumentException("Os lutadores precisam ser da mesma categoria.");
        }
        this.lutador1 = lutador1;
        this.lutador2 = lutador2;
        this.vencedor = null;
    }

}
