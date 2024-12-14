package school.faang.task_45167;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product("Категория 1", "Продукт A"));
        products.add(new Product("Категория 1", "Продукт B"));
        products.add(new Product("Категория 2", "Продукт C"));
        products.add(new Product("Категория 2", "Продукт D"));
        products.add(new Product("Категория 3", "Продукт E"));

        Map<String, List<Product>> groupedProducts = ProductList.groupProductsByCategory(products);
        ProductList.printProductsByCategory(groupedProducts);

        ProductList.addItem("Категория 1", "Продукт F");
        ProductList.addItem("Категория 1", "Продукт G");
        ProductList.addItem("Категория 2", "Продукт H");
        ProductList.addItem("Категория 2", "Продукт I");
        ProductList.addItem("Категория 3", "Продукт J");
        System.out.println();
        ProductList.findItemsByCategory("Категория 1");
        System.out.println();
        ProductList.printAllItems();
        System.out.println();
        ProductList.removeItem("Категория 1", "Продукт G");
        System.out.println();
        ProductList.printAllItems();
    }
}
