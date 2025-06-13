package school.faang.bjs2_79912;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

@Getter
@NoArgsConstructor
public class ProductManager {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(String name, Category category) {
        int id = (name + category).hashCode();
        getProducts().add(new Product(id, name, category));
    }

    public void removeProduct(String name, Category category) {
        int id = (name + category).hashCode();
        getProducts().remove(new Product(id, name, category));
    }

    public List<Product> findProductByCategory(Category category) {
        List<Product> productsOfOneCategory = groupByCategory().get(category);
        if (productsOfOneCategory == null) {
            throw new NullPointerException("Category isn't found");
        }
        return productsOfOneCategory;
    }

    public Map<Category, List<Product>> groupByCategory() {
        Map<Category, List<Product>> productsGroupedByCategory = new HashMap<>();
        List<Product> productsOfOneCategory;
        for (Product product : getProducts()) {
            if (productsGroupedByCategory.get(product.getCategory()) == null) {
                productsOfOneCategory = new ArrayList<>();
                productsOfOneCategory.add(product);
                productsGroupedByCategory.put(product.getCategory(), productsOfOneCategory);
                continue;
            }
            productsOfOneCategory = productsGroupedByCategory.get(product.getCategory());
            productsOfOneCategory.add(product);
        }
        return productsGroupedByCategory;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsGroupedByCategory = groupByCategory();
        productsGroupedByCategory.forEach((key, value) ->
                System.out.printf("Категория: %s%nПродукты:%n%s%n", key, printProductsOfOneCategory(value)));
    }

    public String printProductsOfOneCategory(List<Product> products) {
        StringJoiner productsOfOneCategory = new StringJoiner("");
        for (Product product : products) {
            productsOfOneCategory.add(String.format("-%s%n", product.getName()));
        }
        return productsOfOneCategory.toString();
    }
}
