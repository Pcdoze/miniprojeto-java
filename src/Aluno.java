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

	public boolean cadastrarDisciplina(String[] entrada){
		Disciplina novaDisciplina = new Disciplina();

		try{
			novaDisciplina.setNome(entrada[0]);
			novaDisciplina.setNota(Float.parseFloat(entrada[1]));

			disciplinas.inserirNoFim(novaDisciplina);
		}
		catch (Exception e){
			return false;
		}

		return true;
	}
}