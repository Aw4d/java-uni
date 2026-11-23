package Conti;

public class ContoCorrente extends Conto{

	public ContoCorrente(String iban, String codFisc, double saldo) {
		super(iban, codFisc, saldo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deposita(Conto c, double deposito) {
		if(deposito > 0) {
			c.setSaldo(c.getSaldo() + deposito);
			System.out.println("Operazione riuscita, il saldo attuale è: " +c.getSaldo());
		}else {
			System.out.println("Operazione non riuscita");
		}
	}
	
	
	public void preleva(Conto c, double saldo) {
		if(c.getSaldo() >= saldo) {
			System.out.println("Operazione in corso, saldo attuale: " + c.getSaldo());
			c.setSaldo(c.getSaldo() - saldo);
			System.out.println("Operazione eseguita");
			System.out.println("Saldo attuale: " + c.getSaldo());
		}else {
			System.out.println("Saldo insufficiente per eseguire l'operazione");
		}
	}

}