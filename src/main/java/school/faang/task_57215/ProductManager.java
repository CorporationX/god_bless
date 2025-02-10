package school.faang.task_57215;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categotyMap = new HashMap<>();
    private static int counterId = 0;

    public void addProduct(Category category, @NonNull String name) {
        Product newProduct = new Product(counterId++, name, category);

        products.add(newProduct);

    }
}
