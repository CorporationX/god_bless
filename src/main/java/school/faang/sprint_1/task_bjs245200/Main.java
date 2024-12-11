package school.faang.sprint_1.task_bjs245200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Store STORE = new Store();
    private static final Set<Product> PRODUCTS = Set.of(
            new Product("smartphone", ProductCategory.ELECTRONICS),
            new Product("laptop", ProductCategory.ELECTRONICS),
            new Product("pc", ProductCategory.ELECTRONICS),
            new Product("shirt", ProductCategory.CLOTHING)
    );

    public static void main(String[] args) {
        PRODUCTS.forEach(product -> testAddItem(product.getCategory(), product.getName()));
        STORE.printAllItems();
        testFindItemsByCategory(ProductCategory.ELECTRONICS);
        STORE.removeItem(ProductCategory.ELECTRONICS, "smartphone");
        STORE.groupProductsByCategory(PRODUCTS);
        testPrintProductsByCategory(ProductCategory.ELECTRONICS, ProductCategory.CLOTHING);
    }

    private static void testAddItem(ProductCategory category, String name) {
        STORE.addItem(category, name);
    }

    private static void testFindItemsByCategory(ProductCategory category) {
        List<Product> electronics = STORE.findItemsByCategory(category);
        System.out.println(category.toString() + electronics);
    }

    private static void testPrintProductsByCategory(ProductCategory... categories) {
        Map<ProductCategory, List<Product>> groupedProducts = new HashMap<>();
        Arrays.stream(categories)
                .forEach(category -> {
                    List<Product> productsInCategory = STORE.findItemsByCategory(category);
                    groupedProducts.put(category, productsInCategory);
                });
        STORE.printProductsByCategory(groupedProducts);
    }
}
