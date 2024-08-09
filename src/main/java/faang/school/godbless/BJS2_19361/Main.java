package faang.school.godbless.BJS2_19361;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(1, "bread", "food"),
                new Product(2, "milk", "food"),
                new Product(3, "icebox", "home appliances"),
                new Product(4, "meat", "food"),
                new Product(5, "dress", "clothes"),
                new Product(6, "toaster", "home appliances")
        );
        Map<String, List<Product>> map = Product.groupingByCategory(products);
        System.out.println(map);
        System.out.println();

        Product.printAllProductsByCategory(map);
    }
}
