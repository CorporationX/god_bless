package school.faang.dismantling_an_amazon_warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private Map<Category, List<Product>> categoryMap = new HashMap<>();

    public Product addProduct(Category category, String name) {
        Product product = new Product(name, category);
        if (products.contains(product)) {
            throw new IllegalArgumentException("Продукт %s уже существует".formatted(product));
        }
        products.add(product);
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(product);

        return product;
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        boolean isProduct = false;
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name) && product.getCategory() == category) {
                iterator.remove();
                System.out.printf("Продукт %s успешно удален\n", product);
                isProduct = true;

                List<Product> productList = categoryMap.get(category);
                productList.removeIf(element -> element.getName().equals(name));

                if (productList.isEmpty()) {
                    categoryMap.remove(category);
                }
                break;
            }
        }

        if (!isProduct) {
            throw new IllegalArgumentException("Такого продукта %s и категории %s нет".formatted(name, category));
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        if (categoryMap.containsKey(category)) {
            return categoryMap.get(category);
        }
        return new ArrayList<>();
    }

    public void groupProductsByCategory() {
        categoryMap.clear();
        for (Product product : products) {
            categoryMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            categoryMap.get(product.getCategory()).add(product);
        }
    }

    public void printAllProducts() {
        if (categoryMap.isEmpty()) {
            throw new IllegalArgumentException("Продуктов нет");
        }

        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.printf("Категория: %s\n", entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.printf("- %s\n", product.getName());
            }
        }
    }
}
