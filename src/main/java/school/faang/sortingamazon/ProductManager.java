package school.faang.sortingamazon;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
public class ProductManager {
    private static int idCounter = 1;
    private final Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        int id = idCounter++;
        Product product = new Product(id, name, category);
        if (products.contains(product)) {
            System.out.println("Продукт уже существует.");
            return;
        }

        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);
        System.out.println("Продукт успешно добавлен: " + product.toString());
    }

    public void removeProduct(Category category, String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove == null) {
            System.out.println("Продукт не существует.");
            return;
        }

        categoryMap.get(category).remove(productToRemove);
        products.remove(productToRemove);
        System.out.println("Продукт успешно удален: " + productToRemove.toString());
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> products = categoryMap.get(category);
        if (products != null) {
            return products;
        } else {
            return List.of();
        }
    }

    public void groupProductsByCategory() {
        categoryMap = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Set<Category> categories = categoryMap.keySet();
        for (Category category : categories) {
            System.out.println("Категория: " + category.toString());
            List<Product> products = categoryMap.get(category);
            System.out.println("Продукты:");
            for (Product product : products) {
                System.out.println(" - " + product.toString());
            }
            System.out.println();
        }
    }
}