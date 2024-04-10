package Amazon_storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String category;

    public static Map<String, List<Product>> groupProducts(Set<Product> products) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products) {
            if (!result.containsKey(product.getCategory())) {
                result.put(product.getCategory(), new ArrayList<>());
            }
            result.get(product.getCategory()).add(product);
        }
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}


