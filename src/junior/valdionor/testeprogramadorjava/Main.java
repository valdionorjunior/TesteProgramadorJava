package junior.valdionor.testeprogramadorjava;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String caminho ="";
		String caminhoFileSave ="";
//		List<String> conteudo;
		List<LogRefactorLine> conteudo;
		
		System.out.println("*** Inicion do Processo de log ***\n\n\n");
		
		System.out.println("Digite o caminho do arquivo de entrada com nome do arquivo.txt que deseja ler: ");
		Scanner ler = new Scanner(System.in);
		caminho = ler.nextLine();
		
		conteudo = FileReadWhite.read(caminho);
				
		System.out.println("Digite o caminho com nome do arquivo.txt que deseja salvar: ");
		caminhoFileSave = ler.nextLine();
		
	    FileReadWhite.white(conteudo, caminhoFileSave);
	    
	    System.out.println("Fim do Processo de log!");
		
	}

}
