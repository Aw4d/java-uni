package stampante;

import componenti.*;
import forme.*;

public class Stampante {
	
	private Cartuccia [] cartucce;
	
	public Stampante() {	
		super();
		this.cartucce = new Cartuccia[3];
		this.cartucce[0]= new Cartuccia(new Colore(255, 0, 0), 10000.0);
		this.cartucce[1]= new Cartuccia(new Colore(0, 255, 0), 10000.0);
		this.cartucce[2]= new Cartuccia(new Colore(0, 0, 255), 10000.0);
		
	}
	
	public void cambioCartucce(int slot) {
		if((slot >= 0) && ( slot < this.cartucce.length)) {
			this.cartucce[slot].setQuantita();
			System.out.println("Cartuccia numero " +slot + " cambiata");
		} else {
			System.out.println("Cartuccia numero " +slot + " inesistente");
			System.out.println("Inserire una cartuccia tra 0 e 2");
		}
	}
	
	public void quantitaCartuccia(int slot) {
		if((slot >= 0) && ( slot < this.cartucce.length)) {
			System.out.println("la percentuale di colore rimasta nella cartuccia " +slot + " è: "+ this.cartucce[slot].percentualeCartuccia()+"%");
		} else {
			System.out.println("Cartuccia numero " +slot + " inesistente");
			System.out.println("Inserire una cartuccia tra 0 e 2");
		}
	}

	public void stampaVettoriale(Stampabile immagineForme) {
		double consumoR = immagineForme.consumoRed();
		double consumoG = immagineForme.consumoGreen();
		double consumoB = immagineForme.consumoBlue();
		
		this.cartucce[0].coloreRimanente(consumoR);
		this.cartucce[1].coloreRimanente(consumoG);
		this.cartucce[2].coloreRimanente(consumoB);
		
		quantitaCartuccia(0);
		quantitaCartuccia(1);
		quantitaCartuccia(2);
		
	}
	
	public void stampaRaster(Stampabile immagineRaster) {
		double consumoR = immagineRaster.consumoRed();
		double consumoG = immagineRaster.consumoGreen();
		double consumoB = immagineRaster.consumoBlue();
		
		this.cartucce[0].coloreRimanente(consumoR);
		this.cartucce[1].coloreRimanente(consumoG);
		this.cartucce[2].coloreRimanente(consumoB);
		
		quantitaCartuccia(0);
		quantitaCartuccia(1);
		quantitaCartuccia(2);
		
	}
	
	
	
	
	
	
	
	// Getter e Setter
	public void setCartucce(Cartuccia[] cartucce) {
		this.cartucce = cartucce;
	}


	public Stampante(Cartuccia[] cartucce) {
		this.cartucce = cartucce;
	}

	

	public static void main(String [] args) {
		Colore c1 = new Colore(255, 0, 0);
		Colore c2 = new Colore(0, 255, 0);
		Colore c3 = new Colore(0, 0, 255);
		
		Forme[] f = new Forme[3];
		Colore[][] p = new Colore[2][3];
		p[0][0] = c1;
		p[0][1] = c2;
		p[0][2] = c2;
		p[1][0] = c3;
		p[1][1] = c3;
		p[1][2] = c3;
		
		f[0] = new Triangolo(c1, 3, 3);
		f[1] = new Quadrato(c2, 4);
		f[2] = new Rettangolo(c3, 5, 4);
		
		Stampante s = new Stampante();
		ImmagineVettoriale i = new ImmagineVettoriale(f);
		ImmagineRaster imr = new ImmagineRaster(p);
		
		
		s.stampaVettoriale(i);
		s.stampaVettoriale(imr);
		
//		System.out.println(f[0].getC());
//		System.out.println(f[1].getC());
//		System.out.println(f[2].getC());
//		
//		System.out.println(p[0][0]);
//		System.out.println(p[1][0]);
		
//		System.out.println("il consumo di rosso è: "+ i.consumoRed());
//		System.out.println("il consumo di verde è: "+i.consumoGreen());
//		System.out.println("il consumo di blu è: "+ i.consumoBlue());
		
		/*System.out.println(red.coloreRimanente(red.getColore(), i.consumoRed()));
		System.out.println(green.coloreRimanente(green.getColore(), i.consumoGreen()));
		System.out.println(blue.coloreRimanente(blue.getColore(), i.consumoBlue()));
		
//		System.out.println(i.consumoBlue());
		
		System.out.println(red.coloreRimanente(red.getColore(), imr.consumoRed()));
		System.out.println(green.coloreRimanente(green.getColore(), imr.consumoGreen()));
		System.out.println(blue.coloreRimanente(blue.getColore(), imr.consumoBlue()));*/

	}


	
}
