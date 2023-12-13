package faang.school.godbless.BJS2_644;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> setOfProduct = new HashSet<>();
        setOfProduct.add(new Product(1, "Banana", "Food"));
        setOfProduct.add(new Product(2, "Apple", "Food"));
        setOfProduct.add(new Product(43, "Energetic", "Liquid"));
        output(sortProduct(setOfProduct));

    }
    public static HashMap<String, List<Product>> sortProduct(Set<Product> setOfProduct){
        HashMap<String, List<Product>> result = new HashMap<>();
        for (Product p : setOfProduct) {
            if(!result.containsKey(p.getCategory())){
                result.put(p.getCategory(), new ArrayList<>());
            }
            result.get(p.getCategory()).add(p);
        }
        return result;
    }
    public static void output(HashMap<String, List<Product>> map){
        for (Map.Entry<String, List<Product>> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
