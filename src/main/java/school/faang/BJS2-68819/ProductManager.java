package school.faang.BJS2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<school.faang.BJS2.Product> products = new HashSet<>();

    public void addProduct(school.faang.BJS2.Category category, String name){
        school.faang.BJS2.Product newProduct = new school.faang.BJS2.Product(name, category);
        products.add(newProduct);
        System.out.printf("Added:%s%n", newProduct);
    }

    public boolean removeProduct(school.faang.BJS2.Category category, String name) {
        Iterator<school.faang.BJS2.Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            school.faang.BJS2.Product product = iterator.next();
            if (product.getCategory() == category && product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.printf("Removed: %s%n", product);
                return true;
            }
        }
        System.out.printf("Product with name '%s' in category '%s' not found.%n", name, category);
        return false;
    }

    public List<school.faang.BJS2.Product> findProductsByCategory(school.faang.BJS2.Category category){
        List<school.faang.BJS2.Product> result = new ArrayList<>();
        for(school.faang.BJS2.Product product : products){
            if(product.getCategory() == category){
                result.add(product);
            }
        }
        return result;
    }

    public Map<school.faang.BJS2.Category, List<school.faang.BJS2.Product>> groupProductsByCategory(){
        Map<school.faang.BJS2.Category, List<school.faang.BJS2.Product>> grouped = new HashMap<>();
        for(school.faang.BJS2.Product product : products) {
            grouped.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return grouped;

    }

    public void printAllProducts() {
        Map<school.faang.BJS2.Category, List<school.faang.BJS2.Product>> grouped = groupProductsByCategory();
        for (Map.Entry<school.faang.BJS2.Category, List<school.faang.BJS2.Product>> entry : grouped.entrySet()) {
            System.out.printf("%nКатегория: %s%nПродукты:%n", entry.getKey());
            for (school.faang.BJS2.Product product : entry.getValue()) {
                System.out.printf("- %s%n", product.getName());
            }
        }
    }
}