package Conti;

public abstract class Conto {
	private String iban;
	private String codFisc;
	private double saldo;
	
	public Conto(String iban, String codFisc, double saldo) {
		super();
		this.iban = iban;
		this.codFisc = codFisc;
		this.saldo = saldo;
	}
	
	// getter e setter di iban e saldo
	// codice fiscale ha solo il getter
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}