package school.faang.bjs2_68950;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(Category.FOOD, "хлеб");
        manager.addProduct(Category.FOOD, "вода");
        manager.addProduct(Category.FOOD, "соль");
        manager.addProduct(Category.ELECTRONICS, "телефон");
        manager.addProduct(Category.ELECTRONICS, "телевизор");
        manager.addProduct(Category.ELECTRONICS, "планшет");
        manager.addProduct(Category.ELECTRONICS, "ноутбук");
        manager.addProduct(Category.CLOTHING, "туфли");
        manager.addProduct(Category.CLOTHING, "сапоги");
        manager.addProduct(Category.CLOTHING, "рубашка");
        manager.addProduct(Category.CLOTHING, "пиджак");
        manager.addProduct(Category.OTHER, "лампа");
        manager.addProduct(Category.OTHER, "кружка");
        manager.addProduct(Category.OTHER, "лампа");
        manager.printAllProducts();

        manager.removeProduct(Category.OTHER, "ноутбук");
        manager.removeProduct(Category.ELECTRONICS, "планшет");
        System.out.println("\nAfter delete:");
        manager.printAllProducts();

        List<Product> productsList = manager.findProductsByCategory(Category.CLOTHING);
        System.out.printf("\nProduct list for category %s:\n", Category.CLOTHING);
        for (Product product : productsList) {
            System.out.println(product.toString());
        }

    }
}