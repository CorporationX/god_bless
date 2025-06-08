package school.faang.bjs2_79868;

import static school.faang.bjs2_79868.Category.*;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(ELECTRONICS, "Smartphone");
        productManager.addProduct(ELECTRONICS, "Laptop");
        productManager.addProduct(FOOD, "Apple");
        productManager.addProduct(FOOD, "Bread");

        productManager.addProduct(CLOTHING, "T-shirt");
        System.out.println(productManager);

        productManager.removeProduct(CLOTHING, "T-shirt");
        System.out.println(productManager);

        System.out.println(productManager.findProductsByCategory(ELECTRONICS));
        System.out.println(productManager.findProductsByCategory(CLOTHING));

        System.out.println(ProductManager.groupProductsByCategory());

        ProductManager.printAllProducts();
    }
}
