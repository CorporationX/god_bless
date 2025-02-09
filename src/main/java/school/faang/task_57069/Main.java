package school.faang.task_57069;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct("Cookies", Category.FOOD);
        manager.addProduct("Bananas", Category.FOOD);
        manager.addProduct("TV", Category.ELECTRONICS);
        manager.addProduct("PlayStation", Category.ELECTRONICS);
        manager.addProduct("Book", Category.OTHER);

        manager.addProduct("PC", Category.CLOTHING);
        manager.addProduct("Cookies", Category.FOOD);

        manager.removeProduct("PC", Category.CLOTHING);

        System.out.println(Category.FOOD + ": " + manager.findProductsByCategory(Category.FOOD));

        Map<Category, List<Product>> groupedProducts = manager.groupProductsByCategory();
        System.out.println(groupedProducts);

        manager.printAllProducts();
    }
}
