package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestesMainUFC {
    
    public static void main(String[] args) {
        // Aqui começa a execução do programa por scanner e o menu interativo com o usuário.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // Configura o scanner para aceitar ponto como separador decimal entre os números.
        List<EstruturaMataMata> torneios = new ArrayList<>(); // Aqui criamos a lista de torneios que serão gerados e armazenados para receber os lutadores cadastrados e depois executar os combates.


        // interface simples de boas-vindas e instruções iniciais
        System.out.println("===========================================");
        System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
        System.out.println("===========================================");

        boolean noMenu = true; // Controla o laço de repetição do menu principal.

        // Como vai funcionar o menu: enquanto noMenu for true, o menu será exibido. Quando o usuário escolher a opção 4, noMenu será setado para false e o programa sairá do menu e iniciará os torneios cadastrados.
        while (noMenu) {
            System.out.println("\n--- MENU DE CADASTRO ---");
            System.out.println("1 - Adicionar Torneio(s) categoria LEVE");
            System.out.println("2 - Adicionar Torneio(s) categoria MÉDIO");
            System.out.println("3 - Adicionar Torneio(s) categoria PESADO");
            System.out.println("4 - INICIAR TODOS OS TORNEIOS E SAIR");
            System.out.println("0 - Cancelar e Sair do Programa");
            System.out.print("Escolha uma opção: ");

            String opcaoStr = scanner.nextLine().trim(); // Lê a opção do usuário como String para evitar problemas de entrada e permitir validação mais segura.
            int opcao; // Definimos uma váriavel para armazenar a opção convertida para inteiro dentro do try-catch, evitando que o programa quebre caso o usuário digite algo inválido.

            try {
                opcao = Integer.parseInt(opcaoStr); // Tenta converter a entrada para inteiro, forçarndo o usuário a digitar apenas números válidos.
            } catch (NumberFormatException e) { // O catch captura a exceção caso o usuário digite algo que não seja um número inteiro.
                System.out.println("Erro: Digite apenas o número da opção desejada.");
                continue; // Volta para o início do laço no menu, permitindo que o usuário tente novamente.
            }

            String categoriaSelecionada = ""; // Variável para armazenar o cadastro da categoria escolhida pelo usuário, que será usada para cadastrar os torneios e lutadores.

            switch (opcao) { // optamos pelo switch-case para tratar as opções do menu de forma clara e organizada e dar somente escolhas válidas ao usuário sobre as categorias.
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
                    noMenu = false; // Caso o usuário escolha a opção 4, o programa sairá do menu e iniciará os torneios cadastrados.
                    continue; 
                case 0:
                    System.out.println("Programa encerrado pelo usuário.");
                    scanner.close();
                    return; // Caso o usuário escolha a opção 0, o programa será encerrado imediatamente retornando do método main.
                default: // E se caso o usuário digite um número que não corresponda a nenhuma das opções válidas, o programa exibirá uma mensagem de erro e voltará para o início do menu.
                    System.out.println("Opção inválida! Escolha um número entre 0 e 4."); 
                    continue;
            }

            // Lendo a quantidade de torneios desejada para a categoria escolhida
            int qtdTorneios = 0; // Variável para armazenar a quantidade de torneios que o usuário deseja gerar para a categoria selecionada.

            // Aqui a gente decidi usar um loop while para garantir que o usuário digite um número válido de torneios, evitando que o programa quebre ou gere resultados que não façam sentido. O loop só será interrompido quando o usuário digitar um número inteiro válido (0 ou positivo).
            while (true) { 
                System.out.print("\nQuantos torneios da categoria " + categoriaSelecionada.toUpperCase() + " deseja gerar? ");
                try {
                    qtdTorneios = Integer.parseInt(scanner.nextLine().trim());
                    if (qtdTorneios >= 0) break; // Valor válido, sai do loop
                    System.out.println("A quantidade não pode ser negativa.");
                } catch (NumberFormatException e) { // Captura a exceção caso o usuário digite algo que não seja um número inteiro.
                    System.out.println("Erro: Digite um número inteiro válido.");
                }
            }

            // Aqui colocamos um for para cadastrar os torneios e os lutadores de acordo com a quantidade de torneios que o usuário deseja gerar para a categoria anteriormente selecionada. Cada torneio terá sua própria lista de lutadores correspondendo a categoria.
            for (int n = 1; n <= qtdTorneios; n++) {  // Colocamos um FOR que vai de 1 até a quantidade de torneios escolhida pelo usuário.
                int qtdLutadores = lerQuantidadeValida(scanner, categoriaSelecionada, n); // Aqui quantidade de Lutadores faz um alô no metódo auxiliar que descobre o tamanho da chave do torneio e guarda depois na quantidade de Lutadores.
                List<Lutador> lutadores = cadastrarLutadores(scanner, categoriaSelecionada, qtdLutadores); // Aqui rola outra chamada no outro método onde cria uma lista de participantes para a quant de lutadores
                
                // Aqui estamos instanciando a estrutura da competição que recebe um parametro baseado na classe de mata mata
                torneios.add(new EstruturaMataMata(categoriaSelecionada + " Torneio " + n, lutadores)); // Estrutura MataMata se transforma num novo objeto e apartir daí pode receber nome de Torneio, Lista de Lutadores e add a lista que inserimos lá em cima.
                System.out.println("-> Torneio " + categoriaSelecionada.toUpperCase() + " " + n + " configurado com sucesso!\n");
            }
        }

        scanner.close();

        // Aqui entramos na fase de execução das dinâmicas do sistema.
        if (torneios.isEmpty()) {
            System.out.println("\nNenhum torneio foi gerado. Encerrando o programa.");
            return; // Caso a Lista de Torneios esteja vazio, encerra tudo.
        }
        
        System.out.println("\n===========================================");
        System.out.println("     INICIANDO OS COMBATES OFICIAIS!       ");
        System.out.println("===========================================");

        // Menuzinho após o scanner iniciando o programa

        for (EstruturaMataMata torneio : torneios) {
            torneio.iniciarTorneio();
        } // Colocamos um laço aqui que repete sobre cada 'torneio' armazenado na lista 'torneios', ou seja ele se repete enquanto tiver torneios para executar eles em seguida chamando o metodo dos torneios e suas chaves.
    }

    // Adicionamos um método oculto para ler a quantidade de lutadores de forma estatica onde só queremos valores inteiros pra validar o número de Lutadores.
    private static int lerQuantidadeValida(Scanner scanner, String categoria, int numeroTorneio) {
        while (true) {
            System.out.print("Quantos Lutadores no torneio " + categoria.toUpperCase() + " " 
                + numeroTorneio + "? (Digite 2, 4, 8, 16, etc.): "); 
            
            try {
                int quantidade = Integer.parseInt(scanner.nextLine().trim()); // Aqui o try serve pra leitura e validação dos valores inseridos.
                
                // Valida se é potência de dois chamando o método estático da classe EstruturaMataMata
                if (EstruturaMataMata.ehPotenciaDeDois(quantidade)) {
                    return quantidade;
                }
                System.out.println("Erro: a quantidade deve ser potência de dois (2, 4, 8, 16...)."); // Senão for potência de dois
            } catch (NumberFormatException e) {  // Captura caso o usuário não insira valores inteiros na digitação.
                System.out.println("Erro: Digite apenas números inteiros.");
            }
        }
    }

    // Método blindado para cadastrar lutadores com todas as validações aplicadas
    private static List<Lutador> cadastrarLutadores(Scanner scanner, String categoria, int quantidade) { // Quase a mesma coisa lá de cima mas agora pra validar os valores da lista de objetos instanciados em lista de "Lutador"
        List<Lutador> lutadores = new ArrayList<>(); // Inicia a lista de Lutadores para guardar os Lutadores sendo cadastrados agora
        System.out.println("\nCadastro de Lutadores da Categoria " + categoria.toUpperCase() + ":"); // Cabeçalho de Lutadores sendo cadastrados

        for (int i = 1; i <= quantidade; i++) { // Aqui é um laço que vai se repetir a quantidade que anteriormente escolhemos
            System.out.println("\n-- Cadastrando Lutador " + i + " de " + quantidade + " --"); // Aqui informa em qual lutador estamos cadastrando dentro do laço
            
            // 1. Validação do Nome do Lutador caso o usuário queira aloprar digitando coisas aleatórias (Só letras e espaços)
            String nome = "";
            while (true) {
                System.out.print("Nome do Lutador: ");
                nome = scanner.nextLine().trim(); // Aqui metódos do Scanner limitam espaços além da conta na hora do cadastro e limpam ele
                if (nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) { // Usamos um metodo string dentro da condicional if pra checar se temos somente letras (incluindo acentos) e espaços.
                    break; // Se passou pelo metódo o While vai se embora, senão:
                }
                System.out.println("Erro: O nome não pode conter números, símbolos ou ficar em branco.");
            }

            // 2. Validação da Idade (Apenas números e limite entre 18 e 45 anos)
            int idade = 0;
            while (true) {
                System.out.print("Idade (18 a 45 anos): ");
                try { // converte o número em seguida vai ler a informação e aparar espaços escritos
                    idade = Integer.parseInt(scanner.nextLine().trim());
                    if (idade >= 18 && idade <= 45) { // verifica a idade inserida, caso dê problema:
                        break; 
                    } else {
                        System.out.println("Erro: A idade informada está fora do limite permitido pela comissão.");
                    }
                } catch (NumberFormatException e) { // Outra captura de excessões pra ver se o usuário não bagunça as informações inserindo outra coisa.
                    System.out.println("Erro: Digite apenas números inteiros sem vírgula ou texto.");
                }
            }

            // 3. Validação do Peso (Aceita vírgula ou ponto e corrige automaticamente)
            double peso = 0.0; // Variável pra tipo decimal, afinal é um peso.
            while (true) {
                System.out.print("Peso (Ex: 70.5 ou 70,5): ");
                String entradaPeso = scanner.nextLine().trim().replace(",", "."); // A Diferença daqui é o método replace aonde a entrada substitui qualquer virgula por ponto pra forçar o padrão de escrita double.
                try {
                    peso = Double.parseDouble(entradaPeso); // Aqui converte o String pra double e completar o cadastro, caso dê certo o laço sai de validação do peso.
                    break;
                } catch (NumberFormatException e) { // e não conseguiu converter para decimal - tinha texto misturado, por exemplo, capturando outra excessão.
                    System.out.println("Erro: Digite um valor numérico válido para o peso.");
                }
            } // Tchau While

            // 4. Instanciação e validação lógica de categoria
            Lutador lutadorTemporario = new Lutador(nome, idade, peso); // Usa os dados validados para instanciar (criar na memória) um objeto da classe Lutador.

            if (!lutadorTemporario.getCategoria().equals(categoria)) { // Compara a categoria real do lutador (calculada internamente pela classe Lutador via peso) com a categoria escolhida para o torneio. Se for DIFERENTE (!):
                System.out.println("\n[!] ALERTA: O peso do lutador (" + peso + " kg) o enquadra na categoria " 
                    + lutadorTemporario.getCategoria().toUpperCase() + "."); // Imprime mensagem avisando sobre o peso pegando sua categoria pelo . get de categoria.
                System.out.println("Isso não corresponde à categoria deste torneio (" + categoria.toUpperCase() + ")."); // Caso não dê certo, aparecerá essas duas mensagens.
                System.out.println("Por favor, registre os dados novamente com o peso correto.\n");
                i--; // Retorna a rodada no laço for e diminui o 'i' para que a próxima repetição refaça este exato mesmo lutador.
                continue; // Pula a parte de adicionar o lutador na lista e vai direto lá pro laço for (Pra repetir isso aqui de novo.)
            }

            // Dando certo, adiciona de fato o lutador na lista deste torneio e imprime a mensagem de lutador totalmente cadastrado.
            lutadores.add(lutadorTemporario);
            System.out.println(">> Lutador " + nome + " cadastrado com sucesso!");
        } 

        return lutadores;
    } 
}