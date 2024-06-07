package faang.school.godbless.amazon;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class ProductManager {
    public Map<String, List<Product>> getProductsGroupedByCategory(Set<Product> products){
        Map<String, List<Product>> result = new HashMap<>();

        for(Product product : products){
            result.computeIfAbsent(product.getCategory(), categoryAsKey -> new ArrayList<>()).add(product);
        }

        return result;
    }

    public void showProductsGroupedByCategory(Map<String, List<Product>> productMap){
        for(Map.Entry<String, List<Product>> categoryEntry : productMap.entrySet()){
            System.out.println("Products of " + categoryEntry.getKey());
            for(Product product : categoryEntry.getValue()){
                System.out.println(product);
            }
        }
    }
}
