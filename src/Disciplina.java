
public class Disciplina {
	private String	nome;
	private float	nota;
	private Disciplina	proximo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public Disciplina getProximo() {
		return proximo;
	}
	public void setProximo(Disciplina proximo) {
		this.proximo = proximo;
	}

}