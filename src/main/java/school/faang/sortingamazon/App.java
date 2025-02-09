package school.faang.sortingamazon;

public class App {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Добавляем продукты
        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");

        // Группировка продуктов
        manager.groupProductsByCategory();

        // Вывод всех продуктов
        manager.printAllProducts();

        // Удаляем продукт
        manager.removeProduct(Category.FOOD, "Bread");

        // Вывод всех продуктов после удаления
        manager.groupProductsByCategory();
        System.out.println("После удаления продукта:");
        manager.printAllProducts();
    }
}
