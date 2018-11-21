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

	// -------------------------------------------------------------------------
	public void userInterface() {
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Listar produtos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");

		Scanner scanner = new Scanner(System.in);
		String toTry = scanner.nextLine();
		int userAnswer = checkType(toTry, "Int") ? Integer.parseInt(toTry) : 4;

		switch (userAnswer) {
		case 1:
			userInterfaceShowProducts();
			break;
		case 2:
			userInterfaceShowShelfs();
			break;
		case 3:
			// System.exit(0);
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
	// -------------------------------------------------------------------------

	// -------------------------------------------------------------------------
	private void userInterfaceShowProducts() {
		Iterator<Product> productIterator = productRepository.getAll();

		while (productIterator.hasNext()) {
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
		int userAnswer = checkType(toTry, "Int") ? Integer.parseInt(toTry) : 6;
		switch (userAnswer) {
		case 1:
			System.out.println("Insira desconto:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double") == false) {
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double discontPrice = Double.parseDouble(toTry);
			System.out.println("Insira iva:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double") == false) {
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double iva = Double.parseDouble(toTry);
			System.out.println("Insira pvp:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double") == false) {
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
			if (productRepository.isEmpty() == true) {
				System.out.println("Nao existem produtos para editar.");
				userInterfaceShowProducts();
			} else {
				System.out.print("Por favor insira o ID do Produto a editar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Product oldProduct = productRepository.findByID(inputID);
				System.out.print("Preco de Desconto " + oldProduct.getDiscountPrice() + " :");
				toTry = scanner.nextLine();
				if (toTry.equals("")) {
				} else {
					while (checkType(toTry, "Double") == false) {
						System.out.println("Valor introduzido invalido, por favor repita: ");
						toTry = scanner.nextLine();
					}
					Double editDiscount = Double.parseDouble(toTry);
					oldProduct.setDiscountPrice(editDiscount);
				}
				System.out.print("IVA " + oldProduct.getIva() + " :");
				toTry = scanner.nextLine();
				if (toTry.equals("")) {
				} else {
					while (checkType(toTry, "Double") == false) {
						System.out.println("Valor introduzido invalido, por favor repita: ");
						toTry = scanner.nextLine();
					}
					Double editIVA = Double.parseDouble(toTry);
					oldProduct.setIva(editIVA);
				}
				System.out.print("Preco de Venda " + oldProduct.getPvp() + " :");
				toTry = scanner.nextLine();
				if (toTry.equals("")) {

				} else {
					while (checkType(toTry, "Double") == false) {
						System.out.println("Valor introduzido invalido, por favor repita: ");
						toTry = scanner.nextLine();
					}
					Double editPVP = Double.parseDouble(toTry);
					oldProduct.setPvp(editPVP);
				}
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
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
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
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
					System.out.println("Valor introduzido invalido, por favor repita: ");
					toTry = scanner.nextLine();
				}
				long inputID = Long.parseLong(toTry);
				Product showProduct = productRepository.findByID(inputID);

				System.out
						.println("Tem a certeza que deseja apagar este produto? " + showProduct.toString() + "(S/n) :");
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
			
			System.out.println("Insira preco:");
			toTry = scanner.nextLine();
			while (checkType(toTry, "Double") == false) {
				System.out.println("Valor introduzido invalido, por favor repita: ");
				toTry = scanner.nextLine();
			}
			double price = Double.parseDouble(toTry);
			
			Shelf newShelf = new Shelf(capacity, price);
			shelfRepository.save(newShelf);

			System.out.println("Produto adicionado com sucesso!");
			userInterfaceShowShelfs();
			break;
		case 2:
			if (shelfRepository.isEmpty() == true) {
				System.out.println("Nao existem prateleiras para editar.");
				userInterfaceShowShelfs();
			} else {
				System.out.print("Por favor insira o ID do Produto a editar: ");
				toTry = scanner.nextLine();
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
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
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
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
				while (checkType(toTry, "Long") == false || checkIdExist(toTry) == false) {
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
	private boolean checkIdExist(String id) {
		if (productRepository.findByID(Long.parseLong(id)) != null || shelfRepository.findByID(Long.parseLong(id)) != null)
			return true;
		else
			return false;

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
