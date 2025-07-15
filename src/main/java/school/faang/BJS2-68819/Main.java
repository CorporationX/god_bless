package school.faang.BJS2;

public class Main {
    public static void main(String[] args) {
        school.faang.BJS2.ProductManager manager = new school.faang.BJS2.ProductManager();

        manager.addProduct(school.faang.BJS2.Category.FOOD, "Apple");
        manager.addProduct(school.faang.BJS2.Category.FOOD, "Bread");
        manager.addProduct(school.faang.BJS2.Category.ELECTRONICS, "Laptop");
        manager.addProduct(school.faang.BJS2.Category.ELECTRONICS, "Smartphone");
        manager.addProduct(school.faang.BJS2.Category.CLOTHING, "T-Shirt");

        System.out.println("\n--- Поиск продуктов по категории FOOD ---");
        manager.findProductsByCategory(school.faang.BJS2.Category.FOOD).forEach(p ->
                System.out.printf("%s%n", p)
        );

        System.out.println("\n--- Удаление продукта Bread из категории FOOD ---");
        manager.removeProduct(school.faang.BJS2.Category.FOOD, "Bread");

        System.out.println("\n--- Все продукты, сгруппированные по категориям ---");
        manager.printAllProducts();
    }
}