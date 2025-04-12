package school.faang.bjs269869;

import java.util.List;
import java.util.Map;

import static school.faang.bjs269869.Category.FOOD;
import static school.faang.bjs269869.Category.ELECTRONICS;
import static school.faang.bjs269869.Category.CLOTHING;
import static school.faang.bjs269869.Category.OTHER;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(FOOD, "Pizza");
        productManager.addProduct(ELECTRONICS, "Smartphone");
        productManager.addProduct(ELECTRONICS, "TV");
        productManager.addProduct(OTHER, "Car");
        System.out.println(productManager.findProductsByCategory(CLOTHING));
        System.out.println(productManager.findProductsByCategory(ELECTRONICS));
        for (Map.Entry<Category, List<Product>> entry : productManager.groupProductsByCategory().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        productManager.printAllProducts();
        productManager.removeProduct(ELECTRONICS, "TV");
        productManager.printAllProducts();
    }
}
