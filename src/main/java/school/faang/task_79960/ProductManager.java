package school.faang.task_79960;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductManager {
    private int id = 1;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(id, name, category);
        products.add(product);
        id++;
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(product -> product.getCategory().equals(category)
                && product.getName().equals(name));
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = products.stream().filter(product1 -> product1.getCategory().equals(category)).toList();
        productList.forEach(element -> System.out.println(element.getName()));
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        return products.stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupByProduct = groupProductsByCategory();
        groupByProduct.forEach((category, products) -> {
            System.out.println("Категория: " + category);
            System.out.println("Продукты: ");
            products.forEach(product -> System.out.println("- " + product.getName()));
        });
    }
}
