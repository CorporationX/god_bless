package school.faang.dismantlingtheamazonwarehouse45131;

import java.util.*;

public class Main {
    private HashSet<Product> products = new HashSet<>();

    public void addItem(String category, String name) {
        int id = products.size() + 1;
        Product product = new Product(id, name, category);
        products.add(product);
        System.out.println("Product was add: " + product);
    }

    public void removeItem(String category, String name) {
        boolean found = false;
        for (Product product : products) {
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                products.remove(product);
                found = true;
                System.out.println("Product was delete");
                break;
            }
        }
        if (!found) {
            System.out.println("Product or category don't was found");
        }
    }

    public void findItemsByCategory(String category) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                foundProducts.add(product);
            }
        }
        if (foundProducts.isEmpty()) {
            System.out.println("Product don't was find");
        } else {
            System.out.println("Product in category: " + category + ": " + foundProducts);
        }
    }

    public void printAllItems() {
        if (products.isEmpty()) {
            System.out.println("No products");
        } else {
            System.out.println("All products: ");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public Map<String, List<Product>> groupProductsByCategory(HashSet<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupedProducts;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", products: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.addItem("electronics", "phone");
        main.addItem("electronics", "notebooks");
        main.addItem("book", "Java");

        main.printAllItems();
        main.findItemsByCategory("electronics");
        main.removeItem("book", "Java");
        main.printAllItems();

        Map<String, List<Product>> groupedProducts = main.groupProductsByCategory(main.products);
        main.printProductsByCategory(groupedProducts);
    }
}
