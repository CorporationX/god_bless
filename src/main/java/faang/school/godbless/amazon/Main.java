package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Product> set = new HashSet<>();
        set.add(new Product(1, "Head & Shoulders", "Shampoo"));
        set.add(new Product(2, "Beef", "Meat"));
        set.add(new Product(3, "Coca-Cola", "Soda"));
        set.add(new Product(4, "Snickers", "Chocolate"));
        set.add(new Product(5, "Chicken", "Meat"));
        set.add(new Product(6, "Twix", "Chocolate"));
        set.add(new Product(7, "Pantene", "Shampoo"));

        Map<String, List<Product>> productsByCategory = groupGoodsByCategory(set);
        printAllCategoryOfGoods(productsByCategory);
    }

    public static void printAllCategoryOfGoods(Map<String, List<Product>> mapCategoryAndProducts) {
        for (Map.Entry<String, List<Product>> entry : mapCategoryAndProducts.entrySet()) {
            System.out.println("CATEGORY: " + entry.getKey() + ".\nPRODUCTS: " + entry.getValue());
            System.out.println();
        }
    }

    public static Map<String, List<Product>> groupGoodsByCategory(Set<Product> setProducts) {
        Map<String, List<Product>> categoryOfProducts = new HashMap<>();

        for (Product product : setProducts) {
            String category = product.getCategory();
            List<Product> productList = categoryOfProducts.getOrDefault(category, new ArrayList<>());
            productList.add(product);
            categoryOfProducts.put(category, productList);
        }
        return categoryOfProducts;
    }
}
