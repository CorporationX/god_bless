package derschrank.sprint01.task09.bjstwo_45093;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop implements ShopInterface {
    private static int countOfProducts;

    @Getter
    private final Set<Product> products;

    public Shop() {
        this(new HashSet<>());
    }

    public Shop(Set<Product> p) {
        products = p;
        countOfProducts = p.size();
    }


    @Override
    public void addItem(String category, String product) {
        addItem(new Product(getId(), product, category));
    }

    private void addItem(Product product) {
        products.add(product);
    }


    @Override
    public void removeItem(String category, String product) {
        if (!products.removeIf(x -> product.equals(x.name()) && category.equals(x.category()))) {
            System.out.printf("Product/s with name %s and category %s not found%n", product, category);
        }
    }


    @Override
    public Map<String, Set<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, Set<Product>> categoryProductMap = new HashMap<>();
        for (Product product : products) {
            categoryProductMap
                    .computeIfAbsent(product.category(), k -> new HashSet<>())
                    .add(product);
        }
        return categoryProductMap;
    }


    @Override
    public Set<Product> findItemsByCategory(String category) {
        return products.stream().filter(x -> category.equals(x.category())).collect(Collectors.toSet());
    }


    @Override
    public void printProductsByCategory(Map<String, Set<Product>> groupedProducts) {
        StringBuilder result = new StringBuilder("All products by category:\n");
        for (String category : groupedProducts.keySet()) {
            result.append(String.format("In category %s:%n", category));

            for (Product product : groupedProducts.get(category)) {
                result.append(" - " + product + "\n");
            }
        }
        System.out.println(result);
    }

    @Override
    public void printAllItems() {
        StringBuilder result = new StringBuilder("All products:\n");
        for (Product product : products) {
            result.append(" - " + product + "\n");
        }
        System.out.println(result);
    }

    private int getId() {
        return ++countOfProducts;
    }
}