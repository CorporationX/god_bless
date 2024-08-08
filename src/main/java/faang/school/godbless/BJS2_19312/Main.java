package faang.school.godbless.BJS2_19312;

import java.util.*;

public class Main {
    private static Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Iphone", "phones"));
        products.add(new Product(2, "Samsung", "phones"));
        products.add(new Product(3, "Lenovo", "laptops"));
        products.add(new Product(4, "Lg wash", "dish washer"));
        products.add(new Product(5, "Motorola", "phones"));

        var groupedProducts = groupProductsByCategory(products);
        printInfo(groupedProducts);
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products){
        Map<String, List<Product>> productsByCategory = new HashMap<>();
        products.forEach(product -> productsByCategory.computeIfAbsent(product.category(), (x) -> new ArrayList<>()).add(product));
        return productsByCategory;
    }

    public static void printInfo(Map<String, List<Product>> groupProductsByCategory){
        for (var product : groupProductsByCategory.entrySet()){
            System.out.println(String.format("Category: %s, Products: %s", product.getKey(), product.getValue()));
        }
    }
}
