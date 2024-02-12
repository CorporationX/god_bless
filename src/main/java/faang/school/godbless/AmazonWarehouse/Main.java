package faang.school.godbless.AmazonWarehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static jdk.internal.org.jline.utils.Colors.s;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
    }
    public static void groupProduct (Set<Product> productSet){
        Map<String, List<Product>> groupsProducts = new HashMap();
        for(Product product : productSet){
            groupsProducts.computeIfAbsent(product.getCategory(),k -> new ArrayList<>()).add(product);
        }
    }
    public static void printAll(Map<String, List<Product>> groupsProducts){
        for(Map.Entry entry : groupsProducts.entrySet()) {
            System.out.println(String.format("Категория: \"%s\"." ,entry.getKey()));
            for (Product product : entry.getValue()) { // Почему нельзя без объявление переменной? Выдавает ошибку с
                System.out.println(product.getName());
            }
        }
    }
}
