package io.altar.jseproject.textinterface;
import java.util.Iterator;
import java.util.Scanner;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	ProductRepository productRepository = ProductRepository.getInstance();
	ShelfRepository shelfRepository = ShelfRepository.getInstance();
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
		Iterator<Product> productIterator = productRepository.getAll();
		
		while (productIterator.hasNext()){
			System.out.println(productIterator.next().toString());
		}
		
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
			productRepository.save(newProduct);
			
			System.out.println("Produto adicionado com sucesso!");
			userInterfaceShowProducts();
			
			break;
		case 2:
			System.out.print("Por favor insira o ID do Produto a editar: ");
			toTry = scanner.nextLine();
			while(checkType(toTry, "Long")==false || checkIdExist(toTry)==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			long inputID = Long.parseLong(toTry);
			Product oldProduct = productRepository.findByID(inputID);
			
			System.out.print("Preco de Desconto "+oldProduct.getDiscountPrice()+" :");
			toTry = scanner.nextLine();
			if(toTry.equals("")){
				
			}else{
				while(checkType(toTry, "Double")==false){
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				Double editDiscount = Double.parseDouble(toTry);
				oldProduct.setDiscountPrice(editDiscount);
			}
			
			System.out.print("IVA "+oldProduct.getIva()+" :");
			toTry = scanner.nextLine();
			if(toTry.equals("")){
				
			}else{
				while(checkType(toTry, "Double")==false){
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				Double editIVA = Double.parseDouble(toTry);
				oldProduct.setIva(editIVA);
			}
			
			System.out.print("Preco de Venda "+oldProduct.getPvp()+" :");
			toTry = scanner.nextLine();
			if(toTry.equals("")){
				
			}else{
				while(checkType(toTry, "Double")==false){
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				Double editPVP = Double.parseDouble(toTry);
				oldProduct.setPvp(editPVP);
			}
			break;
		case 3:
			System.out.print("Por favor insira o ID do Produto a editar: ");
			toTry = scanner.nextLine();
			while(checkType(toTry, "Long")==false || checkIdExist(toTry)==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			inputID = Long.parseLong(toTry);
			Product showProduct = productRepository.findByID(inputID);
			System.out.println(showProduct.toString());
			
			
			break;
		case 4:
			System.out.print("Por favor insira o ID do Produto a editar: ");
			toTry = scanner.nextLine();
			while(checkType(toTry, "Long")==false || checkIdExist(toTry)==false){
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			inputID = Long.parseLong(toTry);
			showProduct = productRepository.findByID(inputID);
			String leitura="";
			
			char userConfirmation ='@';
		
			while (userConfirmation!='S' && userConfirmation!='n' && leitura.length()!=1){
				if(userConfirmation!='@')
					System.out.println("Valor introduzido invalido, por favor repita: ");
				else 
					userConfirmation=':';
				System.out.println("Tem a certeza que deseja apagar este produto? "+showProduct.toString()+"(S/n) :");
				leitura = scanner.nextLine();
				
				if(leitura.length()>0)
					userConfirmation = leitura.charAt(0);
				else
					continue;
				
				System.out.println(userConfirmation);
		

			}
			if (userConfirmation == 'S'){
				productRepository.removeByID(inputID);
				userInterfaceShowProducts();
			}else if (userConfirmation == 'n'){
				userInterfaceShowProducts();
			}
			
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
	private boolean checkIdExist(String id){
		if(productRepository.findByID(Long.parseLong(id))!=null)
			return true;
		else
			return false;
		
	}
	
	private boolean checkType(String value, String match){
		try{
			switch (match) {
			case "Int":
				Integer.parseInt(value);
				break;
			case "Double":
				Double.parseDouble(value);
				break;
			case "Long":
				Long.parseLong(value);
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
