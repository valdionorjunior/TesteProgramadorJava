package junior.valdionor.testeprogramadorjava;

import java.time.LocalTime;


public class Poliposition implements Comparable<Poliposition>{
    private String posicao;
    private String hora;
    private String codigoPiloto;
    private String nomePiloto;
    private String voltaCompletadas;
    private String tempoToltal;
    private String velocidadeMediaVolta;

    
    public Poliposition(LogRefactorLine logLinha) {
    	this.hora = logLinha.getHora();
    	this.codigoPiloto = logLinha.getCodigoPiloto();
    	this.nomePiloto = logLinha.getNomePiloto();
    	this.voltaCompletadas = logLinha.getNumeroVolta();
    	this.tempoToltal = logLinha.getTempoVolta();
    	this.velocidadeMediaVolta = logLinha.getVelocidadeMediaVolta();
    			
    }

    

	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public String getCodigoPiloto() {
		return codigoPiloto;
	}


	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}


	public String getNomePiloto() {
		return nomePiloto;
	}


	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}


	public String getVoltaCompletadas() {
		return voltaCompletadas;
	}


	public void setVoltaCompletadas(String voltaCompletadas) {
		this.voltaCompletadas = voltaCompletadas;
	}


	public String getTempoToltal() {
		return tempoToltal;
	}


	public void setTempoToltal(String tempoToltal) {
		this.tempoToltal = tempoToltal;
	}


	public String getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}


	public void setVelocidadeMediaVolta(String velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}


	@Override
	public int compareTo(Poliposition outro) {
        if (Integer.parseInt(this.voltaCompletadas) > Integer.parseInt(outro.voltaCompletadas)) {
            return -1;
        }
        
        if (Integer.parseInt(this.voltaCompletadas) < Integer.parseInt(outro.voltaCompletadas)) {
            return 1;
        }

        if (this.tempoToltal.equals(outro.tempoToltal)) {
            return 0;
        }
        return LocalTime.parse(this.hora).isBefore(LocalTime.parse(outro.hora)) ? -1 : 1;
//        return 0;
	}
    
	public String toString() {
        return String.format("%12s %12s %12s %12s %12s",
            posicao.toString(), codigoPiloto.toString(), nomePiloto.toString(), voltaCompletadas.toString(), tempoToltal.toString());
    }
    
    
}
