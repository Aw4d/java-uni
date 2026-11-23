package Banche;

import java.util.ArrayList;

import Accountable.*;
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

	// getter e setter della radice e dei conti attivi
	public String getRad() {
		return rad;
	}

	public void setRad(String rad) {
		this.rad = rad;
	}
	
	public int getContiAttivi() {
		return contiAttivi;
	}

	public void setContiAttivi(int contiAttivi) {
		this.contiAttivi = contiAttivi;
	}
	
	// getter del vettore di conti
	public Conto[] getC() {
		return c;
	}

	// metodo per aggiungere un conto web
	public void aggiungiContoWeb(String codFisc, ArrayList<Accountable> accounts) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoWeb(this.rad + contiAttivi, codFisc, 0.0, "changeme", accounts);
			System.out.println("Conto Web creato");
			this.contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
	}
	
	// metodo per aggiungere un conto corrente
	public void aggiungiContoCorrente(String codFisc, ArrayList<Accountable> accounts) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoCorrente(this.rad + contiAttivi, codFisc, 0.0, accounts);
			System.out.println("Conto Corrente creato");
			contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
	}
	
	// metodo per aggiungere un conto deposito
	public void aggiungiContoDeposito(String codFisc) {
		if(this.contiAttivi < maxConti) {
			c[this.contiAttivi] = new ContoDeposito(rad + contiAttivi, codFisc, 0.0);
			System.out.println("Conto Deposito creato");
			contiAttivi++;
		} else {
			System.out.println("limite conti raggiunto");
		}
	}

	// metodo per depositare per tutti i conti
	public void depositaBanca(int posizione, double importo, String password) {
		if (posizione < 0 || posizione >= contiAttivi) {
			System.out.println("Posizione non valida");
			return;
		}
		if (c[posizione].getClass() == ContoDeposito.class) {
			ContoDeposito cD= (ContoDeposito) c[posizione];
			System.out.println("operazione in corso");
			cD.deposita(cD, importo);
		}else if (c[posizione].getClass() == ContoCorrente.class) {
			ContoCorrente cC= (ContoCorrente) c[posizione];
			System.out.println("operazione in corso");
			cC.deposita(cC, importo);
		} else if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cW= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cW.deposita(cW, importo, password);
		}
	}
	
	// metodo per prelevare, solo se è un conto corrente o web, i conti deposito non possono prelevare
	public void prelevaBanca(int posizione, double importo, String password) {
		if (posizione < 0 || posizione >= contiAttivi) {
			System.out.println("Posizione non valida");
			return;
		}
		if (c[posizione].getClass() == ContoDeposito.class) {
			System.out.println("non è possibile eseguire questa operazione");
		}else if (c[posizione].getClass() == ContoCorrente.class) {
			ContoCorrente cC= (ContoCorrente) c[posizione];
			System.out.println("operazione in corso");
			cC.preleva(cC, importo);
		} else if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cW= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cW.preleva(cW, importo, password);
		}
	}
	
	// metodo per cambiare la password de conto web
	public void cambioPassword(int posizione, String newPassword) {
		if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cw= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cw.cambioPassword(newPassword);
		} else return;
	}
	
	// metodo per aggiungere un accountable ad un determinato conto
	public void aggiungiAccountable(int posizione, Accountable Acc) {
		if (posizione < 0 || posizione >= contiAttivi || c[posizione].getClass() == ContoDeposito.class) {
			System.out.println("Posizione non valida");
			return;
		}else if (c[posizione].getClass() == ContoCorrente.class) {
			ContoCorrente cC= (ContoCorrente) c[posizione];
			System.out.println("operazione in corso");
			cC.aggiungiAccountable(cC, Acc);
		} else if (c[posizione].getClass() == ContoWeb.class) {
			ContoWeb cW= (ContoWeb) c[posizione];
			System.out.println("operazione in corso");
			cW.aggiungiAccountable(cW, Acc);
		}
	}
	
	// metodo per pagare tutti gli accountable a fine mese
	public void pagamentoAccountable() {
		for (int i = 0; i < contiAttivi; i++) {
			if (c[i] != null) {
				if (c[i].getClass() == ContoCorrente.class) {
					ContoCorrente cC = (ContoCorrente) c[i];
					System.out.println("Operazione in corso su Conto Corrente");
					double totale = cC.pagamentoAccountable();
					if (totale > 0) {
						cC.deposita(cC, totale);
					} else if (totale < 0) {
						cC.preleva(cC, -totale);
					}
				} else if (c[i].getClass() == ContoWeb.class) {
					ContoWeb cW = (ContoWeb) c[i];
					System.out.println("Operazione in corso su Conto Web");
					System.out.println("password: " +cW.getPassword());
					double totale = cW.pagamentoAccountable();
					if (totale > 0) {
						cW.deposita(cW, totale, cW.getPassword());
					} else if (totale < 0) {
						cW.preleva(cW, -totale, cW.getPassword());
					}
				}
			}
		}
	}
	
	public static void main(String [] args) {
		
		// creazione di persone
		Persona p1 = new Persona("BO1", "COGNOME1", "CDF1");
		Persona p2 = new Persona("BO2", "COGNOME2", "CDF2");
		Persona p3 = new Persona("BO3", "COGNOME3", "CDF3");
		
		// creazione di una banca
		Banca b1 = new Banca("ITUNIPV");
		
		// creazione e aggiunta dei conti alla banca
		b1.aggiungiContoCorrente(p1.getCf(), new ArrayList<Accountable>());
		b1.aggiungiContoDeposito(p2.getCf());
		b1.aggiungiContoWeb(p3.getCf(), new ArrayList<Accountable>());
		
		// cambio della password del conto web
		b1.cambioPassword(2, "ciao");
		
		//aggiunta degli accountble
		b1.aggiungiAccountable(0, new Accountable("stipendio", 1500));
		b1.aggiungiAccountable(0, new Accountable("svago", -100));
		b1.aggiungiAccountable(0, new Accountable("affitto", -1000));
		b1.aggiungiAccountable(0, new Accountable("spesa", -200));
		b1.aggiungiAccountable(0, new Accountable("windtre", -10));
	/*	
		b1.aggiungiAccountable(1, new Accountable("stipendio", 1200));
		b1.aggiungiAccountable(1, new Accountable("svago", -100));
		b1.aggiungiAccountable(1, new Accountable("affitto", -1000));
		b1.aggiungiAccountable(1, new Accountable("spesa", -200));
		b1.aggiungiAccountable(1, new Accountable("tim", -10));
	*/	
		b1.aggiungiAccountable(2, new Accountable("stipendio", 2000));
		b1.aggiungiAccountable(2, new Accountable("svago", -180));
		b1.aggiungiAccountable(2, new Accountable("affitto", -1200));
		b1.aggiungiAccountable(2, new Accountable("spesa", -250));
		b1.aggiungiAccountable(2, new Accountable("vodafone", -10));
		b1.aggiungiAccountable(2, new Accountable("benzina", -100));
		
		// pagamento degli accountable
		b1.pagamentoAccountable();
	}
}