package school.faang.task_56988;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@EqualsAndHashCode
@RequiredArgsConstructor
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private final HashMap<Category, List<Product>> categoryListHashMap;
    private final Map<Category, List<Product>> categoryMap = new HashMap<>();
    private int counter = 1;

    public ProductManager(HashSet<Product> products, HashMap<Category, List<Product>> categoryListHashMap) {
        this.products = products;
        this.categoryListHashMap = categoryListHashMap;
    }

    public int getNextId() {
        return counter++;
    }

    public void addProduct(Category category, String name) {
        if (isProductExist(category, name)) {
            log.info("Product with category {} and name {} already exists", category, name);
            return;
        }
        int id = getNextId();
        Product product = new Product(id, name, category);
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

    public void removeProduct(Category category, String name) {
        Product product = new Product(counter++, name, category);
        products.remove(product);
        List<Product> listProductsByCategory = categoryMap.get(category);
        if (listProductsByCategory != null) {
            listProductsByCategory.remove(product);
            if (listProductsByCategory.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> listProductsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                listProductsByCategory.add(product);
            }
        }
        return listProductsByCategory;
    }

    public void groupProductsByCategory() {
        for (Product product : products) {
            if (!categoryMap.containsKey(product.getCategory())) {
                categoryMap.put(product.getCategory(), new ArrayList<>());
            }
            List<Product> listProductsByCategory = categoryMap.get(product.getCategory());
            if (!listProductsByCategory.contains(product)) {
                listProductsByCategory.add(product);
            }
        }
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : categoryMap.entrySet()) {
            System.out.printf("Category: %s\nProducts: \n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println();
        }
    }

    public boolean isProductExist(Category category, String name) {
        boolean isExist = false;
        Product product = new Product(counter++, name, category);
        if (categoryMap.containsKey(category)) {
            List<Product> listProductsByCategory = categoryMap.get(category);
            if (listProductsByCategory.contains(product)) {
                isExist = true;
            }
        }
        return isExist;
    }
}
