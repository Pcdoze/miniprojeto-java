import java.util.Arrays;
import java.util.Scanner;

public class Principal {
	public static void criarListaDeAlunos(){
		Scanner scanner = new Scanner(System.in);
		Lista_Alunos lista_de_alunos = new Lista_Alunos();
		String[] lista_de_rgms = new String[60];
		
		// criando lista de alunos
		for(int i = 0; i < 60; i++){
			System.out.printf("\nInserir nome e RGM de aluno %d: (separados por espaço) ", i+1);
				String[] entrada = scanner.nextLine().split(" ");

				
				if(entrada.length == 2){
					Aluno aluno = new Aluno();
					aluno.nome = entrada[0];
					aluno.rgm = entrada[1];

					lista_de_rgms[i] = aluno.rgm;

					lista_de_alunos.inserirAluno(i, aluno);
				}
				else if(entrada[0].compareTo("skip") == 0){
					System.out.println(entrada[0]);
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
		scanner.close();

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

		lista_de_alunos.exibirLista();
	}
	public static void main(String[] args) {

		criarListaDeAlunos();
		
		//Aluno removido = lista_de_alunos.removerAluno(0);
		//System.out.println("O aluno removido foi o "+removido.getNome());

	}

}
