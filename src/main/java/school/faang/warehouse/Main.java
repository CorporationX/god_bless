package school.faang.warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ProductManager products = new ProductManager();
        products.addProduct(Category.FOOD, "Pineapple");
        products.addProduct(Category.FOOD, "Burger");
        products.addProduct(Category.ELECTRONICS, "Iphone");
        products.addProduct(Category.CLOTHING, "Coat");

        products.printAllProducts();

        List<Product> foodProducts = products.findProductsByCategory(Category.FOOD);
        for (Product product : foodProducts) {
            System.out.println(product.getName());
        }
        products.removeProduct(Category.FOOD, "Pineapple");
        products.printAllProducts();
    }
}
