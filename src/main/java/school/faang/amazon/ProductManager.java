package school.faang.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {

    private Set products = new HashSet<>();
    private Map<Category, List> categoryMap = new HashMap<>();


    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        System.out.println("Добавления товаров");
    }

    public void removeProduct(Category category, String name) {
        for (Category : products) {

        }
    }

}
