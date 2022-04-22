import java.util.Scanner;

public class Principal {
	public static Lista_Alunos lista_de_alunos = null;
	public static Scanner scanner_principal = new Scanner(System.in);

	public static Lista_Alunos criarListaDeAlunos(){
		for(int i = 0; i < 60; i++){
			System.out.printf("\nInserir nome e RGM de aluno %d: (separados por espaço) ", i+1);
				String[] entrada = scanner_principal.nextLine().split(" ");
				
				if(entrada.length == 2){
					Aluno aluno = new Aluno();
					aluno.setNome(entrada[0]);
					aluno.setRGM(entrada[1]);

					lista_de_alunos.inserirAluno(i, aluno);
				}
				else if(entrada[0].compareTo("skip") == 0){
					for(int j = i; j < 60; j++){
						Aluno aluno = new Aluno();
						aluno.setNome("nome_"+Integer.toString(j+1));
						aluno.setRGM(String.format("%08d", j+1));

						lista_de_alunos.inserirAluno(i, aluno);
					}
					i = 60;
				}
				else{
					System.out.println("\nEntrada Invalida");
					i--;
				}
		}

		lista_de_alunos.ordenarListaPorRGM();

		return lista_de_alunos;
	}
	public static Lista_Alunos cadastrarDisciplinas(){
		for(int i = 0; i < lista_de_alunos.tamanhoLista(); i++){

			Lista_Disciplinas lista_de_disciplinas = new Lista_Disciplinas();

			boolean mais_disciplina = true;
			int tamanho_da_lista = 0;

			while(mais_disciplina){
				System.out.printf("\nAluno: %s\nInserir nome da disciplina %d: ", lista_de_alunos.alunos[i].getNome(), tamanho_da_lista+1);
				String entrada = scanner_principal.nextLine();
				
				Disciplina disciplina = new Disciplina();
				
				if(entrada.compareTo("skip") == 0){
					for(int j = i; j < 60; j++){
						Disciplina disciplina_criada = new Disciplina();
						disciplina_criada.nome = "Disciplina Nova";
						disciplina.nome = "Disciplina Nova";

						lista_de_alunos.alunos[j].disciplinas.primeira = null;
						lista_de_alunos.alunos[j].disciplinas.ultima = null;
						lista_de_alunos.alunos[j].disciplinas.tamanho = 0;

						lista_de_alunos.alunos[j].disciplinas.inserirNoFim(disciplina_criada);
						
					}

					i = lista_de_alunos.tamanhoLista()-1;
				}
				else{
					disciplina.nome = entrada;
				}

				String opcao;

				boolean entrada_invalida = true;
				while(entrada_invalida){
					System.out.printf("\nMais Disciplina? (s/n)");
					opcao = scanner_principal.nextLine();

					if(opcao.compareTo("s") == 0 || opcao.compareTo("S") == 0){

						lista_de_disciplinas.inserirNoFim(disciplina);
						entrada_invalida = false;
						mais_disciplina = true;
						tamanho_da_lista++;
					}
					else if(opcao.compareTo("n") == 0 || opcao.compareTo("N") == 0){

						lista_de_disciplinas.inserirNoFim(disciplina);
						entrada_invalida = false;
						mais_disciplina = false;
						tamanho_da_lista++;
					}
					else{
						System.out.println("Entrada Inválida");
						entrada_invalida = true;
					}
				}
			}

			lista_de_alunos.alunos[i].disciplinas = new Lista_Disciplinas();
			lista_de_alunos.alunos[i].disciplinas.copiarLista(lista_de_disciplinas);
		}
		return lista_de_alunos;
	}
	public static void cadastrarDisciplinasPorAluno(){
		System.out.println("Digite o nome da nova Disciplina: ");
		scanner_principal.nextLine();
	}
	public static void main(String[] args) {
		lista_de_alunos = new Lista_Alunos();
		boolean loop_principal = true;

		while(loop_principal){
			if(lista_de_alunos.tamanho == 0){
				System.out.println("\nSelecione uma opção:"+
										"\n\t1 - Criar Lista de Alunos"+
										"\n\t2 - Adicionar Aluno"+
										"\n\t3 - Remover Aluno"+
										"\n\t4 - Sair");

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
						System.out.println("Digite o RGM: ");
						String rgm_remover = scanner_principal.nextLine();
						
						String aluno_removido = lista_de_alunos.removerAlunoPorRGM(rgm_remover);

						lista_de_alunos.exibirLista();
						System.out.printf("\nAluno Removido: %s", aluno_removido);
						break;
					case "4":
						loop_principal = false;
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
			else if(lista_de_alunos.alunos[0].disciplinas.tamanho == 0){
				System.out.println("\nSelecione uma opção:"+
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
						cadastrarDisciplinasPorAluno();
						System.out.println("Disciplinas Cadastradas");
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
				System.out.println("\nSelecione uma opção:"+
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
						cadastrarDisciplinas();
						System.out.println("Disciplinas Cadastradas");
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
