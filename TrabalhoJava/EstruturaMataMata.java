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
    
}