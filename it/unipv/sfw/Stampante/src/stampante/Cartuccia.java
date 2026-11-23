package stampante;

public class Cartuccia {
	final double maxQuantita = 10000.0;
	private Colore colore;
	private double quantita;
	
	public Cartuccia(Colore colore, double quantita) {
		super();
		this.colore = colore;
		this.quantita = quantita;
	}

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}

	public double getQuantita() {
		return quantita;
	}

	public void setQuantita() {
		this.quantita = maxQuantita; 
	}
	
	public double coloreRimanente(double consumo) {
		
		if(this.quantita >= consumo) {
			this.quantita -= consumo;
			return this.quantita;
		} else {
			System.out.println("Percentuale di colore della cartuccia è insufficiente");
			return this.quantita;
		}
		
	}
	public double percentualeCartuccia() {
		double percentuale = (this.quantita/this.maxQuantita)*100;
		return Math.round(percentuale);
	}
}