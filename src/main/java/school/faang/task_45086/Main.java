package school.faang.task_45086;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addItem(Category.CLOTHING, "Product1");
        productManager.addItem(Category.CLOTHING, "Product2");
        productManager.addItem(Category.CLOTHING, "Product6");
        productManager.addItem(Category.FOOD, "Product3");
        productManager.addItem(Category.ELECTRONICS, "Product2");

        productManager.removeItem(Category.CLOTHING, "Product1");
        productManager.printAllItems();

        productManager.findItemsByCategory(Category.CLOTHING);

        Map<Category, Set<Product>> groupedProducts = productManager.groupProductsByCategory();
        productManager.printProductsByCategory(groupedProducts);
    }
}
