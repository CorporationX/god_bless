package school.faang.sprint_1.task_45133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    Map<String, List<Product>> products = new HashMap<>();


    public void addItem(String category, String name) {
        Product product = new Product(2, name, category);
        Map<String, Product> pr = new HashMap<>();

    }

    public boolean removeItem(String category, String name) {

        return true;
    }
    public void findItemsByCategory(String category) {
        if (products.containsKey(category)) {
            System.out.println("Category - " + category);
            for (Product product : products.get(category)) {
                System.out.println(product);
            }
        } else {
            System.out.println(category + " not found");
        }
    }

    public void printAllItems() {
        for (var entry : products.entrySet()) {
            System.out.println("Category - " + entry.getKey() + "product: " + entry.getValue());
        }
    }
}
