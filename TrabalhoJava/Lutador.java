package TrabalhoJava;

public class Lutador { 
    // Atributos privados da classe Lutador
    private String nome;
    private int idade;
    private double peso;
    private int vitorias;
    private int derrotas;

    // Construtor da classe Lutador
    public Lutador(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vitorias = 0;
        this.derrotas = 0;
    }
    // Getters para acessar os atributos privados
    public String getNome() { return nome; } 
    public int getIdade() { return idade; } 
    public double getPeso() { return peso; } 
    public int getVitorias() { return vitorias; } 
    public int getDerrotas() { return derrotas; } 

    // Métodos para registrar vitórias e derrotas
    public void registrarVitorias() { vitorias++; } 
    public void registrarDerrotas() { derrotas++; } 

    public String getCategoria() { //Estrutura condicional para definir a categoria do lutador com base no peso
        if (peso <= 70.0){
            return "Leve";
        } else if (peso <= 84.0) {
            return "Médio";
        } else {
            return "Pesado";
        }
    }
    // Método toString para representar o lutador como uma string
    @Override // Sobrescreve o método toString da classe Object
    public String toString() { // Retorna uma representação em string do lutador,incluindo nome, idade, peso, categoria, vitórias e derrotas
        return String.format("%s | %d anos | %.1f kg | %s | %dV - %dD",
            nome, idade, peso, getCategoria(), vitorias, derrotas);
    
    }
    
}
