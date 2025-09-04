package school.faang;

import java.util.Set;

import java.util.HashSet;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product newProduct = new Product(name, category);
        products.add(newProduct);
    }
    
    public void removeProduct(Category category, String name) {
        products.removeIf(product ->
                product.getCategory() == category &&
                        product.getName().equals(name));
    }
}
