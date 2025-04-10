package school.faang.bjs2_68662;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager(new HashSet<>());
        manager.addProduct(Category.FOOD, "BigMac", 1);
        manager.addProduct(Category.FOOD, "Nugget", 2);
        manager.addProduct(Category.CLOTHING, "Sweater", 3);
        manager.addProduct(Category.CLOTHING, "Sock", 4);
        manager.addProduct(Category.ELECTRONICS, "PC", 5);
        manager.addProduct(Category.ELECTRONICS, "Phone", 6);
        manager.addProduct(Category.OTHER, "Paints", 7);
        manager.addProduct(Category.OTHER, "Brushes", 8);
        manager.printAllProducts();

        System.out.println("-------GETTING PRODUCT BY CATEGORY-------");
        System.out.println(manager.findProductsByCategory(Category.FOOD));
        System.out.println("-------GETTING PRODUCT WHEN NO PRODUCT FOUND IN CATEGORY-------");
        System.out.println(manager.findProductsByCategory(Category.AIRPLANES));
        System.out.println("-------REMOVING PRODUCT BY CATEGORY AND NAME-------");
        manager.removeProduct(Category.FOOD, "BigMac");
        System.out.println("-------REMOVING NON-EXISTING PRODUCT BY CATEGORY AND NAME-------");
        manager.removeProduct(Category.CLOTHING, "Nugget");
    }
}
