package coffee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Socio {

    private String codigo;
    private String nome;
    private boolean status;
    private List<Cafe> degustados;
    private Set<Cafe> favoritos;

    public Socio(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.status = true;
        this.degustados = new ArrayList<>();
        this.favoritos = new HashSet<>();
    }

    public void setStatus() {
        if (this.status) {
            status = false;
        } else {
            status = true;
        }
    }

    public void addDegustacao(Cafe cafe) {
        degustados.add(cafe);
    }

    public boolean addFavoritos(Cafe cafe) {
        if (degustados.contains(cafe)) {
            favoritos.add(cafe);
            return true;
        }
        return false;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Socio other = (Socio) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public String toString() {
    	if(this.status) {
    		return this.nome + ", ativo";
    	}
    	return this.nome + ", inativo";
    }

}

