import java.util.Arrays;
import java.util.Scanner;

public class Principal {
	public static Scanner scanner_principal = new Scanner(System.in);;

	public static Lista_Alunos criarListaDeAlunos(){
		Lista_Alunos lista_de_alunos = new Lista_Alunos();
		String[] lista_de_rgms = new String[60];
		
		// criando lista de alunos
		for(int i = 0; i < 60; i++){
			System.out.printf("\nInserir nome e RGM de aluno %d: (separados por espaço) ", i+1);
				String[] entrada = scanner_principal.nextLine().split(" ");

				
				if(entrada.length == 2){
					Aluno aluno = new Aluno();
					aluno.nome = entrada[0];
					aluno.rgm = entrada[1];

					lista_de_rgms[i] = aluno.rgm;

					lista_de_alunos.inserirAluno(i, aluno);
				}
				else if(entrada[0].compareTo("skip") == 0){
					for(int j = i; j < 60; j++){
						Aluno aluno = new Aluno();
						aluno.nome = "nome";
						aluno.rgm = String.format("%08d", j);

						lista_de_rgms[j] = aluno.rgm;

						lista_de_alunos.inserirAluno(i, aluno);
					}
					i = 60;
				}
				else{
					System.out.println("\nEntrada Invalida");
					i--;
				}
		}

		// ordenando lista de alunos por rgm
		Arrays.sort(lista_de_rgms);

		Lista_Alunos lista_de_alunos_ordenada = new Lista_Alunos();

		for(int i = 0; i < 60; i++){
			for(int j = 0; j < 60; j++){
				if(lista_de_alunos.alunos[j].rgm.compareTo(lista_de_rgms[i]) == 0){
					lista_de_alunos_ordenada.inserirAluno(i, lista_de_alunos.alunos[j]);
				}
			}
		}
		
		lista_de_alunos.alunos = lista_de_alunos_ordenada.alunos;
		lista_de_alunos.tamanho = lista_de_alunos_ordenada.tamanho;

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
										"\n\t2 - Recriar Lista de Alunos"+
										"\n\t3 - Remover Aluno"+
										"\n\t4 - Sair");
									
				String opcao = scanner_principal.nextLine();

				switch (opcao) {
					case "1":
						lista_de_alunos.exibirLista();
						break;
					case "2":
						lista_de_alunos = criarListaDeAlunos();
						System.out.println("Lista de Alunos criada");
						break;
					case "3":
						System.out.println("Digite o RGM: ");
						String rgm_remover = scanner_principal.nextLine();
						
						String aluno_removido = lista_de_alunos.removerAlunoPorRGM(rgm_remover);
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
		}
		scanner_principal.close();

	}

}
