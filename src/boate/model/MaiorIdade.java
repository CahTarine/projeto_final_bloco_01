package boate.model;

public class MaiorIdade extends Cadastro{
	
	private boolean camarote = false;

	public MaiorIdade(String titular, int numero, int idade, float saldo, boolean camarote) {
		super(titular, numero, idade, saldo);
		this.camarote = camarote;	
	}

	public boolean isCamarote() {
		return camarote;
	}

	public void setCamarote(boolean camarote) {
		this.camarote = camarote;
	}
	
	@Override
	public boolean comprar(float valor) {
		
		if (this.getSaldo() < valor) {
			System.out.println("Saldo insuficiente!");
			return false;
		}
		
		if (this.camarote) {
			System.out.println("Compra Ingresso Camarote efetuada com sucesso.");
			this.setSaldo(this.getSaldo() - valor);
			return true;
			
		} else {
			System.out.println("Compra Ingresso Pista efetuada com sucesso.");
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
	
	}
	
	@Override
	public void visualizar() {
		String ingresso = "";
		
		if (this.camarote) {
			ingresso = "Camarote";
		} else {
			ingresso = "Pista";
		}
		
		super.visualizar();
		System.out.println("Tipo de ingresso: " + ingresso);
	}
	
}
