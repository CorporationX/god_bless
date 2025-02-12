package school.faang.BJS2_56979;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();

        pm.addProduct(Category.FOOD, "Apple");
        pm.addProduct(Category.FOOD, "Banana");
        pm.addProduct(Category.FOOD, "Orange");
        pm.addProduct(Category.ELECTRONICS, "Laptop");
        pm.addProduct(Category.ELECTRONICS, "Smartphone");
        List<Product> foods = pm.findProductsByCategory(Category.FOOD);
        System.out.println(foods);
        pm.printAllProducts();
        pm.removeProduct(Category.FOOD, "Apple");
        pm.printAllProducts();
    }
}
