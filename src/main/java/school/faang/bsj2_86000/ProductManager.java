package school.faang.bsj2_86000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        int uniqueIdentificator = Objects.hash(name, category);
        Product product = new Product(uniqueIdentificator, name, category);
        products.add(product);
    }

    public boolean isRemoveProduct(Category category, String name) {
        int uniqueIdentificator = Objects.hash(name, category);
        Product product = new Product(uniqueIdentificator, name, category);
        return products.remove(product);
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> resultProductList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                resultProductList.add(product);
            }
        }
        return resultProductList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productGroups = new HashMap<>();
        for (Product product : products) {
            List<Product> productForMap = new ArrayList<>();
            if (productGroups.get(product.getCategory()) != null) {
                productForMap = productGroups.get(product.getCategory());
            }
            productForMap.add(product);
            productGroups.put(product.getCategory(), productForMap);
        }
        return productGroups;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouppedProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> pair : grouppedProducts.entrySet()) {
            System.out.println("Категория: " + pair.getKey());
            System.out.println("Продукты: ");
            for (Product product : pair.getValue()) {
                System.out.println("- " + product.getName());
            }
            System.out.println("");
        }
    }

}
