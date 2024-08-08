package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public static Map<String, List<Product>> groupProduct(Set<Product> setProduct) {
        Map<String, List<Product>>  productMap = new HashMap<>();
        for (Product pr : setProduct){
            if (!productMap.containsKey(pr.category)) {
                List<Product> mapList = new ArrayList<>();
                mapList.add(pr);
                productMap.put(pr.category, mapList);
            }
            else {
                productMap.get(pr.category).add(pr);
            }

        }
        return productMap;
    }

    public static void outputMap(Map<String, List<Product>> productMap) {
        for (Map.Entry<String, List<Product>> pair : productMap.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
