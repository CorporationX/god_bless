package school.faang.bjs2_86099_1_1_3_3_amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Хлеб");
        manager.addProduct(Category.FOOD, "Молоко");
        manager.addProduct(Category.ELECTRONICS, "Ноутбук");
        manager.addProduct(Category.ELECTRONICS, "Телефон");
        manager.addProduct(Category.CLOTHING, "Куртка");
        manager.addProduct(Category.CLOTHING, "Джинсы");
        manager.addProduct(Category.OTHER, "Книга");
        manager.addProduct(Category.OTHER, "Игрушка");

        System.out.println("=== Все продукты ===");
        manager.printAllProducts();

        System.out.println("\n=== Продукты категории ELECTRONICS ===");
        for (Product product : manager.findProductsByCategory(Category.ELECTRONICS)) {
            System.out.println(product.getName());
        }

        System.out.println("\nУдаляем продукт 'Телефон' из категории ELECTRONICS...");
        manager.removeProduct(Category.ELECTRONICS, "Телефон");

        System.out.println("\n=== Все продукты после удаления ===");
        manager.printAllProducts();
    }
}
