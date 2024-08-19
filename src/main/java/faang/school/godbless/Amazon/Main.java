package faang.school.godbless.Amazon;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private final Map<String, Set<Product>> uniqueProduct = new HashMap<>();

    public static void main(String[] args) {
        Product pr1 = new Product(1, "Milk", "Food");
        Product pr2 = new Product(12, "Milk", "Food");
        Product pr3 = new Product(3, "Jordans", "boots");
        Product pr4 = new Product(5, "J-Z", "boots");
        Product pr5 = new Product(4, "Wow", "wow");
        Set<Product> cat1 = new HashSet<>();
        cat1.add(pr1);
        cat1.add(pr5);
        cat1.add(pr2);
        cat1.add(pr3);
        cat1.add(pr4);

        System.out.println(sortingProductsByCategoriesAndGettingTemporaryMap("Food", cat1));
        System.out.println(sortingProductsByCategoriesAndGettingTemporaryMap("boots", cat1));

        Main main = new Main();
        main.allCategoryWithProducts();

    }

    public static Map<String, List<Product>> sortingProductsByCategoriesAndGettingTemporaryMap(@NonNull String category, Set<Product> products) {
        Map<String, List<Product>> productsSorted = new HashMap<>();
        for (Product pr : products) {
            productsSorted.computeIfAbsent(category, key -> new ArrayList<>()).add(pr);
        }
        return productsSorted;
    }

    public void allCategoryWithProducts() {
        for (Map.Entry<String, Set<Product>> entry : uniqueProduct.entrySet()) {
            System.out.println(entry.getKey() + '\n');
            for (Product pr : entry.getValue()) {
                System.out.println(pr + "\n");
            }
        }
    }
}
