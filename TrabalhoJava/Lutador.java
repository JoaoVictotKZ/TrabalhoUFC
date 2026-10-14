package TrabalhoJava;

public class Lutador {
    
    private String nome;
    private int idade;
    private double peso;
    private int vitorias;
    private int derrotas;

    public Lutador(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.vitorias = 0;
        this.derrotas = 0;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getPeso() { return peso; }
    public int getVitorias() { return vitorias; }
    public int getDerrotas() { return derrotas; }

    public void registrarVitorias() { vitorias++; }
    public void registrarDerrotas() { derrotas++; }

    public String getCategoria() {
        if (peso <= 70.0){
            return "Leve";
        } else if (peso <= 84.0) {
            return "Médio";
        } else {
            return "Pesado";
        }
    }

    @Override
    public String toString() {
        return String.format("%s | %d anos | %.1f kg | %s | %dV - %dD",
            nome, idade, peso, getCategoria(), vitorias, derrotas);
    
    }
    
}
