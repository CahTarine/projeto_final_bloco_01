package boate;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


import boate.controller.BoateController;
import boate.model.Cadastro;
import boate.model.MaiorIdade;
import boate.model.MenorIdade;


public class Menu {

	public static void main(String[] args) {
		Scanner lerScanner = new Scanner (System.in);
		
		BoateController cadastros = new BoateController();
		

	
		
		/*MaiorIdade ma1 = new MaiorIdade("bia", 2, 89, 10);
		MenorIdade me1 = new MenorIdade("juh", 3, 9, 8);

		ma1.setCamarote(true);
		ma1.comprar(60);
		ma1.visualizar();
		
		me1.setAcompanhante(true);
		me1.depositar(200);
		me1.comprar(100);
		me1.visualizar();*/
		
		
		String titular;
		int numero, idade, opcao;
		float saldo, valor;
		boolean acompanhante, camarote;

		while (true) {
			
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("               BOATE NOITE DAS ESTRELAS              ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     "); 
			System.out.println("            1 - Criar Cadastro                       ");
			System.out.println("            2 - Listar todos os Cadastros            ");
			System.out.println("            3 - Buscar Conta por numero              ");
			System.out.println("            4 - Atualizar Dados do Cadastro          ");
			System.out.println("            5 - Apagar Cadastro                      ");
			System.out.println("            6 - Depositar                            ");
			System.out.println("            7 - Comprar                              ");
			System.out.println("            8 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			
			try {
			opcao = lerScanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				opcao = 0;
			}
			
			
			if (opcao == 8) {
				System.out.println("\nBoate Noite Das Estrelas - Agradecemos a preferencia!");
				lerScanner.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("Criar Cadastro\n\n");
				
				do {
					System.out.println("Digite seu nome: ");
					lerScanner.skip("\\R?");
					titular = lerScanner.nextLine();
					
				} while (titular.isEmpty());
				
				
				
				System.out.println("Informe o número da conta: ");
				numero = lerScanner.nextInt();
				System.out.println("Informe sua idade: ");
				idade = lerScanner.nextInt();
				System.out.println("Digite o saldo da conta: ");
				saldo = lerScanner.nextFloat();
				
				if (idade >= 18) {
					System.out.println("Deseja o ingresso para o camarote? \nDigite TRUE para 'sim' e FALSE para 'nao'!");
					camarote = lerScanner.nextBoolean();
					cadastros.cadastrar(new MaiorIdade(titular, cadastros.gerarNumero(), idade, saldo, camarote));
				} else {
					System.out.println("Deseja levar um acompanhante? \nDigite TRUE para 'sim' e FALSE para 'nao'!");
					acompanhante = lerScanner.nextBoolean();
					cadastros.cadastrar(new MenorIdade(titular, cadastros.gerarNumero(), idade, saldo, acompanhante));
				}
				
				
				keyPress();
				break;
				
			case 2:
				System.out.println("Listar todos os Cadastros\n\n");
				
				cadastros.listarTodas();
				
				keyPress();
				break;
				
			case 3:
				System.out.println("Consultar dados do Cadastro - por numero\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = lerScanner.nextInt();
				
				cadastros.procurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4:
				System.out.println("Atualizar dados do Cadastro\n\n");
				
				System.out.println("Digite o número do cadastro: ");
				numero = lerScanner.nextInt();
				
				var buscarCadastro = cadastros.buscarNaCollection(numero);
				
				if (buscarCadastro != null) {
					System.out.println("Digite seu nome: ");
					lerScanner.skip("\\R?");
					titular = lerScanner.nextLine();
					System.out.println("Informe o número da conta: ");
					numero = lerScanner.nextInt();
					System.out.println("Informe sua idade: ");
					idade = lerScanner.nextInt();
					System.out.println("Digite o saldo da conta: ");
					saldo = lerScanner.nextFloat();
					
					if (idade >= 18) {
						System.out.println("Deseja o ingresso para o camarote? \nDigite TRUE para 'sim' e FALSE para 'nao'!");
						camarote = lerScanner.nextBoolean();
						cadastros.cadastrar(new MaiorIdade(titular, cadastros.gerarNumero(), idade, saldo, camarote));
					} else {
						System.out.println("Deseja levar um acompanhante? \nDigite TRUE para 'sim' e FALSE para 'nao'!");
						acompanhante = lerScanner.nextBoolean();
						cadastros.cadastrar(new MenorIdade(titular, cadastros.gerarNumero(), idade, saldo, acompanhante));
					}
				} else {
					System.out.println("O cadastro nao foi encontrado!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				
				System.out.println("Informe o número do cadastro: ");
				numero = lerScanner.nextInt();
				
				cadastros.deletar(numero);
				

				keyPress();
				break;
				
			case 6:
				System.out.println("Depósito\n\n");
				
				System.out.println("Informe o número do cadastro: ");
				numero = lerScanner.nextInt();
				
				do {
					System.out.println("Informe o valor: ");
					valor = lerScanner.nextInt();
				} while (valor <= 0);
				
				cadastros.depositar(numero, valor);
				
				keyPress();
				break;
			
			case 7:
				System.out.println("Comprar Ingressos\n\n");
				
				System.out.println("Informe o número do Cadastro: ");
				numero = lerScanner.nextInt();
				
				do {
					System.out.println("Informe o valor da compra: ");
					valor = lerScanner.nextFloat();
				}while (valor <= 0);
				
				cadastros.comprar(numero, valor);

				
				keyPress();
				break;
				
			default:
				System.err.println("\nOpção Inválida!\n");
				
				keyPress();
				break;
			}
		}

	}
	public static void keyPress() {
		try {
			System.out.println("\n\n Pressione Enter para continuar.");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}	
}	