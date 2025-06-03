package school.faang.bjs2_79790;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public boolean addProduct(ProductCategory productCategory, String name) {
        return products.add(new Product(name, productCategory));
    }

    public boolean removeProduct(ProductCategory productCategory, String name) {
        return products.remove(new Product(name, productCategory));
    }

    public List<Product> findProductsByCategory(ProductCategory productCategory) {
        List<Product> productsByCategory = new ArrayList<>();

        for (Product product : products) {
            if (product.getProductCategory().equals(productCategory)) {
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public Map<ProductCategory, List<Product>> groupProductsByCategory() {
        Map<ProductCategory, List<Product>> productsByCategory = new HashMap<>();

        for (Product product : products) {
            productsByCategory.computeIfAbsent(product.getProductCategory(),
                                               (productCategory) -> new ArrayList<>()).add(product);
        }

        return productsByCategory;
    }

    public void printAllProducts() {
        String printTemplate = """
                Категория: %s
                Продукты:""";
        Map<ProductCategory, List<Product>> productsByCategory = groupProductsByCategory();

        for (var entrySet : productsByCategory.entrySet()) {
            System.out.println(printTemplate.formatted(entrySet.getKey()));
            for (Product product : entrySet.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
