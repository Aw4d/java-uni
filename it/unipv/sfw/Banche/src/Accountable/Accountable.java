package Accountable;
import Conti.Conto;

public class Accountable {
	private String nome;
	private double saldo;
	
	public Accountable(String nome, double saldo) {
		super();
		this.nome = nome;
		this.saldo = saldo;
	}

	// getter e setter di nome e saldo dell'accountable
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}