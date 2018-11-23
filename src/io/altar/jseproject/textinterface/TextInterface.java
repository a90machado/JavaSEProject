// Packages:
package io.altar.jseproject.textinterface;

// Imports:
import java.util.Iterator;
import java.util.Scanner;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

// Class that implement the Interface with User
public class TextInterface {
	
	// Attributes
	String testInput;
	int userAnswer;
	long inputID;
	
	// Initializing
	ProductRepository productRepository = ProductRepository.getInstance();
	ShelfRepository shelfRepository = ShelfRepository.getInstance();
	Scanner scanner = new Scanner(System.in);

	// Main Menu:
	public void userInterface() {
		// Show Menu:
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");
		// Scan Input:
		testInput = scanner.nextLine();
		// Test Input:
		userAnswer = checkType(testInput, "Int") ? Integer.parseInt(testInput) : 4;
		
		// Actions:
		switch (userAnswer) {
		case 1:
			// Products Menu:
			userInterfaceShowProducts();
			break;
		case 2:
			// Shelf Menu:
			userInterfaceShowShelfs();
			break;
		case 3:
			// System out:
			System.out.println("<>===Software desligado com sucesso!===<>");
			break;
		default:
			// Wrong value Input:
			System.out.println("Valor introduzido errado, por favor repita.");
			userInterface();
			break;
		}
		scanner.close();
	}
	// -------------------------------------------------------------------------

	// Products Menu:
	private void userInterfaceShowProducts() {
		// Initializing:
		Iterator<Product> productIterator = productRepository.getAll();
		
		// Attributes:
		double discontPrice, iva, pvp;

		// Show all Products:
		while (productIterator.hasNext()) {
			System.out.println(productIterator.next().toString());
		}
		
		// Show Menu:
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar novo produto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar detalhes de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao menu anterior");

		// Scan Input:
		testInput = scanner.nextLine();
		// Test Input:
		userAnswer = checkType(testInput, "Int") ? Integer.parseInt(testInput) : 6;
		
		// Actions:
		switch (userAnswer) {
		case 1:
			// New Product Options:
			System.out.println("Insira desconto:");
			testInput = scanner.nextLine();
			discontPrice = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
			
			System.out.println("Insira iva:");
			testInput = scanner.nextLine();
			iva = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
			
			System.out.println("Insira pvp:");
			testInput = scanner.nextLine();
			pvp = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
			//-------------------------------------------------------------
			
			// New Object Product:
			Product newProduct = new Product(discontPrice, iva, pvp);
			// Save Product into Products Rep:
			productRepository.save(newProduct);
			System.out.println("Produto adicionado com sucesso!");
			
			// Show Products Menu:
			userInterfaceShowProducts();
			break;
		case 2:
			if (productRepository.isEmpty() == true) {
				System.out.println("Nao existem produtos para editar.");
				userInterfaceShowProducts();
			} else {
				// Check the Product to edit:
				System.out.print("Por favor insira o ID do Produto a editar: ");
				
				
				do{
					testInput = scanner.nextLine();
					testInput = repeatWhileWrong(testInput, "Long");
				} while (checkIdExistProducts(testInput)==false);
				
				inputID = Long.parseLong(repeatWhileWrong(testInput,"Long"));
				
				
				// Create Object with the Product to edit:
				Product oldProduct = productRepository.findByID(inputID);
				
				// Edit Values:
				System.out.print("Preco de Desconto " + oldProduct.getDiscountPrice() + " :");
				testInput = scanner.nextLine();
				if (testInput.equals("")) {
				} else {
					discontPrice = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
					oldProduct.setDiscountPrice(discontPrice);
				}
				//---------------------------------------------------------------------------
				System.out.print("IVA " + oldProduct.getIva() + " :");
				testInput = scanner.nextLine();
				if (testInput.equals("")) {
				} else {
					iva = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
					oldProduct.setIva(iva);
				}
				//---------------------------------------------------------------------------
				System.out.print("Preco de Venda " + oldProduct.getPvp() + " :");
				testInput = scanner.nextLine();
				if (testInput.equals("")) {
				} else {
					pvp = Double.parseDouble(repeatWhileWrong(testInput,"Double"));
					oldProduct.setPvp(pvp);
				}
				//---------------------------------------------------------------------------
				System.out.println("Produto editado com sucesso!");
				userInterfaceShowProducts();
			}
			break;
		case 3:
			if (productRepository.isEmpty() == true) {
				System.out.println("Nao existem produtos para editar.");
				userInterfaceShowProducts();
			} else {
				System.out.print("Por favor insira o ID do Produto a consultar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExistProducts(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Product showProduct = productRepository.findByID(inputID);
				System.out.println(showProduct.toString());
				System.out.println("");
				System.out.println("Pressione ENTER para voltar ao menu anterior.");
				toTry = scanner.next();
				while(!toTry.equals("")){
					toTry = scanner.nextLine();
				}
				if (toTry.equals("")){
					userInterfaceShowProducts();
				}
				
			}
			break;
		case 4:
			if (productRepository.isEmpty() == true) {
				System.out.println("Nao existem produtos para eliminar.");
				userInterfaceShowProducts();
			} else {
				System.out.print("Por favor insira o ID do Produto a eliminiar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExistProducts(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Product showProduct = productRepository.findByID(inputID);

				System.out.println("Tem a certeza que deseja apagar este produto? " + showProduct.toString() + "(S/n) :");
				String userConfirmation = scanner.nextLine();

				while (!userConfirmation.equals("S") && !userConfirmation.equals("n")) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					userConfirmation = scanner.nextLine();
				}
				if (userConfirmation.equals("S")) {
					productRepository.removeByID(inputID);
					userInterfaceShowProducts();
				} else if (userConfirmation.equals("n")) {
					userInterfaceShowProducts();
				}
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
	// -------------------------------------------------------------------------

	// -------------------------------------------------------------------------
	private void userInterfaceShowShelfs() {
		Iterator<Shelf> shelfsIterator = shelfRepository.getAll();
		while (shelfsIterator.hasNext()) {
			System.out.println(shelfsIterator.next().toString());
		}
		
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar detalhes de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao menu anterior");

		Scanner scanner = new Scanner(System.in);
		
		String toTry = scanner.nextLine();
		int userAnswer = checkType(toTry, "Int") ? Integer.parseInt(toTry) : 6;

		switch (userAnswer) {
		case 1:
			System.out.println("Insira capacidade:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Int") == false) {
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			int capacity = Integer.parseInt(toTry);
			
			System.out.println("Insira preco do alueguer: ");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double") == false) {
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double price = Double.parseDouble(toTry);
			
			Shelf newShelf = new Shelf(capacity, price);
			shelfRepository.save(newShelf);
			
			System.out.println("Prateleira adicionado com sucesso!");
			
			if (productRepository.isEmpty()==true){
				userInterfaceShowShelfs();
			} else {
				System.out.println("Deseja associar um produto?");
				System.out.println("(Selecione o ID ou pressione ENTER para ignorar.)");
				String userConfirmation = scanner.nextLine();

				while ((checkType(userConfirmation, "Long") == false && userConfirmation.length()>0 && checkIdExistProducts(userConfirmation)==false) ) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					userConfirmation = scanner.nextLine();
				}
				if (userConfirmation.length()==0){
					userInterfaceShowShelfs();
				} else {
					long productID = Long.parseLong(userConfirmation);
					newShelf.setProduct(productRepository.findByID(productID));
					System.out.println("Produto adicionado com sucesso!");
					userInterfaceShowShelfs();
				}
			}
			
			break;
		case 2:
			if (shelfRepository.isEmpty() == true) {
				System.out.println("Nao existem prateleiras para editar.");
				userInterfaceShowShelfs();
			} else {
				System.out.print("Por favor insira o ID do Produto a editar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExistShelfs(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
					System.out.println(toTry);
				}
				long inputID = Long.parseLong(toTry);
				Shelf oldShelf = shelfRepository.findByID(inputID);
				
				System.out.print("Capacidade " + oldShelf.getCapacity() + " :");
				toTry = scanner.nextLine();
				if (toTry.equals("")) {
				} else {
					while (checkType(toTry, "Int") == false) {
						System.out.println("Valor introduzido invalido, por favor repita: ");
						toTry = scanner.nextLine();
					}
					int editCapacity = Integer.parseInt(toTry);
					oldShelf.setCapacity(editCapacity);
				}
				System.out.print("Preco " + oldShelf.getPrice() + " :");
				toTry = scanner.nextLine();
				if (toTry.equals("")) {
				} else {
					while (checkType(toTry, "Double") == false) {
						System.out.println("Valor introduzido invalido, por favor repita: ");
						toTry = scanner.nextLine();
					}
					Double editPrice = Double.parseDouble(toTry);
					oldShelf.setPrice(editPrice);
				}
				System.out.println("Prateleira editada com sucesso!");
				userInterfaceShowShelfs();
			}
			break;
		case 3:
			if (shelfRepository.isEmpty() == true) {
				System.out.println("Nao existem prateleiras para consultar.");
				userInterfaceShowShelfs();
			} else {
				System.out.print("Por favor insira o ID da Prateleira a consultar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExistShelfs(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Shelf showShelf = shelfRepository.findByID(inputID);
				System.out.println(showShelf.toString());
				System.out.println("");
				System.out.println("Pressione ENTER para voltar ao menu anterior.");
				toTry = scanner.next();
				while(!toTry.equals("")){
					toTry = scanner.nextLine();
				}
				if (toTry.equals("")){
					userInterfaceShowShelfs();
				}
			}
			break;
		case 4:
			if (shelfRepository.isEmpty() == true) {
				System.out.println("Nao existem prateleiras para eliminar.");
				userInterfaceShowShelfs();
			} else {
				System.out.print("Por favor insira o ID da Prateleira a eliminiar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExistShelfs(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Shelf showShelf = shelfRepository.findByID(inputID);

				System.out.println("Tem a certeza que deseja apagar esta prateleira? " + showShelf.toString() + "(S/n) :");
				String userConfirmation = scanner.nextLine();

				while (!userConfirmation.equals("S") && !userConfirmation.equals("n")) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					userConfirmation = scanner.nextLine();
				}
				if (userConfirmation.equals("S")) {
					shelfRepository.removeByID(inputID);
					userInterfaceShowShelfs();
				} else if (userConfirmation.equals("n")) {
					userInterfaceShowShelfs();
				}
			}
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

	// -------------------------------------------------------------------------
	// -------------------------------------------------------------------------
	
	
	private boolean checkIdExistProducts(String id) {
		if (productRepository.findByID(Long.parseLong(id)) != null)
			return true;
		else
			System.out.println("O id nao existe!");
			return false;
	}
	
	private boolean checkIdExistShelfs(String id) {
		if (shelfRepository.findByID(Long.parseLong(id)) != null)
			return true;
		else{
			
			return false;
		}
			

	}
	
	private String repeatWhileWrong(String input, String match){
		while (checkType(input, match)==false){
			System.out.println("Valor Errado: ");
			testInput = scanner.nextLine();
		}
		return testInput;
	}

	private boolean checkType(String value, String match) {
		try {
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
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
