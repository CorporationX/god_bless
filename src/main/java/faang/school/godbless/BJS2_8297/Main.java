package faang.school.godbless.BJS2_8297;

import java.util.*;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "Orange", "Fruits"));
        products.add(new Product(2, "Banana", "Fruits"));
        products.add(new Product(3, "Apple", "Fruits"));
        products.add(new Product(4, "Perch", "Fish"));
        products.add(new Product(5, "Pike", "Fish"));
        products.add(new Product(6, "Dorado", "Fish"));
        products.add(new Product(7, "Pepper", "Species"));
        products.add(new Product(8, "Salt", "Species"));

        printInfoAboutCategories();
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> productsSet) {
        Map<String, List<Product>> categoryGroups = new HashMap<>();

        for (var product: productsSet) {
            categoryGroups.computeIfAbsent(product.getCategory(), key -> new ArrayList<>()).add(product);
        }

        return categoryGroups;
    }

    public static void printInfoAboutCategories() {
        for (var category: groupByCategory(products).entrySet()) {
            System.out.println("Category: " + category.getKey());

            for (var product: category.getValue()) {
                System.out.println("Id: " + product.getId() +
                        "\nName: " + product.getName());
            }

            System.out.println("-".repeat(20));
        }
    }
}

