package Conti;

public class ContoWeb extends Conto{
	private String password;

	public ContoWeb(String iban, String codFisc, double saldo, String password) {
		super(iban, codFisc, saldo);
		this.password = "changeme";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void cambioPassword(ContoWeb c, String newPassword) {
		this.password = newPassword;
		System.out.println("Password cambiata");
	}
	
	@Override
	public void deposita(Conto c,double deposito) {
			System.out.println("inserire la password");
	}
	
	
	public void deposita(ContoWeb c, double deposito, String password) {
		if(!this.password.equals("changeme") && this.password.equals(password)) {
			System.out.println("password corretta");
			c.setSaldo(c.getSaldo() + deposito);
		}else {
			System.out.println("Password sbagliata");
		}
	}
	
	public void preleva(ContoWeb c, double saldo, String password) {
		if(c.getPassword() == password) {
			if(c.getSaldo() >= saldo) {
				System.out.println("Prelevo in corso");
				System.out.println("Operazione in corso, saldo attuale: " + c.getSaldo());
				c.setSaldo(c.getSaldo() - saldo);
				System.out.println("Operazione eseguita");
				System.out.println("Saldo attuale: " + c.getSaldo());	
			}else {
				System.out.println("Saldo insufficiente");
			}
		}else {
			System.out.println("Password sbagliata");
		}
	}
}