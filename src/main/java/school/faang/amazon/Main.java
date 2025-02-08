package school.faang.amazon;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(Category.FOOD, "Egg");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");
        productManager.addProduct(Category.CLOTHING, "T-shirt");
        productManager.addProduct(Category.CLOTHING, "Underpants");
        productManager.addProduct(Category.OTHER, "Car");
        productManager.printAllProducts();
        System.out.println("_____________________________________");
        List<Product> productList = productManager.findProductsByCategory(Category.FOOD);
        System.out.println(productList);
        System.out.println("_____________________________________");
        System.out.println("Remove Car");
        productManager.removeProduct(Category.OTHER, "Car");
        System.out.println("After remove: ");
        productManager.printAllProducts();
        Map<Category, List<Product>> categoryMap = productManager.groupProductsByCategory();
    }
}
