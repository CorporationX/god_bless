package task_BJS2_56972;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static task_BJS2_56972.Category.ELECTRONICS;
import static task_BJS2_56972.Category.FOOD;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product(0, "apple", FOOD);
        Product tv = new Product(1, "tv", ELECTRONICS);
        Product phone = new Product(2, "phone", ELECTRONICS);

        ProductManager manager = new ProductManager();
        manager.addProduct(apple.getCategory(), apple.getName());
        manager.addProduct(tv.getCategory(), tv.getName());
        manager.addProduct(phone.getCategory(), phone.getName());

        Set<Product> products = manager.getProducts();
        Map<Category, List> categoryMap = manager.getCategoryMap();

        System.out.println(products);
        System.out.println();
        System.out.println(categoryMap);


    }
}
