package school.faang;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println("\n--- Поиск продуктов по категории FOOD ---");
        manager.findProductsByCategory(Category.FOOD).forEach(p ->
                System.out.printf("%s%n", p)
        );

        System.out.println("\n--- Удаление продукта Bread из категории FOOD ---");
        manager.removeProduct(Category.FOOD, "Bread");

        System.out.println("\n--- Все продукты, сгруппированные по категориям ---");
        manager.printAllProducts();
    }
}
