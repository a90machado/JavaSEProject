// Packages:
package io.altar.jseproject.repositories;

// Import:
import io.altar.jseproject.model.Product;

// Class Product Repository that Extends to DataBase - Singleton
public class ProductRepository extends EntityRepository<Product> {
	
	// Instance:
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	// Constructor:
	private ProductRepository(){	
	}
	
	// Get:
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	
}
