package school.faang.sprint.first.amazon.manager;

import school.faang.sprint.first.amazon.model.Category;
import school.faang.sprint.first.amazon.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private final Set<Product> allProducts = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        Product productForAdd = new Product(name, category);
        allProducts.add(productForAdd);
        categoryMap.computeIfAbsent(category, p -> new ArrayList<>()).add(productForAdd);
    }

    public void removeProduct(Category category, String name) {
        Product productForRemove = new Product(name, category);
        allProducts.remove(productForRemove);
        categoryMap.get(category)
                .removeIf(product -> product.equals(productForRemove));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = categoryMap.getOrDefault(category, new ArrayList<>());
        productList.retainAll(allProducts);

        return productList;
    }

    public void groupProductsByCategory() {
        Map<Category, List<Product>> tempMap = new HashMap<>();
        for (var product : allProducts) {
            tempMap.computeIfAbsent(product.getCategory(), p -> new ArrayList<>()).add(product);
        }

        categoryMap = tempMap;
    }

    public void printAllProducts() {
        StringBuilder stringBuilder = new StringBuilder();

        if (categoryMap.isEmpty()) {
            System.out.println("Пока туть пусто");
            return;
        }

        for (var entry : categoryMap.entrySet()) {
            stringBuilder
                    .append("Категория: ")
                    .append(entry.getKey())
                    .append("\r\n")
                    .append("Продукты: ")
                    .append("\r\n");

            for (var product : entry.getValue()) {
                stringBuilder
                        .append("- ")
                        .append(product.getName())
                        .append("\r\n");
            }

            stringBuilder.append("\r\n");
        }

        System.out.println(stringBuilder);
    }
}
