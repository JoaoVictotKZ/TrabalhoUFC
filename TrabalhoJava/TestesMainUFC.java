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


        // Fase de execução do Mata-Mata
        if (torneios.isEmpty()) {
            System.out.println("\nNenhum torneio foi gerado. Encerrando o programa.");
            return;
        }
        
        System.out.println("\n===========================================");
        System.out.println("     INICIANDO OS COMBATES OFICIAIS!       ");
        System.out.println("===========================================");

        for (EstruturaMataMata torneio : torneios) {
            torneio.iniciarTorneio();
        }
    }

    // Método blindado para ler a quantidade de lutadores
    private static int lerQuantidadeValida(Scanner scanner, String categoria, int numeroTorneio) {
        while (true) {
            System.out.print("Quantos Lutadores no torneio " + categoria.toUpperCase() + " " 
                + numeroTorneio + "? (Digite 2, 4, 8, 16, etc.): ");
            
            try {
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                
                // Valida se é potência de dois chamando o método estático da classe EstruturaMataMata
                if (EstruturaMataMata.ehPotenciaDeDois(quantidade)) {
                    return quantidade;
                }
                System.out.println("Erro: a quantidade deve ser potência de dois (2, 4, 8, 16...).");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números inteiros.");
            }
        }
    }

    // Método blindado para cadastrar lutadores com todas as validações aplicadas
    private static List<Lutador> cadastrarLutadores(Scanner scanner, String categoria, int quantidade) {
        List<Lutador> lutadores = new ArrayList<>();
        System.out.println("\nCadastro de Lutadores da Categoria " + categoria.toUpperCase() + ":");

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("\n-- Cadastrando Lutador " + i + " de " + quantidade + " --");
            
            // Validação do Nome com somente letras e espaços
            String nome = "";
            while (true) {
                System.out.print("Nome do Lutador: ");
                nome = scanner.nextLine().trim();
                if (nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
                    break; 
                }
                System.out.println("Erro: O nome não pode conter números, símbolos ou ficar em branco.");
            }

            // Validação da Idade com apenas números e limite entre 18 e 45 anos
            int idade = 0;
            while (true) {
                System.out.print("Idade (18 a 45 anos): ");
                try {
                    idade = Integer.parseInt(scanner.nextLine().trim());
                    if (idade >= 18 && idade <= 45) {
                        break; 
                    } else {
                        System.out.println("Erro: A idade informada está fora do limite permitido pela comissão.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite apenas números inteiros sem vírgula ou texto.");
                }
            }

            // Validação do Peso aceita vírgula ou ponto e corrige automaticamente
            double peso = 0.0;
            while (true) {
                System.out.print("Peso (Ex: 70.5 ou 70,5): ");
                String entradaPeso = scanner.nextLine().trim().replace(",", ".");
                try {
                    peso = Double.parseDouble(entradaPeso);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um valor numérico válido para o peso.");
                }
            }

            // Instanciação e validação lógica de categoria
            Lutador lutadorTemporario = new Lutador(nome, idade, peso);

            if (!lutadorTemporario.getCategoria().equals(categoria)) {
                System.out.println("\n[!] ALERTA: O peso do lutador (" + peso + " kg) o enquadra na categoria " 
                    + lutadorTemporario.getCategoria().toUpperCase() + ".");
                System.out.println("Isso não corresponde à categoria deste torneio (" + categoria.toUpperCase() + ").");
                System.out.println("Por favor, registre os dados novamente com o peso correto.\n");
                i--; // Retorna a rodada no laço for
                continue; 
            }

            // 
            lutadores.add(lutadorTemporario);
            System.out.println(">> Lutador " + nome + " cadastrado com sucesso!");
        }
        return lutadores;
    }
}