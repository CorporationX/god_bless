package faang.school.godbless.storage_amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Product> PRODUCT_SET = new HashSet<>();

    private static Map<String, List<Product>> categoryMap;

    public static void main(String[] args) {
        addProduct(1, "Вискас", "Корм");
        addProduct(2, "Pedigree", "Корм");
        addProduct(3, "Cool Cola", "Напитки");
        addProduct(4, "Coca Cola", "Напитки");
        addProduct(5, "Морковь", "Овощи");

        categoryMap = productCategory(PRODUCT_SET);

        System.out.println(productCategory(PRODUCT_SET));

        printProduct();
    }

    public static Map<String, List<Product>> productCategory(Set<Product> productSet){
        Map<String, List<Product>> categoryMap = new HashMap<>();
        for (Product product : productSet){
            String category = product.getCategory();
            if(!categoryMap.containsKey(category)){
                categoryMap.put(category, new ArrayList<>());
            }
            categoryMap.get(category).add(product);
        }
        return categoryMap;
    }

    public static void addProduct(int id, String name, String category){
        PRODUCT_SET.add(new Product(id, name, category));
    }

    public static void printProduct(){
        for (Map.Entry<String, List<Product>> entry: categoryMap.entrySet()){
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
}
