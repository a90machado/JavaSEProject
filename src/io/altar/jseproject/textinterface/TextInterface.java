package io.altar.jseproject.textinterface;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class TextInterface {
	
	//-------------------------------------------------------------------------
	public void userInterface() {
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");

		Scanner scanner = new Scanner(System.in);
		String toTry = scanner.nextLine();
		int userAnswer = checkType(toTry,"Int") ? Integer.parseInt(toTry) : 4;
		

		switch (userAnswer) {
		case 1:
			userInterfaceShowProducts();
			break;
		case 2:
			userInterfaceShowShelfs();
			break;
		case 3:
			//System.exit(0);
			System.out.println("<>===Software desligado com sucesso!===<>");
			break;
		default:
			// TODO : Clear console
			System.out.println("Valor introduzido errado, por favor repita.");
			userInterface();
			break;
		}
		scanner.close();
	}
	//-------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------
	private void userInterfaceShowProducts() {
		//TODO LIstAGEM
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar novo produto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar detalhes de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao menu anterior");

		Scanner scanner = new Scanner(System.in);
		String toTry = scanner.nextLine();
		int userAnswer = checkType(toTry,"Int") ? Integer.parseInt(toTry) : 6;
		
		
		switch (userAnswer) {
		case 1:
			System.out.println("Insira desconto:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double")==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double discontPrice = Double.parseDouble(toTry);
			
			System.out.println("Insira iva:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double")==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double iva = Double.parseDouble(toTry);
			
			System.out.println("Insira pvp:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double")==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double pvp = Double.parseDouble(toTry);
			
			Product newProduct = new Product(discontPrice, iva, pvp);
			System.out.print("Produto adicionado com sucesso!");
			userInterfaceShowProducts();
			
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
		scanner.close();
	}
	//-------------------------------------------------------------------------
	
	//-------------------------------------------------------------------------
	private void userInterfaceShowShelfs() {
		//TODO LIstAGEM
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar detalhes de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao menu anterior");

		Scanner scanner = new Scanner(System.in);
		String toTry = scanner.nextLine();
		int userAnswer = checkType(toTry,"Int") ? Integer.parseInt(toTry) : 6;
		
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
		scanner.close();
	}
	//-------------------------------------------------------------------------
	//-------------------------------------------------------------------------
	private boolean checkType(String value, String match){
		try{
			switch (match) {
			case "Int":
				Integer.parseInt(value);
				break;
			case "Double":
				Double.parseDouble(value);
				break;
			default:
				break;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
}
