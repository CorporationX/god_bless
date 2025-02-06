package school.faang;

import school.faang.bjs2_56895.Category;
import school.faang.bjs2_56895.ProductManager;

public class StoreMain {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        // Добавление продуктов
        productManager.addProduct(Category.FOOD, "Apple");
        productManager.addProduct(Category.FOOD, "Bread");
        productManager.addProduct(Category.ELECTRONICS, "Laptop");
        productManager.addProduct(Category.ELECTRONICS, "Smartphone");

        // Вывод всех продуктов
        productManager.printAllProducts();
        separator();
        // Поиск продуктов по категории
        System.out.println(productManager.findProductByCategory(Category.FOOD));
        separator();
        // Удаление продукта
        productManager.removeProduct(Category.FOOD, "Apple");
        productManager.printAllProducts();
        separator();
        // Перегруппировка продуктов
        productManager.groupProductsByCategory();
        productManager.printAllProducts();
    }

    static void separator() {
        System.out.println("============================");
    }
}
