package coffee;

public class Opiniao {
	
	private String nome;
    private int nota;
    private String comentario;

    public Opiniao(String nome, int nota, String comentario) {
        this.nome = nome;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getNota() {
        return this.nota;
    }

    @Override
    public String toString() {
        return "Cliente: " + this.nome + ". Nota: " + this.nota + ". Comentário: " + this.comentario;
    }

}
