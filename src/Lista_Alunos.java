
public class Lista_Alunos extends Aluno {

	Aluno[] alunos = new Aluno[60];
	int tamanho = 0;
	
	public boolean estaVazia() {
		return(tamanho == 0);
	}
	
	public boolean estaCheia() {
		return(tamanho == alunos.length);
	}
	
	public int tamanhoLista() {
		return(tamanho);
	}
	
	public Aluno buscar(int pos) {
		// verifica se pos e valida
		if (pos < 0 || pos >= tamanho)
			return null;
		
		return alunos[pos];
	}
	
	public boolean Compara(Aluno c1, Aluno c2) {
		return(c1.nome.equals(c2.nome));
	}
	
	public int retornarPosicao(Aluno Aluno) {
		for (int i = 0; i <= tamanho; i++)
			if (Compara(alunos[i], Aluno))
				return i;
		return -1;
	}
	
	public void deslocarParaDireita(int pos) {
		for (int i = tamanho; i > pos; i--)
			alunos[i] = alunos[i - 1];
	}
	
	public boolean inserirAluno (int pos, Aluno c1) {
		if (estaCheia() || (pos > tamanho) || (pos < 0))
			return false;
		deslocarParaDireita(pos);
		alunos[pos] = c1;
		tamanho++;

		return true;
	}
	
	public void deslocarParaEsquerda(int pos) {
		for (int i = pos; i < (tamanho - 1); i++)
			alunos[i] = alunos[i + 1];
	}
	
/*	public boolean removerAluno (int pos) {
		if ((pos > tamanho) || (pos < 0))
			return false;
		deslocarParaEsquerda(pos);
		tamanho--;
		return true;
	}
	*/
	public Aluno removerAluno (int pos) {
		if ((pos > tamanho) || (pos < 0))
			return null;
		Aluno aux = alunos[pos];
		deslocarParaEsquerda(pos);
		tamanho--;
		return aux;
	}
	
	public void exibirLista() {
		for (int i = 0; i < tamanho; i++)
			System.out.println(	"\nAluno " +(i + 1)
								+"\nNome: " +alunos[i].nome
								+"\nRGM: " +alunos[i].rgm);
	}
	
}
