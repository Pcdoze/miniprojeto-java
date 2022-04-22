public class Aluno {
	private String nome;
	private String rgm;
	
	Lista_Disciplinas disciplinas = new Lista_Disciplinas();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRGM() {
		return rgm;
	}
	public void setRGM(String rgm) {
		this.rgm = rgm;
	}

	public void cadastrarDisciplina(String nomeDisciplina){
		Disciplina novaDisciplina = new Disciplina();

		novaDisciplina.setNome(nomeDisciplina);
		disciplinas.inserirNoFim(novaDisciplina);
	}
}
