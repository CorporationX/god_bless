package derschrank.task09.bjstwo_45093;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shop {
    private Map<Category, Set<Product>> productsByCategoryMap;

    public Shop(Map<Category, Set<Product>> map) {
        productsByCategoryMap = map;
    }

    public Shop() {
        this(new HashMap<>());
    }

    public void addItem(String category, String productName) {
        addItem(new Category(category), new Product(productName));
    }

    public void addItem(String category, Product product) {
        addItem(new Category(category), product);
    }

    public void addItem(Category category, Product product) {
        productsByCategoryMap.computeIfAbsent(category, k -> new HashSet<>());
        productsByCategoryMap.get(category).add(product);
        product.setCategory(category);
    }

    public void removeItem(String productName) {
        removeItem(findProductItemInCategoryMapByNameOfProduct(productName));
    }

    public void removeItem(Product product) {
        Set<Product> productsInOneCategorySet = productsByCategoryMap.get(product.getCategory());
        if (productsInOneCategorySet == null) {
            System.out.println("Category or Product is not found");
            return;
        }

        productsInOneCategorySet.remove(product);
        product.setCategory(null);
    }

    public Set<Product> findItemsByCategory(String categoryName) {
        return findItemsByCategory(new Category(categoryName));
    }

    public Set<Product> findItemsByCategory(Category category) {
        return productsByCategoryMap.get(category);
    }

    public Product findProductItemInCategoryMapByNameOfProduct(String productName) {
        for (Set<Product> productsInOneCategorySet : productsByCategoryMap.values()) {
            for (Product product : productsInOneCategorySet) {
                if (product.getName().equals(productName)) {
                    return product;
                }
            }
        }
        return null;
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
        for (Category category : productsByCategoryMap.keySet()) {
            printItemsByCategory(category);
        }
    }

}
