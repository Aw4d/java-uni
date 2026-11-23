package forme;

import stampante.Colore;

public abstract class Forme {
	private Colore c;

	public Forme(Colore c) {
		super();
		this.c = c;
	}

	public Colore getC() {
		return c;
	}

	public abstract double calcolaArea();
}