package coffee;

public class CafeEspecial extends Cafe {

    private int aroma;

    public CafeEspecial(String nome, String origem, int intensidade, int aroma) {
        super(nome, origem, intensidade);
        this.aroma = aroma;
    }

    public double calculaNota() {
        double saida = media() * 2.0 * aroma;
        return saida;
    }

}
