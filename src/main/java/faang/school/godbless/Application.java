package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

    private static final Set<Product> ID_PRODUCT = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");

        Product firstProduct = new Product(1, "Kolbasa", "eat");
        Product secondProduct = new Product(2, "Eggs", "eat");
        Product thirdProduct = new Product(3, "Shirt", "clothes");
        Product fourthProduct = new Product(4, "Sneakers", "clothes");

        ID_PRODUCT.add(firstProduct);
        ID_PRODUCT.add(secondProduct);
        ID_PRODUCT.add(thirdProduct);
        ID_PRODUCT.add(fourthProduct);

        allCategoryProduct(groupProduct(ID_PRODUCT));
        System.out.println();

    }

    public static Map<String, List<Product>> groupProduct(Set<Product> setProduct) {
        Map<String, List<Product>> groupCategoryProduct = new HashMap<>();
        for (Product product : setProduct) {
            if (groupCategoryProduct.containsKey(product.getCategory())) {
                groupCategoryProduct.get(product.getCategory()).add(product);
            } else {
                groupCategoryProduct.put(product.getCategory(), new ArrayList<>());
                groupCategoryProduct.get(product.getCategory()).add(product);
            }
        }
        return groupCategoryProduct;
    }

    public static void allCategoryProduct(Map<String, List<Product>> groupProduct) {
        for (Map.Entry<String, List<Product>> pair : groupProduct.entrySet()) {
            System.out.println(pair.getKey() + pair.getValue());
        }
    }



}