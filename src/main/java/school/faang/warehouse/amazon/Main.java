package school.faang.warehouse.amazon;

public class Main {
    public static void main(String[] args) {
        ProductManager amazon = new ProductManager();
        System.out.println("\nПроверяем добавление:");
        amazon.addProduct(Category.FOOD, "Apple");
        amazon.addProduct(Category.FOOD, "Bread");
        amazon.addProduct(Category.ELECTRONICS, "Laptop");
        amazon.addProduct(Category.ELECTRONICS, "Smartphone");
        amazon.addProduct(Category.CLOTHING, "T-shirt");
        amazon.addProduct(Category.OTHER, "Guitar");
        amazon.addProduct(Category.OTHER, "Guitar");
        System.out.println("\nПечать всех продуктов:");
        amazon.printAllProducts();
        System.out.println("\nПроверяем поиск по категории:");
        amazon.findProductsByCategory(Category.FOOD);
        amazon.findProductsByCategory(Category.CLOTHING);
        System.out.println("\nПроверяем удаление:");
        amazon.removeProduct(Category.FOOD, "Apple");
        amazon.removeProduct(Category.FOOD, "Orange");
        System.out.println("\nПечать всех продуктов:");
        amazon.printAllProducts();
        System.out.println("\nПроверяем группировку товаров по категориям:");
        amazon.groupProductsByCategory();
        System.out.println("\nПечать всех продуктов:");
        amazon.printAllProducts();
    }
}
