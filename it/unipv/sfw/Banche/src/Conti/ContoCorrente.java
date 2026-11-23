package Conti;

import java.util.ArrayList;

import Accountable.Accountable;

public class ContoCorrente extends Conto{
	
	// ogni conto ha un array di accountable, abbonamenti vari che vengono pagati a fine mese
	private ArrayList<Accountable> arrayAccountable;

	public ContoCorrente(String iban, String codFisc, double saldo, ArrayList<Accountable> arrayAccountable) {
		super(iban, codFisc, saldo);
		this.arrayAccountable = arrayAccountable;
		// TODO Auto-generated constructor stub
	}
	
	// getter dell'array list
	public ArrayList<Accountable> getArrayAccountable() {
		return arrayAccountable;
	}

	// metodo per depositare sul conto corrente
	public void deposita(Conto c, double deposito) {
			c.setSaldo(c.getSaldo() + deposito);
			System.out.println("Operazione riuscita, il saldo attuale è: " +c.getSaldo());
	}
	
	// metodo per prelevare dal conto corrente
	public void preleva(Conto c, double saldo) {
		if(c.getSaldo() >= saldo) {
			System.out.println("Operazione in corso, saldo attuale: " + c.getSaldo());
			c.setSaldo(c.getSaldo() - saldo);
			System.out.println("Operazione eseguita, salto attuale: " + c.getSaldo());
		}else {
			System.out.println("Saldo insufficiente per eseguire l'operazione");
		}
	}
	
	// metodo per aggiungere un accountable
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