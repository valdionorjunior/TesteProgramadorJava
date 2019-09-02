package junior.valdionor.testeprogramadorjava;

import java.time.LocalTime;

public class LogRefactorLine implements Comparable<LogRefactorLine>{
	
	private String hora;
    private String codigoPiloto;
    private String nomePiloto;
	private String NumeroVolta;
    private String TempoVolta;
    private String velocidadeMediaVolta;
    
    public LogRefactorLine(String hora, String codigoPiloto, String nomePiloto, String numeroVolta, String tempoVolta,
			String velocidadeMediaVolta) {
		this.hora = hora;
		this.codigoPiloto = codigoPiloto;
		this.nomePiloto = nomePiloto;
		NumeroVolta = numeroVolta;
		TempoVolta = tempoVolta;
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	public String getNumeroVolta() {
		return NumeroVolta;
	}

	public void setNumeroVolta(String numeroVolta) {
		NumeroVolta = numeroVolta;
	}

	public String getTempoVolta() {
		return TempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		TempoVolta = tempoVolta;
	}

	public String getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	public void setVelocidadeMediaVolta(String velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	@Override
	public int compareTo(LogRefactorLine outroPiloto) {
		
		if (this.codigoPiloto != outroPiloto.codigoPiloto) {
            return this.codigoPiloto.compareTo(outroPiloto.codigoPiloto);
        } 

        return Integer.compare(Integer.parseInt(this.NumeroVolta), Integer.parseInt(outroPiloto.NumeroVolta));
	}

	public String toString() {
        return String.format("%12s %12s %12s %12s %12s %12s",
            hora.toString(), codigoPiloto.toString(), nomePiloto.toString(), NumeroVolta, TempoVolta.toString(), velocidadeMediaVolta.toString());
    }
}
