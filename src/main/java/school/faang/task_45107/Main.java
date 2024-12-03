package school.faang.task_45107;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        addItem(Category.Food.toString(), "Apple");
        addItem(Category.Food.toString(), "Banana");
        addItem(Category.Food.toString(), "Qiwi");
        addItem(Category.Electronics.toString(), "Phone");

        System.out.println(findItemsByCategory("Food"));
        removeItem("Food", "Apple");
        System.out.println(printAllItems());

        Map<String, List<Product>> groupedMap = groupProductsByCategory(products);
        printProductsByCategory(groupedMap);
    }

    public static void addItem(String category, String name) {
        try {
            Category categoryTest = Category.valueOf(category);
            Product request = new Product(products.size() + 1, name, Category.valueOf(category));
            products.add(request);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeItem(String category, String name) {
        try{
            Category categoryTest = Category.valueOf(category);
            Product request = null;

            for (Product product : products){
                String checkingCategory = product.getCategory().toString();
                if (checkingCategory.equals(category)){
                    request = product;
                    break;
                }
            }
            
            if (!products.contains(request)) {
                throw new IllegalArgumentException("The product was not found!");
            }
            if (request != null){
                products.remove(request);
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Product> findItemsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();

        try {
            Category categoryTest = Category.valueOf(category);
            for (Product product : products){
                String checkingCategory = product.getCategory().toString();
                if (checkingCategory.equals(category)){
                    productsByCategory.add(product);
                }
            }

            if (productsByCategory.isEmpty()){
                System.out.println("There is no products of that category!");
                return new ArrayList<>();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return productsByCategory;
    }

    private static List<Product> printAllItems(){
        return new ArrayList<>(products);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("Set is empty!");
        }

        Map<String, List<Product>> groupedMap = new HashMap<>();
        for (Product product : products){
            groupedMap.computeIfAbsent(product.getCategory().toString(), (k) -> new ArrayList<>()).add(product);
        }
        return groupedMap;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            throw new IllegalArgumentException("Map is empty!");
        }

        groupedProducts.forEach(
                (k, v) -> System.out.println(k + " -> " + v)
        );
    }
}
