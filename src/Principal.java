import java.util.Scanner;

public class Principal {
	public static Lista_Alunos lista_de_alunos = null;
	public static Scanner scanner_principal = new Scanner(System.in);

	public static Lista_Alunos criarListaDeAlunos(){
		for(int i = 0; i < 60; i++){
			Aluno aluno = new Aluno();
			aluno.setNome("nome_"+Integer.toString(i+1));
			aluno.setRGM(String.format("%08d", i+1));

			lista_de_alunos.inserirAluno(i, aluno);
		}

		return lista_de_alunos;
	}
	public static Lista_Alunos cadastrarDisciplinas(){
		for(int i = 0; i < lista_de_alunos.tamanhoLista(); i++){
			Disciplina disciplina_criada = new Disciplina();
			disciplina_criada.setNome("Disciplina Nova");
			disciplina_criada.setNota(0.0f);

			lista_de_alunos.alunos[i].disciplinas.clearLista();
			lista_de_alunos.alunos[i].disciplinas.inserirNoFim(disciplina_criada);
			
		}
		
		return lista_de_alunos;
	}
	public static String cadastrarDisciplinasPorAluno(String rgm){
		Aluno aluno = lista_de_alunos.buscaRGM(rgm);

		if(aluno != null){
			aluno.disciplinas.clearLista();

			boolean mais_disciplina = true;

			while(mais_disciplina){
				System.out.printf("\nAluno: %s\nInserir nome e nota da nova disciplina: (separados por espaço)", aluno.getNome());
				String[] entrada = scanner_principal.nextLine().split(" ");

				if(aluno.cadastrarDisciplina(entrada)){
					System.out.println("Mais Disciplina? (s/n)");
					String opcao = scanner_principal.nextLine();

					if(opcao.compareTo("s") == 0){
						mais_disciplina = true;
					}
					else if(opcao.compareTo("n") == 0){
						mais_disciplina = false;
						return "Disciplinas Cadastradas";
					}
					else{
						System.out.println("Entrada Inválida!");
						mais_disciplina = false;
					}
				}
				else{
					System.out.println("Entrada Inválida!");
				}
			}
		}
		return "Disciplinas Não Cadastradas";
	}
	public static void main(String[] args) {
		lista_de_alunos = new Lista_Alunos();
		boolean loop_principal = true;

		while(loop_principal){
			if(lista_de_alunos.tamanho == 0){
				System.out.println("\n__________________________________________\n"+
										"\nSelecione uma opção:"+
										"\n\t1 - Criar Lista de Alunos"+
										"\n\t2 - Adicionar Aluno"+
										"\n\t3 - Sair");

				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "2":
						System.out.println("Digite nome e RGM: (separados por espaço)");
							
						String resultado = "";
						String[] entrada = scanner_principal.nextLine().split(" ");
						if(entrada.length == 2){
							Aluno aluno = new Aluno();
							aluno.setNome(entrada[0]);
							aluno.setRGM(entrada[1]);

							resultado = lista_de_alunos.inserirAluno(0, aluno);

							lista_de_alunos.ordenarListaPorRGM();
							lista_de_alunos.exibirLista();
						}
						else{
							resultado = "Entrada Inválida";
						}
						System.out.println(resultado);
					break;
					case "3":
						loop_principal = false;
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
			else if(lista_de_alunos.alunos[0].disciplinas.tamanhoDaLista() == 0){
				System.out.println("\n__________________________________________\n"+
										"\nSelecione uma opção:"+
										"\n\t1 - Ver Lista de Alunos"+
										"\n\t2 - Cadastrar Disciplinas"+
										"\n\t3 - Cadastrar Disciplinas por Aluno"+
										"\n\t4 - Buscar na Lista de Alunos"+
										"\n\t5 - Recriar Lista de Alunos"+
										"\n\t6 - Adicionar Aluno"+
										"\n\t7 - Remover Aluno"+
										"\n\t8 - Sair");
									
				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos.exibirLista();
						break;
					case "2":
						cadastrarDisciplinas();
						System.out.println("Disciplinas Cadastradas");
						break;
					case "3":
						System.out.println("Digite o RGM do aluno: ");
						String retorno = cadastrarDisciplinasPorAluno(scanner_principal.nextLine());

						System.out.println(retorno);
						break;
					case "4":
					    System.out.println("Digite o RGM: ");
						String chave = scanner_principal.nextLine();
						lista_de_alunos.buscaRGM(chave);
						break;
					case "5":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "6":
						System.out.println("Digite nome e RGM: (separados por espaço)");
						
						String resultado;
						String[] entrada = scanner_principal.nextLine().split(" ");
						if(entrada.length == 2){
							Aluno aluno = new Aluno();
							aluno.setNome(entrada[0]);
							aluno.setRGM(entrada[1]);

							resultado = lista_de_alunos.inserirAluno(0, aluno);

							lista_de_alunos.ordenarListaPorRGM();
							lista_de_alunos.exibirLista();
						}
						else{
							resultado = "Entrada Inválida";
						}

						System.out.println("\n"+resultado);
						break;
					case "7":
						System.out.println("Digite o RGM: ");
						String rgm_remover = scanner_principal.nextLine();
						
						String aluno_removido = lista_de_alunos.removerAlunoPorRGM(rgm_remover);

						lista_de_alunos.exibirLista();
						System.out.printf("\nAluno Removido: %s", aluno_removido);
						break;
					case "8":
						loop_principal = false;
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
			else{
				System.out.println("\n__________________________________________\n"+
										"\nSelecione uma opção:"+
										"\n\t1 - Ver Lista de Alunos"+
										"\n\t2 - Recadastrar Disciplinas"+
										"\n\t3 - Cadastrar Disciplinas por Aluno"+
										"\n\t4 - Buscar na Lista de Alunos"+
										"\n\t5 - Recriar Lista de Alunos"+
										"\n\t6 - Adicionar Aluno"+
										"\n\t7 - Remover Aluno"+
										"\n\t8 - Sair");
									
				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos.exibirLista();
						break;
					case "2":
						cadastrarDisciplinas();
						System.out.println("Disciplinas Cadastradas");
						break;
					case "3":
						System.out.println("Digite o RGM do aluno: ");
						String retorno = cadastrarDisciplinasPorAluno(scanner_principal.nextLine());

						System.out.println(retorno);
						break;
					case "4":
					    System.out.println("Digite o RGM: ");
						String chave = scanner_principal.nextLine();
						lista_de_alunos.buscaRGM(chave);
						break;
					case "5":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "6":
						System.out.println("Digite nome e RGM: (separados por espaço)");
						
						String resultado;
						String[] entrada = scanner_principal.nextLine().split(" ");
						if(entrada.length == 2){
							Aluno aluno = new Aluno();
							aluno.setNome(entrada[0]);
							aluno.setRGM(entrada[1]);

							resultado = lista_de_alunos.inserirAluno(0, aluno);

							lista_de_alunos.ordenarListaPorRGM();
							lista_de_alunos.exibirLista();
						}
						else{
							resultado = "Entrada Inválida";
						}

						System.out.println("\n"+resultado);
						break;
					case "7":
						System.out.println("Digite o RGM: ");
						String rgm_remover = scanner_principal.nextLine();
						
						String aluno_removido = lista_de_alunos.removerAlunoPorRGM(rgm_remover);

						lista_de_alunos.exibirLista();
						System.out.printf("\nAluno Removido: %s", aluno_removido);
						break;
					case "8":
						loop_principal = false;
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
		}
		scanner_principal.close();

	}

}
