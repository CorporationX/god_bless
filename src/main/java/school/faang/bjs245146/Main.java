package school.faang.bjs245146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    private static HashSet<Product> products = new HashSet<>();

    private static void addItem(int id, String category, String name) {
        products.add(new Product(id, category, name));
    }

    private static void removeItem(int id, String category, String name) {
        Product product = new Product(id, category, name);
        if (products.contains(product)) {
            products.remove(product);
        } else {
            System.out.println("Такого продукта не существует в нашем множестве");
        }
    }

    private static void findItemsByCategory(String category) {
        List<Product> listProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                listProduct.add(product);
            }
        }
        if (!listProduct.isEmpty()) {
            System.out.println(listProduct);
        } else {
            System.out.println("Указанной категории товаров не существует в нашем множестве");
        }
    }

    private static void printAllItems() {
        System.out.println(products);
    }

    private static Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupProducts = new HashMap<>();
        for (Product product : products) {
            groupProducts.computeIfAbsent(product.getCategory(), category -> new ArrayList<>())
                    .add(product);
        }
        return groupProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> products) {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        addItem(2, "Milk", "Food");
        addItem(3, "Iphone", "Household appliances");
        addItem(4, "Soap", "Household chemicals");
        addItem(5, "TV", "Household appliances");
        addItem(1, "Apple", "Food");

        printAllItems();

        removeItem(1, "Tomato", "Food");

        findItemsByCategory("Household appliances");

        Map<String, List<Product>> categoryProduct = groupProductsByCategory(products);
        printProductsByCategory(categoryProduct);
    }
}
