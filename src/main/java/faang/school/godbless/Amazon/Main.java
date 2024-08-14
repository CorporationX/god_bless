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
        Main main = new Main();
        Product pr1 = new Product(1, "Milk", "Food");
        Product pr2 = new Product(12, "Milk", "Food");
        Product pr3 = new Product(3, "Jordans", "boots");
        Product pr4 = new Product(5, "J-Z", "boots");
        Product pr5 = new Product(4, "Wow", "wow");
        List<Product> cat1 = new ArrayList<>();
        List<Product> cat2 = new ArrayList<>();
        cat1.add(pr1);
        cat1.add(pr5);
        cat1.add(pr2);
        cat2.add(pr3);
        cat2.add(pr4);
        cat2.add(pr5);
        main.sortingProductsByCategories("Food",cat1);
        main.sortingProductsByCategories("boots",cat2);
        System.out.println(main.sortingProductsByCategoriesAndGettingTemporaryMap("Food",cat1));

        main.AllCategoryWithProducts();

    }


    public void sortingProductsByCategories(@NonNull String category, List<Product> products) {
        for (Product pr: products) {
            uniqueProduct.computeIfAbsent(category, key -> new HashSet<>()).add(pr);
        }
    }

    public Map<String, Set<Product>> sortingProductsByCategoriesAndGettingTemporaryMap(@NonNull String category, List<Product> products) {
        Map<String, Set<Product>> Products = new HashMap<>();
        for (Product pr: products) {
            Products.computeIfAbsent(category, key -> new HashSet<>()).add(pr);
        }
        return Products;
    }


    public void AllCategoryWithProducts() {
        for (Map.Entry<String, Set<Product>> entry : uniqueProduct.entrySet()) {
            System.out.println(entry.getKey() + '\n');
            for (Product pr : entry.getValue()) {
                System.out.println(pr + "\n");
            }
        }
    }

}
