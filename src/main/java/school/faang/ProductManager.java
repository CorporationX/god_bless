package school.faang;

import java.util.*;

public class ProductManager {
    private int currentId;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.println("Добавлен товар:" + product);
    }

    public void removeProduct(Category category, String name) {

    }

    public ArrayList<String> findProductsByCategory(Category category) {
        return null;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return null;
    }

    public void printAllProducts() {
//        for(){
//
//        }
    }
}
