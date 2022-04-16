import java.util.Scanner;

public class Principal {
	public static Scanner scanner_principal = new Scanner(System.in);

	public static Lista_Alunos criarListaDeAlunos(){
		Lista_Alunos lista_de_alunos = new Lista_Alunos();
		
		// criando lista de alunos
		for(int i = 0; i < 60; i++){
			System.out.printf("\nInserir nome e RGM de aluno %d: (separados por espaço) ", i+1);
				String[] entrada = scanner_principal.nextLine().split(" ");
				
				if(entrada.length == 2){
					Aluno aluno = new Aluno();
					aluno.nome = entrada[0];
					aluno.rgm = entrada[1];

					lista_de_alunos.inserirAluno(i, aluno);
				}
				else if(entrada[0].compareTo("skip") == 0){
					for(int j = i; j < 60; j++){
						Aluno aluno = new Aluno();
						aluno.nome = "nome_"+Integer.toString(j+1);
						aluno.rgm = String.format("%08d", j+1);

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
	public static void main(String[] args) {
		Lista_Alunos lista_de_alunos = null;

		boolean loop_principal = true;

		while(loop_principal){
			if(lista_de_alunos == null){
				System.out.println("\nSelecione uma opção:"+
										"\n\t1 - Criar Lista de Alunos"+
										"\n\t2 - Sair");

				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "2":
						loop_principal = false;
						break;
					default:
						System.out.println("Opção Inválida");
						break;
				}
			}
			else if(lista_de_alunos.alunos[0].disciplinas == null){
				System.out.println("\nSelecione uma opção:"+
										"\n\t1 - Ver Lista de Alunos"+
										"\n\t2 - Buscar na Lista de Alunos"+
										"\n\t3 - Recriar Lista de Alunos"+
										"\n\t4 - Adicionar Aluno"+
										"\n\t5 - Remover Aluno"+
										"\n\t6 - Sair");
									
				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos.exibirLista();
						break;
					case "2":
						String chave = scanner_principal.nextLine();
						lista_de_alunos.buscaRGM(chave);
						break;
					case "3":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "4":
						System.out.println("Digite nome e RGM: (separados por espaço)");
						
						String resultado;
						String[] entrada = scanner_principal.nextLine().split(" ");
						if(entrada.length == 2){
							Aluno aluno = new Aluno();
							aluno.nome = entrada[0];
							aluno.rgm = entrada[1];

							resultado = lista_de_alunos.inserirAluno(0, aluno);

							lista_de_alunos.ordenarListaPorRGM();
						lista_de_alunos.exibirLista();
						}
						else{
							resultado = "Entrada Inválida";
						}

						System.out.println("\n"+resultado);
						break;
					case "5":
						System.out.println("Digite o RGM: ");
						String rgm_remover = scanner_principal.nextLine();
						
						String aluno_removido = lista_de_alunos.removerAlunoPorRGM(rgm_remover);

						lista_de_alunos.exibirLista();
						System.out.printf("\nAluno Removido: %s", aluno_removido);
						break;
					case "6":
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
