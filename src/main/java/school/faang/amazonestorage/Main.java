package school.faang.amazonestorage;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(Category.FOOD, "burger");
        manager.addProduct(Category.FOOD, "egg");
        manager.addProduct(Category.ELECTRONICS, "laptop");
        manager.addProduct(Category.ELECTRONICS, "mouse");
        manager.addProduct(Category.CLOTHING, "t-shirt");
        manager.addProduct(Category.CLOTHING, "underpants");
        manager.addProduct(Category.OTHER, "plane");
        System.out.println("_________________");

        manager.printAllProducts();
        System.out.println("_________________");
        System.out.println("Find in category FOOD:");
        List<Product> foodProduct = manager.findProductsByCategory(Category.FOOD);
        System.out.println(foodProduct);
        System.out.println("_________________");
        manager.removeProduct(Category.OTHER, "plane");
        System.out.println("Print after remove plane");
        manager.printAllProducts();
        System.out.println("_________________");
        System.out.println("Group products");
        Map<Category, List<Product>> groupingProducts = manager.groupProductsByCategory();


    }
}
