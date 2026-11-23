package Banche;

import Conti.*;
import Persona.*;

public class Banca {
	private String rad;
	private Conto[] c;
	final int maxConti = 10;
	private int contiAttivi;

	public Banca(String rad) {
		super();
		this.rad = rad;
		this.c = new Conto[maxConti];
		this.contiAttivi = 0;
	}

	public String getRad() {
		return rad;
	}

	public void setRad(String rad) {
		this.rad = rad;
	}
	
//	public void operazione(Conto c, double importo) {
//		
//	}
	
	public void aggiungiContoWeb(String codFisc) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoWeb(this.rad + contiAttivi, codFisc, 0.0, "changeme");
			System.out.println("Conto Web creato");
			contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
	}
	
	public void aggiungiContoCorrente(String codFisc) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoCorrente(this.rad + contiAttivi, codFisc, 0.0);
			System.out.println("Conto Corrente creato");
			contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
		
	}
	
	public void aggiungiContoDeposito(String codFisc) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoDeposito(rad + contiAttivi, codFisc, 0.0);
			System.out.println("Conto Deposito creato");
			contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
	}

	public void depositaBanca(int posizione, double importo, String password) {
		if (posizione < 0 || posizione >= contiAttivi) {
			System.out.println("Posizione non valida");
			return;
		}
		if (c[posizione].getClass() == ContoCorrente.class || c[posizione].getClass() == ContoDeposito.class) {
			c[posizione].deposita(c[posizione], importo); 
		} else if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cw= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cw.deposita(cw, 10, password);
		}
	}
	
	public void prelevaBanca(int posizione, double importo, String password) {
		if (posizione < 0 || posizione >= contiAttivi) {
			System.out.println("Posizione non valida");
			return;
		}
		if (c[posizione].getClass() == ContoDeposito.class) {
			System.out.println("non è possibile eseguire questa operazione");
		}else if (c[posizione].getClass() == ContoCorrente.class) {
			c[posizione].deposita(c[posizione], importo); 
		} else if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cw= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cw.preleva(cw, 10, password);
		}
	}
	
	public static void main(String [] args) {
		
		Persona p1 = new Persona("BO1", "COGNOME1", "CDF1");
		Persona p2 = new Persona("BO2", "COGNOME2", "CDF2");
		Persona p3 = new Persona("BO3", "COGNOME3", "CDF3");
		Persona p4 = new Persona("BO4", "COGNOME4", "CDF4");
		
		 
		Banca b1 = new Banca("ITUNIPV");
		b1.aggiungiContoCorrente(p1.getCf());
		b1.aggiungiContoDeposito(p2.getCf());
		b1.aggiungiContoWeb(p3.getCf());
		b1.depositaBanca(0, 10, null);
		b1.depositaBanca(0, 20, null);
		b1.depositaBanca(2, 20, "ciao");
		
		// collegare banca a password
		
		
		
		/*
		ContoCorrente c1 = new ContoCorrente("001", p1, 0);
		ContoDeposito c2 = new ContoDeposito("002", p2, 0);
		ContoWeb c3 = new ContoWeb("003", p3, 0, "changeme");
		ContoCorrente c4 = new ContoCorrente("004", p4, 0);
		
		
		System.out.println("deposito conto 1: ");
		c1.deposita(c1, 10.0);
		System.out.println("prelievo conto 1: ");
		c1.preleva(c1, 10);
		
		System.out.println("deposito conto 2: ");
		c2.deposita(c2, 10);
	
		System.out.println("deposito conto 3: ");
		c3.deposita(c3, 10);
		c3.cambioPassword(c3, "ciao");
		c3.preleva(c3, 10, "ciao");
		
		System.out.println("dati conto 1: " + c1.getP().getCf()+ " " + c1.getP().getCognome()+ " " + c1.getP().getNome());
		System.out.println("dati conto 2: " + c2.getP().getCf()+ " " + c2.getP().getCognome()+ " " + c2.getP().getNome());
		System.out.println("dati conto 3: " + c3.getP().getCf()+ " " + c3.getP().getCognome()+ " " + c3.getP().getNome());
	*/}
}