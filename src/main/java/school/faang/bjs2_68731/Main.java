package school.faang.bjs2_68731;

/**
 * Задача "Разбираем склад Amazon"
 */
public class Main {
    public static void main(String[] args) {
        var productManager = new ProductManager();

        productManager.addProduct(Category.FOOD, "Курица");
        productManager.addProduct(Category.FOOD, "Курица");
        productManager.addProduct(Category.ELECTRONICS, "Телефон");
        productManager.addProduct(Category.FOOD, "Огурцы");
        productManager.addProduct(Category.OTHER, "Ватные палочки");
        productManager.addProduct(Category.ELECTRONICS, "Ноутбук");
        productManager.addProduct(Category.CLOTHING, "Куртка");

        System.out.println("Остаток продуктов на складе:");
        productManager.printAllProducts();

        System.out.println("\nПродали последнюю куртку");
        productManager.removeProduct(Category.CLOTHING, "Куртка");

        System.out.println("\nОстаток продуктов на складе:");
        productManager.printAllProducts();
    }
}
