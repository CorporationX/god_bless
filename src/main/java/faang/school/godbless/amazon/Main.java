package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static final HashSet<Product> products = new HashSet<>();
    public static final Map<String, List<Product>> groupedProducts = new HashMap<>();

    public static void main(String[] args) {
        products.add(new Product(1, "iPhone20", "Phone"));
        products.add(new Product(2, "Galaxy25", "Phone"));
        products.add(new Product(3, "SamsungLed", "TV"));
        products.add(new Product(4, "ElectraMa", "Dishwasher"));
        groupProducts(products);
        printGroupedProducts();

    }

    public static void groupProducts(HashSet<Product> products) {
        products.forEach(product -> groupedProducts.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product));
    }

    public static void printGroupedProducts() {
        for (String category : groupedProducts.keySet()) {
            System.out.println(category);
            System.out.println(groupedProducts.get(category));
        }
    }

    //Without lambda
//    public static void groupProducts(HashSet<Product> products){
//        for(Product product:products){
//            String category = product.getCategory();
//            if(!groupedProducts.containsKey(category)){
//                groupedProducts.put(category, new ArrayList<>());
//            }
//            groupedProducts.get(category).add(product);
//        }
//    }


}
