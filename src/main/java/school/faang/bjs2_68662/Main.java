package school.faang.bjs2_68662;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager(new HashSet<>());
        manager.addProduct(Category.FOOD, "BigMac");
        manager.addProduct(Category.FOOD, "Nugget");
        manager.addProduct(Category.CLOTHING, "Sweater");
        manager.addProduct(Category.CLOTHING, "Sock");
        manager.addProduct(Category.ELECTRONICS, "PC");
        manager.addProduct(Category.ELECTRONICS, "Phone");
        manager.addProduct(Category.OTHER, "Paints");
        manager.addProduct(Category.OTHER, "Brushes");
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
