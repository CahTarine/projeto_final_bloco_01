package boate.model;

public class MenorIdade extends Cadastro{
	
	private boolean acompanhante;

	public MenorIdade(String titular, int numero, int idade, float saldo) {
		super(titular, numero, idade, saldo);
		this.acompanhante = acompanhante;
	}

	public boolean isAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(boolean acompanhante) {
		this.acompanhante = acompanhante;
	}

	@Override
	public boolean comprar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("Saldo insuficiente!");
			return false;
		}
		
		if (this.acompanhante) {
			System.out.println("Sua compra foi efetuada com sucesso, com a taxa de 20 reais do acompanhante. Divirta-se!");
			this.setSaldo(this.getSaldo() - valor);
			return true;
		} else {
			System.out.println("Sua compra foi efetuada com sucesso. Divirta-se!");
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Acompanhante: " + this.acompanhante);
	}
}
