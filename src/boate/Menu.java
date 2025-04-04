package boate;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import boate.model.MaiorIdade;
import boate.model.MenorIdade;


public class Menu {

	public static void main(String[] args) {
		Scanner lerScanner = new Scanner (System.in);
		
		MaiorIdade ma1 = new MaiorIdade("bia", 2, 89, 10);
		MenorIdade me1 = new MenorIdade("juh", 3, 9, 8);

		/*ma1.setCamarote(true);
		ma1.comprar(60);
		ma1.visualizar();*/
		
		me1.setAcompanhante(true);
		me1.depositar(200);
		me1.comprar(100);
		me1.visualizar();
		
		int opcao;

		while (true) {
			
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("               BOATE NOITE DAS ESTRELAS              ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     "); 
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por numer               ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
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
				System.out.println("Criar Conta\n\n");
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por numero\n\n");

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");

				keyPress();
				break;
			case 6:
				System.out.println("Depósito\n\n");

				keyPress();
				break;
			
			case 7:
				System.out.println("Comprar Ingressos\n\n");
				
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