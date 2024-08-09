package faang.school.godbless.amazonwarehouse;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class ProductService {
    public void showProductsByCategory(Set<Product> productSet) {
        var products = groupProducts(productSet);

        products.forEach((key, value) -> {
            System.out.println(key);
            value.stream()
                    .map(Product::getName)
                    .forEach(name -> System.out.println(" " + name));
        });
    }

    private Map<String, List<Product>> groupProducts(Set<Product> productSet) {
        return productSet.stream().collect(groupingBy(Product::getCategory));
    }
}
