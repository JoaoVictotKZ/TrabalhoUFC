package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;

public class EstruturaMataMata {
    // Esse vai ser um atributo que guarda os lutadores que ainda não foram eliminados
    private List<Lutador> lutadoresAtivos;

    //Aqui é o construtor da classe onde vai verificar se a quantidade de lutadores é par para não quebrar a chave
    public EstruturaMataMata(List<Lutador> lutadores) {
   if (lutadores.size() % 2 != 0) {
            throw new IllegalArgumentException("O número de lutadores deve ser par para um torneio mata-mata.");
        }
        //Aqui criamos uma cópia da lista de lutadores para garantir que a lista não vá alterar a lista original no main.
        this.lutadoresAtivos = new ArrayList<>(lutadores);
   
    }
  
    // Método para iniciar o gerenciamento do torneio no Formato.
    public void iniciarTorneio() {
        System.out.println("===================================");
        System.out.println("    INÍCIO DO TORNEIO MATA-MATA    ");
        System.out.println("===================================");

        int numeroDaFase = 1; 
        // Declaramos uma variável para controlar o número da fase do torneio, começando com a primeira fase.

        // colocamos um Laço de repetição que só vai executar quando houver mais de um lutador ativo, ou seja, enquanto houver mais de um lutador na lista de lutadores ativos, o torneio continua. 
        while (lutadoresAtivos.size() > 1) {
            System.out.println("\n--- FASE " + numeroDaFase + " ---");
            
            // Já nesta parte do código, criamos uma lista para armazenar os vencedores da fase atual, que serão os lutadores que avançam para a próxima fase.
            List<Lutador> vencedoresDaFase = new ArrayList<>();
        }
    }    
}