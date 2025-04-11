package school.faang.secondtask;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    Set<Product> products = new HashSet<>();
    private int id = 0;
    private static final int CATEGORY_SIZE = Category.values().length;

    public void addProduct(Category category, String name) throws Exception {
        if (category == null || name == null || name.isBlank()) {
            throw new Exception("wdklwnd");
        }
        id++;
        products.add(new Product(id, name, category));
        log.info("products {} created", id);

    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getName().equals(name) && product.getCategory().equals(category));
    }

    public List<Product> findProductsByCategory(Category category) {
        return products.stream().filter(product -> product.getCategory().equals(category)).toList();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> mapCategoriesWithProducts = new HashMap<>();

        for (int i = 0; i < CATEGORY_SIZE; i++) {
            List<Category> categories = Arrays.stream(Category.values()).toList();

            List<Product> result =  findProductsByCategory(categories.get(i));
            mapCategoriesWithProducts.put(categories.get(i), result);

        }
        return mapCategoriesWithProducts;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();

        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            Category category = entry.getKey();
            List<Product> productList = entry.getValue();

            System.out.println("Категория: " + category);
            System.out.println("Продукты:");

            for (Product product : productList) {
                System.out.println("- " + product.getName());
            }

            System.out.println();
        }
    }



}
