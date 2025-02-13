package school.faang.task_57215;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(Category.FOOD, "Apple");
        manager.addProduct(Category.FOOD, "Bread");
        manager.addProduct(Category.ELECTRONICS, "Laptop");
        manager.addProduct(Category.ELECTRONICS, "Smartphone");
        manager.addProduct(Category.CLOTHING, "T-Shirt");
        manager.addProduct(Category.OTHER, "Chair");

        manager.printAllProducts();

        List<Product> foodProducts = manager.findProductsByCategory(Category.FOOD);
        System.out.println("\nТовары в категории FOOD:");
        foodProducts.forEach(product -> System.out.println("  - " + product.getName()));

        manager.removeProduct(Category.FOOD, "Apple");

        System.out.println("\nПосле удаления товара:");
        manager.printAllProducts();
    }
}
