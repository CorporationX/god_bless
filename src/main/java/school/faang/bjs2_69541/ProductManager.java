package school.faang.bjs2_69541;

import java.util.*;

public class ProductManager {
    public static final String PRODUCT_EXISTS = "The product [%s] with the category [%s] already exists\n";
    public static final String PRODUCT_DONT_EXISTS = "The product [%s] with the category [%s] don't exist\n";
    private final Set<Product> products = new HashSet<>();
    private Integer lastId = 0;

    public Product addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.printf(PRODUCT_EXISTS, name, category.getName());
                return product;
            }
        }
        Product product = new Product(getNextId(), name, category);
        products.add(product);
        return product;
    }

    public Product removeProduct(Category category, String name) {
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productIterator.remove();
                return product;
            }
        }
        System.out.printf(PRODUCT_DONT_EXISTS, name, category.getName());
        return null;
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        products.forEach(product -> {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        });
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> result = new HashMap<>();
        products.forEach(product -> {
            result.computeIfAbsent(product.getCategory(), category -> new ArrayList<Product>()).add(product);
        });
        return result;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupByCategory = groupProductsByCategory();
        for (var entity : groupByCategory.entrySet()) {
            System.out.printf("Категория: %s\n", entity.getKey().getName())
                .print("Продукты:\n");
            entity.getValue().forEach(product -> {
                System.out.printf("\t- %s\n", product.getName());
            });
        }
    }

    private Integer getNextId() {
        return lastId++;
    }
}
