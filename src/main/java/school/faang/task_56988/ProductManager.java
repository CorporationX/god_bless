package school.faang.task_56988;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ProductManager {
    protected static Set<Product> products = new HashSet<>();
    protected static Map<Category, List<Product>> categoryMap = new HashMap<>();

    public static void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        try {
            if (isProductExist(category, name)) {
                throw new IllegalArgumentException("This product already exists");
            }
        } catch (IllegalArgumentException e) {
            log.info("Error: " + e.getMessage());
        }
        products.add(product);
        List<Product> categoryProducts = categoryMap.get(category);
        if (categoryProducts == null) {
            categoryProducts = new ArrayList<>();
            categoryMap.put(category, categoryProducts);
        }
        List<Product> productsListByCategory = categoryMap.get(category);
        if (productsListByCategory == null) {
            productsListByCategory = new ArrayList<>();
        }
        productsListByCategory.add(product);
    }

    public static void removeProduct(Category category, String name) {
        Product product = new Product(name, category);
        try {
            if (!isProductExist(category, name)) {
                throw new IllegalArgumentException("This product hasn't been found");
            } else {
                products.remove(product);
                List<Product> listProductsByCategory = categoryMap.get(category);
                listProductsByCategory.remove(product);
            }
        } catch (IllegalArgumentException e) {
            log.info("Error: " + e.getMessage());
        }
    }

    public static List<Product> findProductsByCategory(Category category) {
        List<Product> listProductsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                listProductsByCategory.add(product);
            }
        }
        return listProductsByCategory;
    }

    public static void groupProductsByCategory() {
        for (Product product : products) {
            if (!categoryMap.containsKey(product.getCategory())) {
                categoryMap.put(product.getCategory(), new ArrayList<>());
            }
            List<Product> listProductsByCategory = categoryMap.get(product.getCategory());
            listProductsByCategory.add(product);
            categoryMap.put(product.getCategory(), listProductsByCategory);
        }
    }

    public static void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            List<Product> products = entry.getValue();
            System.out.print("Category: " + category + "\nProducts: \n");
            for (Product product : products) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }

    public static boolean isProductExist(Category category, String name) {
        boolean isExist = false;
        Product product = new Product(name, category);
        if (categoryMap.containsKey(category)) {
            List<Product> listProductsByCategory = categoryMap.get(category);
            if (listProductsByCategory.contains(product)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
