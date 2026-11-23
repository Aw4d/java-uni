package stampante;

public class Colore {
	private int r, g, b;

	public Colore(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
	
	@Override
    public String toString() {
        return "Colore [R=" + r + ", G=" + g + ", B=" + b + "]";
    }
}