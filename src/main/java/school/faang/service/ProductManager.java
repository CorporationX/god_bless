package school.faang.service;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List> categoryMap;

    //создает новый продукт с указанной категорией и именем, добавляет его в множество продуктов и обновляет categoryMap.
    public void addProduct(Category category, String name) {
        Product newProduct = new Product(name,category);
        products.add(newProduct);
        System.out.println(products);
    }
}
