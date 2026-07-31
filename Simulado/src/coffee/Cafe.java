package coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Cafe {

    private String nome;
    private String origem;
    private int intensidade;
    protected List<Opiniao> opinioes;
    protected int degustacoes;
    protected double qualidade;

    public Cafe(String nome, String origem, int intensidade) {
        this.nome = nome;
        this.origem = origem;
        this.intensidade = intensidade;
        this.opinioes = new ArrayList<>();
        this.qualidade = 0;
    }

    public void adicionaOpiniao(String nome, int nota, String comentario) {
        Opiniao novaOpiniao = new Opiniao(nome, nota, comentario);
        opinioes.add(novaOpiniao);
        degustacoes++;
    }

    public abstract double calculaNota();

    public double media() {
        double media = 0;
        int n = 0;
        int soma = 0;
        for (Opiniao o : opinioes) {
            soma += o.getNota();
            n++;
        }
        if (n != 0) {
            media = (double) soma / n;
        }
        return media;
    }

    @Override
    public String toString() {
        return this.nome + ": " + this.origem + ", " + this.intensidade;
    }

    public String[] getOpinioes(int qtdOpinioes) {
        String[] saida = null;
        if (qtdOpinioes > 0 && qtdOpinioes <= this.opinioes.size()) {
            saida = new String[qtdOpinioes];
            int contador = 0;
            for (int i = opinioes.size() - 1; i >= (opinioes.size() - qtdOpinioes); i--) {
                saida[contador] = opinioes.get(i).toString();
                contador++;
            }
        }
        return saida;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cafe other = (Cafe) obj;
        return Objects.equals(nome, other.nome);
    }
}
