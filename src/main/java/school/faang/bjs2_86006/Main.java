package school.faang.bjs2_86006;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {

        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.FOOD, "Banana");
        manager.addProduct(Category.ELECTRONICS, "Phone");
        manager.addProduct(Category.BOOKS, "Java Programming");

        manager.printAllProducts();

        System.out.println("ПРОДУКТЫ КАТЕГОРИИ FOOD");
        List<Product> foodProducts = manager.findProductsByCategory(Category.FOOD);
        for (Product product : foodProducts) {
            log.info("- {}", product.getName());
        }

        boolean removed = manager.removeProduct(Category.FOOD, "Apple");
        System.out.println("Продукт Apple удален: " + removed);

        System.out.println("\nОБНОВЛЕННЫЙ СПИСОК");
        manager.printAllProducts();

        System.out.println("ГРУППИРОВКА ПРОДУКТОВ");
        Map<Category, List<Product>> grouped = manager.groupProductsByCategory();
        for (Category category : grouped.keySet()) {
            System.out.println(category + ": " + grouped.get(category).size() + " продуктов");
        }
    }
}
