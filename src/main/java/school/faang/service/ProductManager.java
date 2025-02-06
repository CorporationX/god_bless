package school.faang.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, List<String>> categoryMap = new HashMap<>();

    public void addProduct(Category category, String name) {
        products.add(new Product(name, category));
        categoryMap.computeIfAbsent(category, k -> new ArrayList<>()).add(name);
    }

    public void removeProduct(Category category, String name) {
        products.removeIf(k -> k.getName().equals(name) && k.getCategory() == category);

        if (categoryMap.containsKey(category)) {
            List<String> newList = categoryMap.get(category);
            newList.remove(name);
            if (newList.isEmpty()) {
                categoryMap.remove(category);
            }
        }
    }

    //    findProductsByCategory(Category category): возвращает список
//    всех продуктов в указанной категории. Если категория отсутствует, метод возвращает пустой список.
    public Set<Product> findProductsByCategory(Category category) {
        Set<Product> result = new HashSet<>();
        for (Product value : products) {
            if (value.getCategory() == category) {
                result.add(value);
            }
        }
        return result;
    }

    public void printAllProducts() {
        for (Product value : products) {
            System.out.println(value.getId() + " " + value.getCategory() + " " + value.getName());
        }
        System.out.println("------------------");
        System.out.println(categoryMap);
        System.out.println();
    }
}
