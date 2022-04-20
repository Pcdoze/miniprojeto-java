
public class Lista_Disciplinas {

	Disciplina	primeira = null;
	Disciplina	ultima = null;
	int		tamanho = 0;
	
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
			ultima.proximo = a;
			ultima = a;
		}
		tamanho++;
	}
	
	public void exibirLista() {
		Disciplina temp = primeira;
		if (!estaVazia()) {
			for (int i = 0; i < tamanho; i++) {
				System.out.println("Disciplina "+(i+1)+" | nome: "+temp.nome);
				temp = temp.proximo;
			}
		}
	}

}
