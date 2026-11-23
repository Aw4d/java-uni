package componenti;

import forme.*;
import stampante.*;

public class ImmagineVettoriale extends Immagine{
	private Forme[] forme;

	public ImmagineVettoriale(Forme[] forme) {
		super();
		this.forme = forme;
	}

	public Forme[] getForme() {
		return forme;
	}
	
	@Override
	public double consumoRed() {
		double r = 0;
		for(int i = 0; i <forme.length; i++) {
			if(forme[i] != null) {
				r += (forme[i].getC().getR()*forme[i].calcolaArea());
			}
		}
		return r;
	}
	
	@Override
	public double consumoGreen() {
		double g = 0;
		for(int i = 0; i <forme.length; i++) {
			if(forme[i] != null) {
				g += (forme[i].getC().getG()*forme[i].calcolaArea());
			}
		}
		return g;
	}
	
	@Override
	public double consumoBlue() {
		double b = 0;
		for(int i = 0; i <forme.length; i++) {
			if(forme[i] != null) {
				b += (forme[i].getC().getB()*forme[i].calcolaArea());
			}
		}
		return b;
	}
}
