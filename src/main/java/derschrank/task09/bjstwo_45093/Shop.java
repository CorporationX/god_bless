package derschrank.task09.bjstwo_45093;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private Set<Product> products;

    public Shop(Set<Product> p) {
        products = p;
    }

    public Shop() {
        this(new HashSet<>());
    }


    public void addItem(Product product) {
        products.add(product);
    }

    public void addItem(String categoryName, Product product) {
        addItem(new Category(categoryName), product);
    }

    public void addItem(Category category, Product product) {
        addItem(product);
        product.setCategory(category);
    }

    public void removeItem(String categoryName, String productName) {
        Set<Product> productSet = getSetOfProductsByName(productName);
        if (productSet.isEmpty()) {
            System.out.printf("Product/s with name %s not found%n", productName);
        } else {
            Category category = new Category(categoryName);
            for (Product product : productSet) {
                removeItem(category, product);
            }
        }
    }

    public void removeItem(Category category, Product product) {
        if (product.getCategory().equals(category)) {
            product.setDefaultCategory();
        } else {
            System.out.printf("Category %s isn't found in Product %s%n", category, product);
        }
    }

    public Set<Product> getSetOfProductsByName(String name) {
        Set<Product> productSet = new HashSet<>();
        products.stream()
                .filter(x -> x.getName().equals(name))
                .forEach(productSet::add);

        return productSet;
    }


    public Map<Category, Set<Product>> groupProductsByCategory() {
        return groupProductsByCategory(products);
    }

    public Map<Category, Set<Product>> groupProductsByCategory(Set<Product> products) {
        Map<Category, Set<Product>> categoryProductMap = new HashMap<>();
        for (Product product : products) {
            categoryProductMap
                    .computeIfAbsent(product.getCategory(), k -> new HashSet<>())
                    .add(product);
        }

        return categoryProductMap;
    }

    public Set<Product> findItemsByCategory(String categoryName) {
        return findItemsByCategory(new Category(categoryName));
    }

    public Set<Product> findItemsByCategory(Category category) {
        return groupProductsByCategory().get(category);
    }

    public void printItemsByCategory(String categoryName) {
        printItemsByCategory(new Category(categoryName));
    }

    public void printItemsByCategory(Category category) {
        StringBuilder result = new StringBuilder("All products in category: ");
        result.append(category);
        result.append("\n");

        for (Product product : findItemsByCategory(category)) {
            result.append(product);
            result.append("\n");
        }

        System.out.println(result);
    }

    public void printAllItems() {
        System.out.println("All products in all categories.");
        for (Category category : groupProductsByCategory().keySet()) {
            printItemsByCategory(category);
        }
    }

}
