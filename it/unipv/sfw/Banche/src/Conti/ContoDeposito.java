package Conti;

public class ContoDeposito extends Conto{

	public ContoDeposito(String iban, String codFisc, double saldo) {
		super(iban, codFisc, saldo);
		// TODO Auto-generated constructor stub
	}

	// metodo per depositare sul conto deposito
	public void deposita(Conto c, double deposito) {
			c.setSaldo(c.getSaldo() + deposito);
			System.out.println("Operazione riuscita, il saldo attuale è: " +c.getSaldo());
	}
}