package coffee;

public class CafePremium extends Cafe {

    private int raridade;

    public CafePremium(String nome, String origem, int intensidade, int raridade) {
        super(nome, origem, intensidade);
        this.raridade = raridade;
    }

    public double calculaNota() {
        double saida = media() * 3.5 * raridade;
        this.nota = saida;
        return saida;
    }

}
