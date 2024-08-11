package faang.school.godbless.BJS2_19472;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(1, "Samsung", "Phones"),
                new Product(2, "Apple", "Phones"),
                new Product(3, "LG", "TV"),
                new Product(4, "Philips", "TV")
        );

        Map<String, List<Product>> map = Product.groupByCategory(products);

        Product.printProducts(map);
    }
}
