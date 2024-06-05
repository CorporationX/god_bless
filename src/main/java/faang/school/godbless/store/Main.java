package faang.school.godbless.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Product> products = new HashSet<>();

        products.add(new Product(0, "Potato", "vegetable"));
        products.add(new Product(1, "Milk", "dairy"));
        products.add(new Product(2, "Bun", "Bread Product"));
        products.add(new Product(3, "Cake", "Sweets"));
        products.add(new Product(4, "Tomato", "vegetable"));
        products.add(new Product(5, "Onion", "vegetable"));
        products.add(new Product(6, "Bread", "Bread Product"));
        products.add(new Product(7, "Pancake", "Sweets"));

        Map<String, List<Product>> packProducts = new HashMap<>();

        packProducts = Product.packaging(products);

        packProducts.forEach((key, value) -> System.out.println("category: " + key + " : " + value.toString()));

    }
}
