package forme;

import stampante.Colore;

public class Cerchio extends Forme{
	private double raggio;
	
	public Cerchio(Colore c, double raggio) {
		super(c);
		this.raggio = raggio;
	}

	@Override
	public double calcolaArea() {
		return Math.PI*raggio*raggio;
	}
}
