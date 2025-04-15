package amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        System.out.println(" Найти продукты в категории FOOD:");
        manager.findProductsByCategory(Category.FOOD)
                .forEach(p -> System.out.println(" - " + p.getName()));

        System.out.println("\n Удалим продукт Bread из категории FOOD");
        manager.removeProduct(Category.FOOD, "Bread");

        System.out.println("\n Все продукты:");
        manager.printAllProducts();
    }
}
