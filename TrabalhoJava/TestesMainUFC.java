// Classe que foi utilizada para testes de código e correções ao longo do Projeto

//package TrabalhoJava;

//import java.util.ArrayList;
//import java.util.List;

//public class UFC { 

// 1. Teste da classe Lutador
    //public static void main(String[] args) {
        //Instanciando um objeto da classe Lutador com nome, idade e peso manualmente, para testar o método toString() da classe Lutador.
        // Lutador l1 = new Lutador("Kazuki", 28, 78.5);
        // System.out.println(l1);

        // Segundo Teste: Criando uma lista de lutadores para o torneio, vou testar aqui a classe EstruturaMataMata, que vai gerenciar o torneio no formato mata-mata.

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
//}

// inseri aqui para testar o funcionamento de Scanner para ler as entradas do usuário, além de importar dados de Locale para definir padrões de formatação dos dados que ele inserir via teclado sobre os lutadores, como idade e peso, que são do tipo numérico, para não dar erro de formatação, pois o padrão do Java é diferente do padrão brasileiro, que utiliza vírgula para separar os decimais.
// Aqui também importei a classe ArrayList e List para criar uma lista de lutadores, que será usada para armazenar os participantes do torneio e funcionar como uma chave de torneio, que vai ser gerenciada pela classe EstruturaMataMata, que vai organizar as lutas e determinar os vencedores de cada fase do torneio.

// 3. TESTE DE SCANNER
//public class UFC { // Teste da classe Lutador
    //public static void main(String[] args) {
        

    // Configurei o Locale.US para que o Scanner aceite ponto (ex: 78.5) em vez de vírgula no peso
        //Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


        // Fazendo um menuzinho de boas-vindas para o usuário, para que ele saiba que está no gerenciador de torneios UFC, e que ele vai poder cadastrar os lutadores e iniciar o torneio utilizando o Scanner em seguida.
        //System.out.println("===========================================");
        //System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
        //System.out.println("===========================================");

        // 4. CORREÇÃO DE BUGS

        //Aqui é o construtor da classe onde vai verificar se a quantidade de lutadores é par para não quebrar a chave
    //public EstruturaMataMata(List<Lutador> lutadores) {
   //if (lutadores.size() % 2 != 0) {
   //         throw new IllegalArgumentException("O número de lutadores deve ser par para um torneio mata-mata.");
   //     }
        
   //     //Aqui criamos uma cópia da lista de lutadores para garantir que a lista não vá alterar a lista original no main.
   //     this.lutadoresAtivos = new ArrayList<>(lutadores);
   //
   // }

   //       int quantidade = lutadores.size();

       // if (quantidade < 2){
            //throw new IllegalArgumentException("O torneio precisa de pelo menos 2 lutadores.");
        //}

        //int restantes = quantidade;
        //while (restantes > 1) {
            //if (restantes % 2 != 0) {
                //throw new IllegalArgumentException("A quantidade deve ser 2, 4, 8, 16, etc. para fechar o mata-mata.");

                