package coffee;

public class CafeTradicional extends Cafe {

    private int torra;

    public CafeTradicional(String nome, String origem, int intensidade, int torra) {
        super(nome, origem, intensidade);
        this.torra = torra;
    }

    public double calculaNota() {
        double saida = media() * torra;
        this.nota = saida;
        return saida;
    }

}
