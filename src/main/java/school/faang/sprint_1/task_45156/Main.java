package school.faang.sprint_1.task_45156;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<Product>();
        products.add(new Product("Молоко", "Молочная продукция"));
        products.add(new Product("Сметана", "Молочная продукция"));
        products.add(new Product("Бородинский хлеб", "Хлебобулочные изделия"));
        products.add(new Product("Тостовый хлеб", "Хлебобулочные изделия"));
        products.add(new Product("Шоколад", "Сладости"));

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        printProductsByCategory(groupedProducts);

        ProductGroups groups = new ProductGroups(groupedProducts);
        groups.findItemsByCategory("Молочная продукция");
        groups.addItem("Напитки", "Апельсиновый сок");
        groups.printAllItems();
        groups.removeItem("Сладости", "Шоколад");
        groups.printAllItems();
        groups.removeItem("Хлебобулочные изделия", "Ржаной хлеб");
        groups.removeItem("Торты", "Медовик");
        groups.findItemsByCategory("Торты");
    }

    public static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> categories = new HashMap<String, List<Product>>();

        for (Product product : products) {
            categories.computeIfAbsent(product.getCategory(), k ->  new ArrayList<>()).add(product);
        }

        return categories;
    }

    public static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        groupedProducts.forEach((category, listProducts) -> {
            System.out.println("Категория: " + category);
            for (Product product : listProducts) {
                System.out.println("\t" + product);
            }
            System.out.println();
        });
    }
}
