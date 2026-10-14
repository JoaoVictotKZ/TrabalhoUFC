package TrabalhoJava; 

//@Aleijado não mexer aqui ainda nao conclui a logica.

import java.util.Random;

// Classe Luta representa uma luta entre dois lutadores
public class Luta {
    private Lutador lutador1;
    private Lutador lutador2;
    private Lutador vencedor;

    // Construtor da classe Luta, que recebe dois lutadores como parâmetros
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

    public void realizar(){
        if (vencedor != null) {
            System.out.println("Esta luta já foi realizada.");
            return;
        }

        Random sorteio = new Random();
        Lutador perdedor;

        if (sorteio.nextBoolean()) {
            vencedor = lutador1;
            perdedor = lutador2;
        } else {
            vencedor = lutador2;
            perdedor = lutador1;
        }

        vencedor.registrarVitorias();
        perdedor.registrarDerrotas();
    }

    public boolean foiRealizada(){
        return vencedor != null;
    }

    public Lutador getVencedor(){
        return vencedor;
    }

}
