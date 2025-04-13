package school.faang.amazon;

import lombok.Data;

import java.util.ArrayList;
import java.util.EventListenerProxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class ProductManager {

    private Set<Product> productSet = new HashSet<>();

    public boolean addProduct(Category category, String name) {
        Product product = new Product(name, category);
        return productSet.add(product);
    }

    public void removeProduct(Category category, String name) {
        productSet = findProductByCategory(category);
        productSet.remove(name);
        System.out.println(productSet);
    }

    public Set<Product> findProductByCategory(Category category) {
        Set<Product> productFindCategory = new HashSet<>();
        for (Product products : productSet) {
            if (products.getCategory().equals(category)) {
                productFindCategory.add(products);
            }
        }
        return productFindCategory;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> categoryListMap = new HashMap<>();
        for (Product products : productSet) {
            if (!categoryListMap.containsKey(products.getCategory())) {
                categoryListMap.put(products.getCategory(), new ArrayList<>());
            }
            categoryListMap.get(products.getCategory()).add(products);
        }
        return categoryListMap;
    }

    public void printAllProduct() {
        Map<Category, List<Product>> categoryListMap = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : categoryListMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Product products : entry.getValue()) {
                System.out.println(products.getName());
            }
        }
    }
}
