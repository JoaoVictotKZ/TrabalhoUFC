package TrabalhoJava; 

import java.util.Random;

// Classe Luta representa uma luta entre dois lutadores
public class Luta {
    private Lutador lutador1;
    private Lutador lutador2;
    private Lutador vencedor;

    // Construtor da classe Luta, que recebe dois lutadores como parâmetros
    public Luta(Lutador lutador1, Lutador lutador2) {
        if (lutador1 == lutador2) { // Verifica se os lutadores são o mesmo objeto
            throw new IllegalArgumentException("Um lutador não pode lutar contra si mesmo.");
        }
        if (!lutador1.getCategoria().equals(lutador2.getCategoria())){ // Verifica se os lutadores são da mesma categoria
            throw new IllegalArgumentException("Os lutadores precisam ser da mesma categoria.");
        } // Inicializa os atributos da luta
        this.lutador1 = lutador1;
        this.lutador2 = lutador2;
        this.vencedor = null;
    }

    public void realizar(){ // Método para realizar a luta entre os dois lutadores
        if (vencedor != null) {
            System.out.println("Esta luta já foi realizada.");
            return;
        }
        // Simula a luta de forma aleatória, escolhendo um vencedor entre os dois lutadores
        Random sorteio = new Random();
        Lutador perdedor;

        // Sorteia aleatoriamente o vencedor da luta
        if (sorteio.nextBoolean()) {
            vencedor = lutador1;
            perdedor = lutador2;
        } else { // Se o sorteio não for verdadeiro, o vencedor será o lutador2 e o perdedor será o lutador1
            vencedor = lutador2;
            perdedor = lutador1;
        }

        // Atualiza o registro de vitórias e derrotas dos lutadores após a luta
        vencedor.registrarVitorias();
        perdedor.registrarDerrotas();
    }

    // Método para verificar se a luta já foi realizada
    public boolean foiRealizada(){
        return vencedor != null;
    }

    // Método para obter o vencedor da luta
    public Lutador getVencedor(){
        return vencedor;
    }

    // Método toString para representar a luta como uma string
    @Override 
    public String toString(){ // Retorna uma representação em string da luta, incluindo os nomes dos lutadores e o vencedor, se a luta já foi realizada
        String texto = lutador1.getNome() + " vs " + lutador2.getNome();
        if (foiRealizada()) { // Verifica se a luta já foi realizada
            texto += " | Vencedor: " + vencedor.getNome();
            }
        return texto; // Retorna a representação em string da luta
    }

}
