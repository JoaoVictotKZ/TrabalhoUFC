package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestesMainUFC { // Teste da classe Lutador
    public static void main(String[] args) {
        //Instanciando um objeto da classe Lutador com nome, idade e peso manualmente, para testar o método toString() da classe Lutador.
        // Lutador l1 = new Lutador("Kazuki", 28, 78.5);
        // System.out.println(l1);

        // Criando uma lista de lutadores para o torneio, vou testar aqui a classe EstruturaMataMata, que vai gerenciar o torneio no formato mata-mata.

        //List<Lutador> participantes = new ArrayList<>();

        // vou utilizar aqui um laço de repetição do tipo for para criar 16 lutadores automaticamente, com nomes diferentes, mas com a mesma idade e peso, para testar o torneio e a categoria de peso, que vai ser a mesma para todos os lutadores, para não quebrar a chave do torneio.
        // Quero gerar 16 lutadores para simular um torneio apartir das oitavas de final, ou seja, 8 lutas na primeira fase, 4 lutas na segunda fase, 2 lutas na terceira fase e a final com 1 luta.
        //for (int i = 1; i <= 16; i++) {
            // Nome: Lutador 1, Lutador 2... | Idade: 25 | Peso: 80.0 (Categoria: Médio)
            //Lutador lutador = new Lutador("Lutador " + i, 25, 80.0); 
            //participantes.add(lutador);
    //}

    // Nessa parte instanciamos a classe EstruturaMataMata, passando a lista de participantes como parâmetro, para iniciar o torneio.
        //EstruturaMataMata torneio = new EstruturaMataMata(participantes);
        //torneio.iniciarTorneio(); // Inicia o torneio no formato mata-mata.
    //}


    // TESTE DE SCANNER


        // Fazendo o teste da configuração do Locale.US para que o Scanner aceite ponto (ex: 78.5) em vez de vírgula no peso, e também para que o Scanner aceite a entrada de dados do usuário via teclado, para cadastrar os lutadores e iniciar o torneio.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // INSERINDO UM MENU DE BOAS-VINDAS PARA O USUÁRIO.
        System.out.println("===========================================");
        System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
        System.out.println("===========================================");

        // Nessa parte vou pedir ao usuário para informar a quantidade de lutadores que vão participar em cada categoria, e vou verificar se o número informado é par, para não quebrar a chave do torneio.
        System.out.print("Quantos lutadores vão participar em CADA categoria? (Digite um número par): ");
        int qtdPorCategoria = scanner.nextInt();
        scanner.nextLine(); // Aqui é para consumir a quebra de linha deixada pelo nextInt() e evitar problemas na leitura de proximas entradas de texto.

        // Validação da regra pra existir um torneio mata-mata (tem que ser par)
        if (qtdPorCategoria % 2 != 0) {
            System.out.println("Erro: A quantidade precisa ser um número par. Reinicie o programa.");
            scanner.close();
            return;
            }

            // 1. Cadastrando os lutadores usando um metodo auxiliar que já já vou inserir, ele vai trabalhar para evitar repetição de código na hora de cadastrar os lutadores, e vai receber como parâmetro o Scanner, a categoria e a quantidade de lutadores que o usuário informou.
        List<Lutador> leves = cadastrarLutadores(scanner, "Leve", qtdPorCategoria);
        List<Lutador> medios = cadastrarLutadores(scanner, "Médio", qtdPorCategoria);
        List<Lutador> pesados = cadastrarLutadores(scanner, "Pesado", qtdPorCategoria);
            

        // Aqui vou Fechar o scanner após ler todos os dados de cadastro.
        scanner.close();

        // Teste de impressão dos lutadores cadastrados, para verificar se os dados foram lidos corretamente e vou iniciar os torneios apartir disso.
        System.out.println("\n\n===================================");
        System.out.println("    INICIANDO TORNEIO LEVE     ");
        System.out.println("===================================");
        EstruturaMataMata torneioLeves = new EstruturaMataMata(leves);
        torneioLeves.iniciarTorneio();

        System.out.println("\n\n===================================");
        System.out.println("    INICIANDO TORNEIO MÉDIO    ");
        System.out.println("===================================");
        EstruturaMataMata torneioMedios = new EstruturaMataMata(medios);
        torneioMedios.iniciarTorneio();

        System.out.println("\n\n===================================");
        System.out.println("   INICIANDO TORNEIO PESADO    ");
        System.out.println("===================================");
        EstruturaMataMata torneioPesados = new EstruturaMataMata(pesados);
        torneioPesados.iniciarTorneio();

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
            lutadores.add(new Lutador(nome, idade, peso));
        }
        return lutadores;
    }
}

