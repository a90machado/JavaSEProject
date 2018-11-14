package io.altar.jseproject.textinterface;
import java.util.Scanner;
import io.altar.jseproject.model.Product;

public class TextInterface {

	public void userInterface() {
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");

		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		scanner.close();

		switch (userAnswer) {
		case 1:
			userInterfaceShowProducts();
			break;
		case 2:
			userInterfaceShowShelfs();
			break;
		case 3:
			//System.exit(0);
			break;
		default:
			// TODO : Clear console
			System.out.println("Valor introduzido errado, por favor repita.");
			userInterface();
			break;
		}
	}

	private void userInterfaceShowProducts() {
		//TODO LIstAGEM
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar novo produto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar detalhes de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao menu anterior");

		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		scanner.close();
		
		switch (userAnswer) {
		case 1:
			//TODO VERIFICAR VARIAVEIS
			System.out.println("Insira desconto:");
			double discontPrice = scanner.nextDouble();
			System.out.println("Insira iva:");
			double iva = scanner.nextDouble();
			System.out.println("Insira pvp:");
			double pvp = scanner.nextDouble();
			//TODO list of shelfs and id auto
			Product newProduct = new Product(discontPrice, iva, pvp);
			//TODO PUSH
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:
			userInterface();
			break;
		default:
			// TODO : Clear console
			System.out.println("Valor introduzido errado, por favor repita.");
			userInterfaceShowProducts();
			break;
		}	
		
	}

	private void userInterfaceShowShelfs() {
		//TODO LIstAGEM
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar detalhes de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao menu anterior");

		Scanner scanner = new Scanner(System.in);
		int userAnswer = scanner.nextInt();
		scanner.close();

		switch (userAnswer) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:
			userInterface();
			break;
		default:
			// TODO : Clear console
			System.out.println("Valor introduzido errado, por favor repita.");
			userInterfaceShowShelfs();
			break;
		}
	}

}
