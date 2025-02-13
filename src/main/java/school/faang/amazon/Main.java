package school.faang.amazon;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        manager.addProduct(Category.FOOD, "Сосиска");
        manager.addProduct(Category.FOOD, "Огурец");
        manager.addProduct(Category.CLOTHING, "Трусы");
        manager.addProduct(Category.CLOTHING, "Носки");

        ProductManager.printAllProducts();

        manager.removeProduct(Category.FOOD, "Огурец");
        manager.removeProduct(Category.CLOTHING, "Трусы");

        ProductManager.printAllProducts();

        Set<Product> products = Set.of(new Product("Лук", Category.FOOD),
                new Product("Штаны", Category.CLOTHING),
                new Product("Смартфон", Category.ELECTRONICS),
                new Product("Ложка", Category.OTHER));

        manager.groupProductsByCategory(products);

        ProductManager.printAllProducts();


    }
}
