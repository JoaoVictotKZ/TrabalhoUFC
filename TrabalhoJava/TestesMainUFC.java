package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestesMainUFC {
    
    // Teste da main final com Scanner
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
       List<EstruturaMataMata> torneios = new ArrayList<>();

       System.out.println("===========================================");
       System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
       System.out.println("===========================================");

       boolean noMenu = true; // Decidimos por colocar laço principal pra iniciar o menu e por isso essa linha serve pra controlar ele.

       // AQUI O WHILE VAI FAZER PARTE DO MENU PRINCIPAL
        while (noMenu) {
            System.out.println("\n--- MENU DE CADASTRO ---");
            System.out.println("1 - Adicionar Torneio(s) categoria LEVE");
            System.out.println("2 - Adicionar Torneio(s) categoria MÉDIO");
            System.out.println("3 - Adicionar Torneio(s) categoria PESADO");
            System.out.println("4 - INICIAR TODOS OS TORNEIOS E SAIR");
            System.out.println("0 - Cancelar e Sair do Programa");
            System.out.print("Escolha uma opção: ");

            // aqui eu vou ler a opção do usuário como String e depois tentar converter para int, caso o usuário digite algo que não seja um número, vamos capturar essa exceção e informar o erro.

            String opcaoStr = scanner.nextLine().trim(); // Lê a opção do usuário como String e remove espaços em branco no início e no fim
            int opcao;

            // Após isso resolvi utilizar um try-catch para capturar casos onde o usuário digite algo que não seja um número no menu, e assim evitar que o programa quebre e informe um erro de execução, e em vez disso, vamos informar ao usuário que ele deve digitar apenas números válidos.

            try {
                opcao = Integer.parseInt(opcaoStr); // Tenta converter a opção para inteiro
            } catch (NumberFormatException e) { // Captura a exceção caso o usuário digite algo que não seja um número.
                System.out.println("Erro: Digite apenas o número da opção desejada.");
                continue; // Volta para o início do laço
            }

            String categoriaSelecionada = "";
            // Aqui a gente vai utilizar um switch case para tratar as opções do menu, e dependendo da opção escolhida, vamos definir a categoria selecionada e continuar o fluxo do cadastro.
            switch (opcao) {
                case 1:
                    categoriaSelecionada = "Leve";
                    break;
                case 2:
                    categoriaSelecionada = "Médio";
                    break;
                case 3:
                    categoriaSelecionada = "Pesado";
                    break;
                case 4:
                    noMenu = false; // Sai do laço para rodar os torneios que foram cadastrados.
                    continue; 
                case 0:
                    System.out.println("Programa encerrado pelo usuário.");
                    scanner.close();
                    return; // Encerra tudo e sai do sistema
                default:
                    System.out.println("Opção inválida! Escolha um número entre 0 e 4.");
                    continue;
            }

            // Já aqui a gente vai perguntar ao usuário quantos torneios ele quer gerar para a categoria selecionada, e vamos validar se o número é positivo, caso contrário, vamos informar o erro e pedir para digitar novamente.
            int qtdTorneios = 0; // Variavel para armazenar a quantidade de torneios que o usuário deseja gerar para a categoria selecionada.
            while (true) { // Laço para garantir que o usuário digite um número válido de torneios
                System.out.print("\nQuantos torneios da categoria " + categoriaSelecionada.toUpperCase() + " deseja gerar? ");
                try {
                    qtdTorneios = Integer.parseInt(scanner.nextLine().trim());
                    if (qtdTorneios >= 0) break; // Valor válido, sai do loop
                    System.out.println("A quantidade não pode ser negativa.");
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um número inteiro válido.");
                }
            }


        }

        scanner.close();


        // @Joao, aqui você continua a lógica, precisamos da parte de execução do mata-mata, que vai percorrer a lista de torneios cadastrados anteriormente, acho que se a gente colocar uma condição para verificar se a lista de torneios está vazia, podemos informar ao usuário que não há torneios cadastrados e encerrar o programa. 
        // Após isso exibir o inicio dos torneios já pro usuário, e depois precisamos pensar nas validações de quantidade de lutadores, e se a quantidade de lutadores for ímpar, vamos informar ao usuário que o último lutador vai passar direto para a próxima fase, e depois vamos exibir os resultados das lutas e o vencedor do torneio.
        // Acho que pra cada uma das validações nós podemos criar metodos auxiliares como fizemos com o Cadastrarlutadores, mas cê vê aí a melhor forma de organizar o código.

    }