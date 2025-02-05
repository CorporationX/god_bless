package school.faang.sprint.first.amazon;

import school.faang.sprint.first.amazon.manager.ProductManager;
import school.faang.sprint.first.amazon.model.Category;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Banana");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.CLOTHING, "T-shirt");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        productManager.removeProduct(Category.CLOTHING, "T-shirt");
        productManager.printAllProducts();

        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }
}
