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
	
	public Aluno buscaRGM(String chave) {

		for(int i = 0; i < tamanho; i++) {
			if(alunos[i].getRGM().compareTo(chave) == 0) {
				System.out.println("Nome:\t" + alunos[i].getNome() + "\n");
				return alunos[i];
			}
		}
		System.out.println("Aluno não existe\n");
		return null;
	}
	
	public boolean Compara(Aluno c1, Aluno c2) {
		return(c1.getNome().equals(c2.getNome()));
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
	
	public String inserirAluno (int pos, Aluno c1) {
		if (estaCheia()){
			return "Lista Cheia!";
		}
		else if((pos > tamanho) || (pos < 0)){
			return "Posição inválida!";
		}
		deslocarParaDireita(pos);
		alunos[pos] = c1;
		tamanho++;

		return "\nAdicinado!";
	}
	public String InserirAlunoPorRGM(Aluno aluno){
		int pos = -1;

		for(int i = tamanhoLista()-1; i >= 0; i--){
			System.out.println(i);
			if(aluno.getRGM().compareTo(alunos[i].getRGM()) < 0){
				pos = i;
			}
		}
		if(pos == -1){
			pos = tamanhoLista();
		}

		return inserirAluno(pos, aluno);
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
		aux.disciplinas.clearLista();
		deslocarParaEsquerda(pos);
		tamanho--;
		return aux;
	}

	public String removerAlunoPorRGM (String rgm) {
		int pos = -1;

		for(int i = 0; i < this.tamanho; i++){
			if(this.alunos[i].getRGM().compareTo(rgm) == 0){
				pos = i;
			}
		}

		if ((pos > tamanho) || (pos < 0))
			return "RGM não existe";
		Aluno aux = alunos[pos];

		aux.disciplinas.clearLista();

		deslocarParaEsquerda(pos);
		tamanho--;
		return aux.getRGM();
	}
/*
	public void ordenarListaPorRGM() {
		String[] lista_de_rgms = new String[tamanho];

		for(int i = 0; i < tamanho; i++){
			lista_de_rgms[i] = alunos[i].getRGM();
		}

		Arrays.sort(lista_de_rgms);

		Lista_Alunos lista_de_alunos_ordenada = new Lista_Alunos();

		for(int x = 0; x < tamanho; x++){
			for(int y = 0; y < tamanho; y++){
				if(alunos[y].getRGM().compareTo(lista_de_rgms[x]) == 0){
					lista_de_alunos_ordenada.inserirAluno(x, alunos[y]);
				}
			}
		}

		this.alunos = lista_de_alunos_ordenada.alunos;
		this.tamanho = lista_de_alunos_ordenada.tamanho;
	}
*/
	public void exibirLista() {
		for (int i = 0; i < tamanho; i++){
			System.out.print("\n\nAluno " +(i + 1)
								+"\nNome: " +alunos[i].getNome()
								+"\nRGM: " +alunos[i].getRGM()
								+"\nDisciplinas:");
			
			alunos[i].disciplinas.exibirLista();
		}
	}
	
}
