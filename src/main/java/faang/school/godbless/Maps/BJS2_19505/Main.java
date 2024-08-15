package faang.school.godbless.Maps.BJS2_19505;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {

        products.add(new Product("Rolex", "Luxury"));
        products.add(new Product("Ademars", "Luxury"));
        products.add(new Product("Omega", "Mass market"));
        products.add(new Product("Breguet", "Exclusive"));
        products.add(new Product("Casio", "Mass market"));
        products.add(new Product("PatekPH", "Luxury"));
        products.add(new Product("Zenit",  "Exclusive"));

        printAllProds(gruopProdsMap());

    }

    public static Map<String, List<Product>> gruopProdsMap() {
        Map<String, List<Product>> result = new HashMap<>();
        for (Product prod : products) {
            result.computeIfAbsent(prod.getCategory(), k -> new ArrayList<>());
            result.get(prod.getCategory()).add(prod);
        }
        return result;
    }

    public static void printAllProds(Map<String, List<Product>> prodsMap) {
        for (Map.Entry<String, List<Product>> entry : prodsMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
