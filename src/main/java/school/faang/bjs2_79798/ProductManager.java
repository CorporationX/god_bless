package school.faang.bjs2_79798;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductManager {
    private Set<Product> products;

    private static Long countId = 0L;

    public void addProduct(Category category, String name) {
        Long id = generateId();
        products.add(new Product(id, name, category));
    }

//    public boolean removeProduct(Category category, String name) {
//        return products.remove()
//    }

    public List<Product> findProductByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    private static Long generateId() {
        return countId++;
    }
}
