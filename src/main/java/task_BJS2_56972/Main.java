package task_BJS2_56972;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static task_BJS2_56972.Category.ELECTRONICS;
import static task_BJS2_56972.Category.FOOD;
import static task_BJS2_56972.Category.OTHER;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product(0, "apple", FOOD);
        Product tv = new Product(1, "tv", ELECTRONICS);
        Product phone = new Product(2, "phone", ELECTRONICS);
        Product phoneTest = new Product(2, "phone", OTHER);

        ProductManager manager = new ProductManager();
        manager.addProduct(apple.getCategory(), apple.getName());
        manager.addProduct(tv.getCategory(), tv.getName());
        manager.addProduct(phone.getCategory(), phone.getName());
        manager.addProduct(phoneTest.getCategory(), phoneTest.getName());

        Set<Product> products = manager.getProducts();
        Map<Category, List<Product>> categoryMap = manager.getCategoryMap();

        System.out.println(products);
        System.out.println();
        System.out.println(categoryMap);

        manager.removeProduct(ELECTRONICS, "phone");
        System.out.println();
        System.out.println(categoryMap);

    }
}
