package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class ProductManager {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name){
        Product newProduct = new Product(name, category);
        products.add(newProduct);
        System.out.printf("Added:%s%n", newProduct);
    }

    public boolean removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory() == category && product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.printf("Removed: %s%n", product);
                return true;
            }
        }
        System.out.printf("Product with name '%s' in category '%s' not found.%n", name, category);
        return false;
    }

    public List<Product> findProductsByCategory(Category category){
        List<Product> result = new ArrayList<>();
        for(Product product : products){
            if(product.getCategory() == category){
                result.add(product);
            }
        }
        return result;
    }

    public Map<Category, List<Product>> groupProductsByCategory(){
        Map<Category, List<Product>> grouped = new HashMap<>();
        for(Product product : products) {
            grouped.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return grouped;

    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : grouped.entrySet()) {
            System.out.printf("%nКатегория: %s%nПродукты:%n", entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.printf("- %s%n", product.getName());
            }
        }
    }
}