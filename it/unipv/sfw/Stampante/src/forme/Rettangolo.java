package forme;

import stampante.Colore;

public class Rettangolo extends Forme{
	private double base, altezza;
	
	public Rettangolo(Colore c, double base, double altezza) {
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
		return base*altezza;
	}
}
