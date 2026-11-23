package forme;

import stampante.Colore;

public class Quadrato extends Forme{
	private double lato;

	public Quadrato(Colore c, double lato) {
		super(c);
		this.lato = lato;
	}

	public double getBase() {
		return lato;
	}
	
	@Override
	public double calcolaArea() {
		return lato*lato;
	}
}
