package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestesMainUFC {
    
    // Teste da classe Lutador
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

       System.out.println("===========================================");
       System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
       System.out.println("===========================================");

       String[] categorias = {"Leve", "Médio", "Pesado"};
       List<EstruturaMataMata> torneios = new ArrayList<>();

       for (String categoria : categorias) {
            System.out.print("\nQuantos torneios da categoria " + categoria.toUpperCase()
                 + "deseja gerar? (Digite 0 para nenhum?): ");
            int qtdTorneios = scanner.nextInt();
            scanner.nextLine();

            for (int n = 1; n <= qtdTorneios; n++){
                int qtdLutadores = lerQuantidadeValida(scanner, categoria, n);
                List<Lutador> lutadores = cadastrarLutadores(scanner, categoria, qtdLutadores);
                torneios.add(new EstruturaMataMata(categoria + "  " + n, lutadores));
            }
       }

       scanner.close();

       if (torneios.isEmpty()) {
            System.out.println("Nenhum torneio foi gerado. Encerrando o programa.");
            return;
        }
        
        for (EstruturaMataMata torneio : torneios) {
            torneio.iniciarTorneio();
        }
    }

    private static int lerQuantidadeValida(Scanner scanner, String categoria, int numeroTorneio) {
        while (true) {
            System.out.println("Quantos Lutadores no torneio " + categoria.toUpperCase() + " "
                + numeroTorneio + "? (Digite 2, 4, 8, 16, etc.): ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (EstruturaMataMata.ehPotenciaDeDois(quantidade)) {
                return quantidade;
        }

        System.out.println("Erro: a quantidade deve ser 2, 4, 8, 16...");
        }
    }

    // Inserindo o metodo auxiliar para cadastrar os lutadores evitando repetição de código, ele vai receber como parâmetro o Scanner, a categoria e a quantidade de lutadores que o usuário informou.
    private static List<Lutador> cadastrarLutadores(Scanner scanner, String categoria, int quantidade) {
        List<Lutador> lutadores = new ArrayList<>();
        System.out.println("\nCadastro de Lutadores da Categoria " + categoria.toUpperCase() + ":");
        //Aqui geramos uma lista de lutadores separando seus dados, basicamente, essa linha preparam o terreno e avisam ao sistema: "Vou começar a ler os dados de uma categoria específica e vou guardar todos eles em uma lista para devolver depois.

        // Aqui eu vou colocar um laço de repetição do tipo for para ler os dados de cada lutador, e vou utilizar o método nextLine() para ler o nome, nextInt() para ler a idade e nextDouble() para ler o peso, e vou criar um objeto da classe Lutador com esses dados e adicionar na lista de lutadores e validar os dados.
        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o nome do Lutador " + i + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite a idade do Lutador " + i + ": ");
            int idade = scanner.nextInt();
            System.out.print("Digite o peso do Lutador " + i + ": ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Esta parte é para consumir a quebra de linha deixada pelo nextInt() e nextDouble() e evitar problemas na leitura de proximas entradas de texto, ou famoso "limpar o buffer" do Scanner.

            // Criando um objeto temporário da classe Lutador para validar a categoria antes de adicionar na lista de lutadores, e em seguida evitando que o usuário digite um peso que não corresponde a categoria, e se o peso estiver correto, adicionamos o lutador na lista de lutadores.
            Lutador lutadorTemporario = new Lutador(nome, idade, peso);

            // Inserindo aqui a validação da categoria, ou seja se compete perfeitamente com o peso, evitando que o usuário digite um peso que não corresponde a categoria.
            if (!lutadorTemporario.getCategoria().equals(categoria)) {
                System.out.println("Erro: O peso do lutador não corresponde à categoria " + categoria + ". Reinicie o programa.");
                System.out.println("Por favor, digite os dados novamente com um peso válido para a categoria " + categoria + ".");
                i--; // retorna a rodada no laço for para o usuário digitar esse lutador de novo.
                continue; 
            }
            // Se passar pelo if acima, significa que o lutador foi cadastrado corretamente, então podemos informar ao usuário que o cadastro foi realizado com sucesso.
            lutadores.add(lutadorTemporario);
            System.out.println("Lutador " + nome + " cadastrado com sucesso na categoria! ");
        }
        return lutadores;
    }
}

