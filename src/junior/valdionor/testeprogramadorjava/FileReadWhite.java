package junior.valdionor.testeprogramadorjava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReadWhite {
	
	private static List<LogRefactorLine>logLinha = new ArrayList<LogRefactorLine>();
	private static List<Poliposition>logPoli = new ArrayList<Poliposition>();
	
//	public static List<String> read(String caminho) {
	public static List<LogRefactorLine> read(String caminho) {
	    try {
	      FileReader arq = new FileReader(caminho);
	      BufferedReader lerArq = new BufferedReader(arq);
	      String linha = lerArq.readLine(); // lê a primeira linha (Header do arquivo)
	      ArrayList<String>conteudo = new ArrayList<>();
	      conteudo.clear();//limpa a lista
	      
	      String[] linhaNova;

	      while (linha != null) {
	    	  linha = lerArq.readLine(); // lê apartir da segunda linha, ja sem o header
	    	  if(linha!=null) {
	    		  linhaNova= linha.split("\\s+");//retira os espaços totais da string
//	    		  linha="";
//	    		  for (String string : linhaNova) {
//					linha += string +" ";
//				    }
	    		  logLinha.add(new LogRefactorLine(linhaNova[0], linhaNova[1], linhaNova[3], linhaNova[4], linhaNova[5], linhaNova[6]));

//	    		conteudo.add(linha);
	    	  }
	      }
	      
	      arq.close();
	      
//	      return conteudo;
	      return logLinha;
	      
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: "+caminho+".\n",
	          e.getMessage());
	        return null;
	    }
		
	};
	
//	public static void white(List<String> conteudo, String caminhoFile) { LogRefactorLine
	public static void white(List<LogRefactorLine> conteudo, String caminhoFile) { 

		try {
			FileWriter file = new FileWriter(caminhoFile);
			PrintWriter recordFile = new PrintWriter(file);
			
		      calculatedPosition(conteudo);
			
		      //escreve a linha do arquvi pra gente
		      //escreve o header
		      recordFile.println("Posição Chegada, Código Piloto; Nome Piloto; Qtde Voltas Completadas; Tempo Total de Prova\n");
		      for (Poliposition campeoes : logPoli) {
				recordFile.println(campeoes.toString());
			}
			
			recordFile.close();
			file.close();
			
			System.out.println("Arquivo gerado com sucesso em: "+caminhoFile+".\n");
		}catch (IOException e) {
			System.err.printf("Erro ao criar um novo arquivo no caminho: "+caminhoFile+".\n",
			e.getMessage());
		}
	}
	
	private static void calculatedPosition(List<LogRefactorLine> conteudo) {
		Collections.sort(conteudo);
		logPoli.clear();

		List<Poliposition> poliposition = new ArrayList<>();
//		List<Poliposition> poliposition2 = new ArrayList<>();
		
		for (LogRefactorLine logRefactorLine : conteudo) {
			logPoli.add(new Poliposition(logRefactorLine));
		}
		
		Collections.sort(logPoli);
		
		String nome=" ";
		for (Poliposition poli : logPoli) {
			if(!nome.toLowerCase().contains(poli.getNomePiloto().toLowerCase().substring(0, 5))) {
				poliposition.add(poli);
				nome +=poli.getNomePiloto()+" ";
			}
		}
		
		//posições finais.
		for(int i=0; i< poliposition.size(); i++) {
			poliposition.get(i).setPosicao(String.valueOf(i+1));
		}
		
		calculatedTime(conteudo);
		
		logPoli = poliposition;
		
	}
	
	private static void calculatedTime(List<LogRefactorLine> conteudo) {
		String[] tempo;
		int min=0;
		int sec=0;
		int nano=0;
		
		for (Poliposition competidor : logPoli) {
			for (LogRefactorLine competirAux : conteudo) {
				if(competidor.getNomePiloto().toLowerCase().contains(competirAux.getNomePiloto().toLowerCase().substring(0,5))){

						tempo = competirAux.getTempoVolta().split("(\\.|:)");
						min+= Integer.parseInt(tempo[0]);
						sec+= Integer.parseInt(tempo[1]);
						nano+= Integer.parseInt(tempo[2]);
						
						if(sec>=60) {
							min+= sec/60;
							sec= sec-60;
						}
						
						competidor.setTempoToltal(min+":"+sec+"."+nano);
					
				}
			}
		}
	}
	
}
