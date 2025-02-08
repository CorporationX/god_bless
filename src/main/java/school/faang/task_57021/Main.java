package school.faang.task_57021;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");

        manager.printAllProducts();

        List<Product> products = manager.findProductsByCategory(Category.FOOD);
        for (Product product : products) {
            System.out.println(product);
        }
        Set<Product> productsSet = new HashSet<Product>();
        productsSet.add(new Product("Laptop", Category.ELECTRONICS));
        productsSet.add(new Product("Smartphone", Category.ELECTRONICS));


        Map<Category, List<Product>> listMap = ProductManager.groupProductsByCategory(productsSet);
        for (Map.Entry<Category, List<Product>> entry : listMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        manager.removeProduct(Category.ELECTRONICS, "Smartphone");
        manager.printAllProducts();
    }
}
