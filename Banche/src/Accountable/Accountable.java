package Accountable;
import Conti.Conto;

public class Accountable {
	private Conto c;
	private double saldo;
	private String radice;
	
	public Accountable(String radice, Conto c, double saldo) {
		super();
		this.c = c;
		this.saldo = saldo;
	}

	public Conto getC() {
		return c;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public String getRadice() {
		return radice;
	}	
}