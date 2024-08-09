package faang.school.godbless;

import java.util.*;

public class Application {
    public static HashMap<String, List<Product>> groupProductByCategory(HashSet<Product> categories) {
        HashMap<String, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : categories) {
            String category = product.getCategory();
            if (!productsByCategory.containsKey(category)) {
                productsByCategory.put(category, new ArrayList<Product>());
            }
            productsByCategory.get(category).add(product);
        }
        return productsByCategory;
    }

    public static void printProductsByCategory(HashMap<String, List<Product>> productsByCategory) {
        for(Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            for(Product product : entry.getValue()) {
                System.out.println(" " + product);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Book", "Literature"));
        products.add(new Product(2, "Laptop", "Electronics"));
        products.add(new Product(3, "T-shirt", "Clothes"));
        products.add(new Product(4, "Telephone", "Electronics"));
        products.add(new Product(5, "Jeans", "Clothes"));

        HashMap<String, List<Product>> groupedProducts = groupProductByCategory(products);
        printProductsByCategory(groupedProducts);
    }
}