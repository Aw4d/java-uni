package Conti;

import java.util.ArrayList;

import Accountable.Accountable;

public class ContoWeb extends Conto{
	private String password;
	private ArrayList<Accountable> arrayAccountable;

	public ContoWeb(String iban, String codFisc, double saldo, String password, ArrayList<Accountable> arrayAccountable) {
		super(iban, codFisc, saldo);
		this.password = "changeme";
		this.arrayAccountable = arrayAccountable;
	}
	
	// getter dell'arary list
	public ArrayList<Accountable> getArrayAccountable() {
		return arrayAccountable;
	}
	
	// getter e setter della password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// metodo per cambiare la password del conto web, è obbligatorio per poter prelevare e depositare
	public void cambioPassword(String newPassword) {
		this.password = newPassword;
		System.out.println("Password cambiata");
	}

	// metodo per depositare dal conto web senza password (impedisce di depositare)
	public void deposita(Conto c,double deposito) {
			System.out.println("inserire la password");
	}
	
	// metodo per depositare dal conto web
	public void deposita(ContoWeb c, double deposito, String password) {
		if(!this.password.equals("changeme") && this.password.equals(password)) {
			System.out.println("password corretta");
			System.out.println("saldo attuale: " + c.getSaldo());
			c.setSaldo(c.getSaldo() + deposito);
			System.out.println("deposito effettuato, saldo: " + c.getSaldo());
		}else {
			System.out.println("Password sbagliata");
		}
	}
	
	// metodo per prelevare dal conto web
	public void preleva(ContoWeb c, double saldo, String password) {
		if(!this.password.equals("changeme") && this.password.equals(password)) {
			if(c.getSaldo() >= saldo) {
				System.out.println("Prelevo in corso");
				System.out.println("saldo attuale: " + c.getSaldo());
				c.setSaldo(c.getSaldo() - saldo);
				System.out.println("Operazione eseguita, saldo attuale: " + c.getSaldo());
			}else {
				System.out.println("Saldo insufficiente");
			}
		}else {
			System.out.println("Password sbagliata");
		}
	}
	
	// metodo per aggiungere degli accountable
	public void aggiungiAccountable(Conto c, Accountable acc) {
		System.out.println("Accountable aggiunto: " +acc.getNome() +" "+ acc.getSaldo());
		arrayAccountable.add(acc);
	}
	
	// metodo per contare il totale di tutti gli accountable
	public double pagamentoAccountable() {
		double totale = 0.0;
		for(int i = 0; i < arrayAccountable.size(); i++) {
			totale += getArrayAccountable().get(i).getSaldo();
		}
		return totale;
	}
}