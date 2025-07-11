package boate.model;


public abstract class Cadastro {
		private String titular;
		private int numero;
		private int idade;
		private float saldo;
		
		
		public Cadastro(String titular, int numero, int idade, float saldo) {
			this.titular = titular;
			this.numero = numero;
			this.idade = idade;
			this.saldo = saldo;
		}


		public String getTitular() {
			return titular;
		}


		public void setTitular(String titular) {
			this.titular = titular;
		}


		public int getNumero() {
			return numero;
		}


		public void setNumero(int numero) {
			this.numero = numero;
		}


		public int getIdade() {
			return idade;
		}


		public void setIdade(int idade) {
			this.idade = idade;
		}


		public float getSaldo() {
			return saldo;
		}


		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}
		
		public void depositar (float valor) {
			this.setSaldo(this.getSaldo() + valor);
		}
		
		
		public boolean comprar (float valor) {
			if (this.saldo > valor) {
				System.out.println("Compra finalizada. Divirta-se!");
				this.setSaldo(this.getSaldo() - valor);
				return true;
			} else {
				System.out.println("Saldo insuficiente!");
				return false;
			}
		}
		public void visualizar() {
			
			System.out.println("\n\n***********************************************************");
			System.out.println("Dados da Conta:");
			System.out.println("***********************************************************");
			System.out.println("Titular: " + this.titular);
			System.out.println("Numero da Conta: " + this.numero);
			System.out.println("Idade: " + this.idade);
			System.out.println("Saldo: " + this.saldo);
		}
		
		
}
