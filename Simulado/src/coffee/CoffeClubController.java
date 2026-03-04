package coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Foram lançadas excessões além do pedido na especificação por questão 
de padronização e testes, mas só lancem excessão onde a especificação pedir
*/

public class CoffeClubController {

    private Map<String, Cafe> cafes;
    private Map<String, Socio> socios;

    public CoffeClubController() {
        this.cafes = new HashMap<>();
        this.socios = new HashMap<>();
    }

    private boolean cafeExiste(String chave) {
        return cafes.containsKey(chave);
    }

    private boolean socioExiste(String chave) {
        return socios.containsKey(chave);
    }

    public boolean cadastrarCafeTradicional(String nome, String origem, int intensidade, int tempoTorra) {
        validarEntradaCafe(nome, origem, intensidade);
        if (cafeExiste(nome)) {
            throw new IllegalArgumentException("Elemento ja existe");
        }
        Cafe novoCafe = new CafeTradicional(nome, origem, intensidade, tempoTorra);
        cafes.put(nome, novoCafe);
        return true;
    }

    public boolean cadastrarCafeEspecial(String nome, String origem, int intensidade, int nivelAroma) {
        validarEntradaCafe(nome, origem, intensidade);
        if (cafeExiste(nome)) {
            throw new IllegalArgumentException("Elemento ja existe");
        }
        Cafe novoCafe = new CafeEspecial(nome, origem, intensidade, nivelAroma);
        cafes.put(nome, novoCafe);
        return true;
    }

    public boolean cadastrarCafePremium(String nome, String origem, int intensidade, int raridade) {
        validarEntradaCafe(nome, origem, intensidade);
        if (cafeExiste(nome)) {
            throw new IllegalArgumentException("Elemento ja existe");
        }
        Cafe novoCafe = new CafePremium(nome, origem, intensidade, raridade);
        cafes.put(nome, novoCafe);
        return true;
    }

    private void validarEntradaCafe(String nome, String origem, int intensidade) {
        if (nome == null || origem == null || nome.trim().equals("") || origem.trim().equals("")) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        if (intensidade < 1 || intensidade > 5) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
    }

    public boolean cadastrarSocio(String codigo, String nome) {
        if (codigo == null || nome == null || codigo.trim().equals("") || nome.trim().equals("")) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        if (socioExiste(codigo)) {
            throw new IllegalArgumentException("Elemento ja existe");
        }
        Socio novoSocio = new Socio(codigo, nome);
        socios.put(codigo, novoSocio);
        return true;
    }

    public void mudaStatusSocio(String codigo) {
        if (!socioExiste(codigo)) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        socios.get(codigo).setStatus();
    }

    public boolean degustar(String codigoSocio, String nomeCafe, int nota, String comentario) {
        if (codigoSocio == null || nomeCafe == null || comentario == null ||
                codigoSocio.trim().equals("") || nomeCafe.trim().equals("") || comentario.trim().equals("")) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }

        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        if (!socioExiste(codigoSocio) || !cafeExiste(nomeCafe)) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        Socio s = socios.get(codigoSocio);
        Cafe c = cafes.get(nomeCafe);
        if (!s.getStatus()) {
            return false;
        }
        s.addDegustacao(c);
        c.adicionaOpiniao(s.getNome(), nota, comentario);
        return true;
    }

    public String buscarCafeMelhorAvaliado() {
        Cafe maior = null;
        for (Cafe cafe : cafes.values()) {
            if (maior == null || cafe.calculaNota() > maior.calculaNota()) {
                maior = cafe;
            }
        }
        return maior.toString();
    }

    public String[] listarOpinioesRecentes(String nomeCafe, int qtdOpinioes) {
        if (!cafeExiste(nomeCafe)) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        return cafes.get(nomeCafe).getOpinioes(qtdOpinioes);
    }

    public boolean adicionarCafeMeusFavoritos(String nomeCafe, String codigoSocio) {
        if (codigoSocio == null || nomeCafe == null || codigoSocio.trim().equals("") || nomeCafe.trim().equals("")) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        if (!socioExiste(codigoSocio) || !cafeExiste(nomeCafe)) {
            throw new IllegalArgumentException("Argumentos inválidos");
        }
        Socio s = socios.get(codigoSocio);
        Cafe c = cafes.get(nomeCafe);
        return s.addFavoritos(c);
    }

    public String[] listarCafes() {
        ArrayList<Cafe> c = new ArrayList<>(cafes.values());
        Collections.sort(c, new CafeComparator());
        String[] saida = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            saida[i] = c.get(i).toString();
        }
        return saida;
    }

    public String[] listarSocios() {
        String[] saida = new String[socios.size()];
        int i = 0;
        for (Socio s : socios.values()) {
            saida[i] = s.toString();
            i++;
        }
        return saida;
    }
}
