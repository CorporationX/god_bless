package school.faang.sprint1.task_45121;

import java.util.*;

public class Main {

    private static final Set<Product> products = new HashSet<>(
            Arrays.asList(
                    new Product(1, "comp", "compCategory"),
                    new Product(2, "monitor", "compCategory"),
                    new Product(3, "keyboard", "compCategory"),
                    new Product(4, "lamp", "house staff"),
                    new Product(5, "TV", "entertainment"),
                    new Product(6, "cup", "kitchen")
            )
    );
    private static final ProductRepository productRepository = new ProductRepository();

    private static Map<String, List<Product>> groupProductsByCategory() {
        for (Product product : Main.products) {
            productRepository.addItem(product.getCategory(), product.getName());
        }
        return productRepository.getProductsByCategories();
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        productRepository.printAllItems();
    }

    public static void main(String[] args) {
        Map<String, List<Product>> map = groupProductsByCategory();
        System.out.println(map);
        printProductsByCategory(map);
    }
}
