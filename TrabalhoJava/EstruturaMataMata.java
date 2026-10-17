package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;

public class EstruturaMataMata {
    private String nome; // Atributo para armazenar o nome do torneio
    
    
    // Esse vai ser um atributo que guarda os lutadores que ainda não foram eliminados
    private List<Lutador> lutadoresAtivos;

    // Construtor da classe EstruturaMataMata, que recebe uma lista de lutadores como parâmetro
    public EstruturaMataMata(List<Lutador> lutadores, String nome) {
        if (!ehPotenciaDeDois(lutadores.size())) {
            throw new IllegalArgumentException("A quantidade de lutadores deve ser 2, 4, 8, 16, etc. para fechar o mata-mata.");
        }

        String categoria = lutadores.get(0).getCategoria();
        for (Lutador lutador : lutadores) {
            if (!lutador.getCategoria().equals(categoria)) {
                throw new IllegalArgumentException("Todos os lutadores devem ser da mesma categoria.");
            }
        }
        
        this.nome = nome;
        this.lutadoresAtivos = new ArrayList<>(lutadores);
    }

    // ==========================================
    // Adicionei um metodo getNome() para retornar o nome do torneio dando utilidade ao primeiro atributo da classe, que pode ser útil para exibir informações sobre o torneio em outras partes do programa.
    // ==========================================
    public String getNome() {
        return this.nome;
    }

    public EstruturaMataMata(String string, List<Lutador> lutadores) {
        this(lutadores, string);
        //Nesta parte do código, o construtor da classe EstruturaMataMata recebe uma lista de lutadores e um nome para o torneio. E em seguida no outro método, ele verifica se a quantidade de lutadores é uma potência de dois e se todos os lutadores pertencem à mesma categoria. Se essas condições não forem atendidas, ele lança uma exceção IllegalArgumentException com uma mensagem apropriada. Caso contrário, ele inicializa os atributos nome e lutadoresAtivos com os valores fornecidos.
    }

    public static boolean ehPotenciaDeDois(int numero) {
        if (numero < 2) {
            return false;
        }
        while (numero > 1) {
            if (numero % 2 != 0) {
                return false;
            }
            numero /= 2;
        }
        return true;
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
        System.out.println(" CAMPEÃO DO TORNEIO ");
        // Transformamos o lutador campeão em uma string para exibir suas informações direcionando um metodo do .get .
        System.out.println(lutadoresAtivos.get(0).toString());
        System.out.println("===================================");

        }
    }


                 