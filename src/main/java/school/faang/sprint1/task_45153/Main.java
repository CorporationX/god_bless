package school.faang.sprint1.task_45153;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static Set<Product> products = Set.of(
            new Product("Product 1", "Category 1"),
            new Product("Product 2", "Category 1"),
            new Product("Product 3", "Category 1"),
            new Product("Product 4", "Category 2"),
            new Product("Product 5", "Category 2"),
            new Product("Product 6", "Category 3"),
            new Product("Product 7", "Category 3")
    );


    public static void main(String[] args) {
        Map<String, List<Product>> testMap = ProductService.groupProductsByCategory(products);

        ProductService.printAllItems(testMap);

        System.out.println(ProductService.addItem("Category 1", "Product 1")); // true
        System.out.println(ProductService.addItem("Category 2", "Product 2")); // true
        System.out.println(ProductService.addItem("Category 1", "Product 3")); // true

        System.out.println(ProductService.removeItem("non exist category", "Product 3")); // false
        System.out.println(ProductService.removeItem("Category 4", "non exist product")); // false
        System.out.println(ProductService.removeItem("Category 1", "Product 1")); // true


        System.out.println(ProductService.findItemsByCategory("non exist category"));
        System.out.println(ProductService.findItemsByCategory("Category 1"));

        ProductService.printAllItems();
    }
}