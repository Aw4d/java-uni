package forme;

import stampante.Colore;

public class Triangolo extends Forme{
	private double base, altezza;

	public Triangolo(Colore c, double base, double altezza) {
		super(c);
		this.base = base;
		this.altezza = altezza;
	}

	public double getBase() {
		return base;
	}

	public double getAltezza() {
		return altezza;
	}
	
	
	@Override
	public double calcolaArea() {
		return (base*altezza)/2;
	}
}
