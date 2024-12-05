package school.faang.sprint1.task_45121;

import java.util.*;

public class Main {

    private HashSet<Product> products = new HashSet<>(
            Arrays.asList(
                    new Product(1, "comp", "compCategory"),
                    new Product(2, "monitor", "compCategory"),
                    new Product(3, "keyboard", "compCategory"),
                    new Product(4, "lamp", "house staff"),
                    new Product(5, "TV", "entertainment"),
                    new Product(6, "cup", "kitchen")
            )
    );
    private ProductRepository productRepository = new ProductRepository();

    private HashMap<String, ArrayList<Product>> groupProductsByCategory(HashSet<Product> products) {
        for (Product product : products) {
            productRepository.addItem(product.getCategory(), product.getName());
        }
        return productRepository.getCategoryProductMap();
    }

    private void printProductsByCategory(Map<String, ArrayList<Product>> groupedProducts) {
        productRepository.printAllItems(groupedProducts);
    }

    public static void main(String[] args) {
        Main main = new Main();
        HashMap<String, ArrayList<Product>> map = main.groupProductsByCategory(main.products);
        System.out.println(map);
        main.printProductsByCategory(map);
    }
}
