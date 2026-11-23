package forme;

public class Quadrato extends Forme{
	private double lato;

	public Quadrato(double lato) {
		super();
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