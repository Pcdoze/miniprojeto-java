
public class Lista_Disciplinas {
	
	private Disciplina	primeira = null;
	private Disciplina	ultima = null;
	private int		tamanho = 0;
	
	public void copiarLista(Lista_Disciplinas lista_copiada) {
		this.primeira = lista_copiada.primeira;
		this.ultima = lista_copiada.ultima;
		this.tamanho = lista_copiada.tamanho;
	}
	public boolean estaVazia() {
		if (tamanho == 0)
			return true;
		
		return false;
	}
	public int tamanhoDaLista() {
		return (tamanho);
	}
	
	public void inserirNoFim(Disciplina a) {
		if (estaVazia())
			primeira = ultima = a;
		else {
			ultima.setProximo(a);
			ultima = a;
		}
		tamanho++;
	}
	
	public void exibirLista() {
		Disciplina temp = primeira;
		if (!estaVazia()) {
			for (int i = 0; i < tamanho; i++) {
				System.out.printf("\nDisciplina %d | nome: %s\tnota %f" , i+1, temp.getNome(), temp.getNota());
				temp = temp.getProximo();
			}
		}
	}
	public void clearLista() {
		primeira = null;
		ultima = null;
		tamanho = 0;
	}

}
