package school.faang.task_45135;

import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        HashSet<Product> products = new HashSet<>();

        products.add(new Product(1, "Banana", "Fruit"));
        products.add(new Product(2, "Grape", "Fruit"));
        products.add(new Product(3, "Sprite", "Beverage"));
        products.add(new Product(4, "Tomato", "Vegetable"));
        products.add(new Product(5, "Eggplant", "Vegetable"));
        products.add(new Product(6, "Ice cream", "Frozen"));

        Map<String, java.util.List<Product>> groupedProducts = productManager.groupProductsByCategory(products);
        productManager.printProductsByCategory(groupedProducts);
    }
}
