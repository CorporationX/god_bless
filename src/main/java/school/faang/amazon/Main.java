package school.faang.amazon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(Category.ELECTRONICS, "iPhone");
        productManager.addProduct(Category.ELECTRONICS, "Ноутбук 'Osio'");
        productManager.addProduct(Category.FOOD, "Яблоко");
        productManager.addProduct(Category.FOOD, "Банан");
        productManager.addProduct(Category.FOOD, "Сыр");
        productManager.addProduct(Category.CLOTHING, "Шорты");
        productManager.addProduct(Category.CLOTHING, "Футболка");
        productManager.addProduct(Category.OTHER, "Часы");

        productManager.printAllProducts();

        System.out.print("\nТовары категории ELECTRONICS:");
        List<Product> electroProducts = productManager.findProductsByCategory(Category.ELECTRONICS);
        for (Product product : electroProducts) {
            System.out.printf("- %s%n", product.getName());
        }

        productManager.removeProduct(Category.FOOD, "Банан");

        System.out.print("\nОбновленный список продуктов после удаления:");
        productManager.printAllProducts();
    }
}