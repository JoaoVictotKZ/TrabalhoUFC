package TrabalhoJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
// inseri aqui para testar o funcionamento de Scanner para ler as entradas do usuário, além de importar dados de Locale para definir padrões de formatação dos dados que ele inserir via teclado sobre os lutadores, como idade e peso, que são do tipo numérico, para não dar erro de formatação, pois o padrão do Java é diferente do padrão brasileiro, que utiliza vírgula para separar os decimais.
// Aqui também importei a classe ArrayList e List para criar uma lista de lutadores, que será usada para armazenar os participantes do torneio e funcionar como uma chave de torneio, que vai ser gerenciada pela classe EstruturaMataMata, que vai organizar as lutas e determinar os vencedores de cada fase do torneio.

public class UFC { // Teste da classe Lutador
    public static void main(String[] args) {

    // Configurei o Locale.US para que o Scanner aceite ponto (ex: 78.5) em vez de vírgula no peso
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


        // Fazendo um menuzinho de boas-vindas para o usuário, para que ele saiba que está no gerenciador de torneios UFC, e que ele vai poder cadastrar os lutadores e iniciar o torneio utilizando o Scanner em seguida.
        System.out.println("===========================================");
        System.out.println(" BEM-VINDO AO GERENCIADOR DE TORNEIOS UFC  ");
        System.out.println("===========================================");

        // Vou pensar em algo agora de como pedir ao usuario para cadastrar os Lutadores em suas determinadas categorias.
        // Mais tarde vou implementar todo resto na parte de testes da main, por favor @Japa, antes de mexer manda mensagem.
}

}
