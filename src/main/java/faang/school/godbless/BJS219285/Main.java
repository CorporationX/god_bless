package faang.school.godbless.BJS219285;

import java.util.*;

public class Main {
    private Set<Product> productCache = new HashSet<>();

    public Map<String, List<Product>> setProducts(Set<Product> products){
        Map<String, List<Product>> result = new HashMap<>();
        for (Product product : products){
            result.computeIfAbsent(product.getCategory().toLowerCase(), w -> new ArrayList<>()).add(product);
        }
        return result;
    }

    public void getProducts(){
        productCache
    }
}
