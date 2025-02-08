package school.faang.task_56988;

import java.util.List;
import java.util.Set;

import static school.faang.task_56988.ProductManager.addProduct;
import static school.faang.task_56988.ProductManager.findProductsByCategory;
import static school.faang.task_56988.ProductManager.groupProductsByCategory;
import static school.faang.task_56988.ProductManager.printAllProducts;
import static school.faang.task_56988.ProductManager.products;
import static school.faang.task_56988.ProductManager.removeProduct;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adding of products");

        addProduct(Category.FOOD, "Apple");
        addProduct(Category.FOOD, "Bread");
        addProduct(Category.ELECTRONICS, "Laptop");
        addProduct(Category.ELECTRONICS, "Smartphone");

        printAllProducts();
        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Removal of products");

        removeProduct(Category.ELECTRONICS, "Smartphone");
        removeProduct(Category.ELECTRONICS, "Laptop");

        printAllProducts();
        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Adding multiple products");

        Set<Product> productsToAdd = Set.of(
                new Product("Banana", Category.FOOD),
                new Product("Smartphone", Category.ELECTRONICS),
                new Product("Laptop", Category.ELECTRONICS),
                new Product("T-Shirt", Category.CLOTHING),
                new Product("Jeans", Category.CLOTHING),
                new Product("Book", Category.OTHER),
                new Product("Notebook", Category.OTHER),
                new Product("Headphones", Category.ELECTRONICS)
        );
        products.addAll(productsToAdd);
        printAllProducts();

        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Find products by category");

        List<Product> foodProducts = findProductsByCategory(Category.FOOD);
        System.out.println(foodProducts);

        System.out.println("""
                ---------------------------------------------------------------------------
                """);
        System.out.println("Group products by category");

        groupProductsByCategory();
        printAllProducts();
    }
}
