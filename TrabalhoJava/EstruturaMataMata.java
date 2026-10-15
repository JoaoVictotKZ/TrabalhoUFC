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


            // Inserimos aqui um outro laço de repetição que vai percorrer a lista de lutadores ativos em pares (De dois em dois), ou seja, dois lutadores por vez, para realizar a pancadaria.
            for (int i = 0; i < lutadoresAtivos.size(); i += 2) {
                Lutador lutador1 = lutadoresAtivos.get(i);
                Lutador lutador2 = lutadoresAtivos.get(i + 1);

                // Iniciamos a luta entre os dois lutadores, criando um objeto da classe Luta, passando os dois lutadores como parâmetros.
                Luta luta = new Luta(lutador1, lutador2);
                System.out.println("Combate: " + lutador1.getNome() + " VS " + lutador2.getNome());
                
                // Aqui chamamos o método realizar() da classe Luta, que vai determinar o vencedor da luta.
                luta.realizar(); 
                Lutador vencedor = luta.getVencedor();
                
                System.out.println("-> Vencedor: " + vencedor.getNome());
                
                // Aqui Salva o vencedor da Luta na Lista de Vencedores da fase, será usado para a proxima fase da competição.
                vencedoresDaFase.add(vencedor);
            }

            lutadoresAtivos = vencedoresDaFase; // Atualiza a lista para a próxima fase
            numeroDaFase++; // Avança a fase incrementando o número da fase apartir do inicio (1).
        }

        // Quando o laço termina, significa que só resta um lutador ativo, que é o campeão do torneio.
        System.out.println("\n===================================");
        System.out.println("👑 CAMPEÃO DO TORNEIO 👑");
        // Transformamos o lutador campeão em uma string para exibir suas informações direcionando um metodo do .get .
        System.out.println(lutadoresAtivos.get(0).toString());
        System.out.println("===================================");

        }
    }


                 