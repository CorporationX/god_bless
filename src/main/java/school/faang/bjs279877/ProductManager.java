package school.faang.bjs279877;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int id = 0;

    private void add(CategoryProduct categoryProduct, String name) {
        Product product = new Product(id, name, categoryProduct);
        products.add(product);
        log.info("Продукт добавлен");
        id++;
    }

    private boolean exitIfEmpty() {
        if (products.isEmpty()) {
            log.info("База данных пока пустая.");
            return true;
        } else {
            return false;
        }
    }

    public void addProduct(CategoryProduct categoryProduct, String name) {
        if (name == null || name.isEmpty()) {
            log.warn("не можно использовать пустое имя или строку");
            return;
        }
        if (products.isEmpty()) {
            add(categoryProduct, name);
        } else {
            for (Product product : products) {
                if (product.getName().equals(name) && product.getCategoryProduct().equals(categoryProduct)) {
                    log.info("Товар с имене: {} уже существует в категории {}", name, categoryProduct);
                    return;
                }
            }
            add(categoryProduct, name);
        }
    }

    public void removeProduct(CategoryProduct categoryProduct, String name) {
        if (name == null || name.isEmpty()) {
            log.warn("не может быть пустого значения или строка");
            return;
        }
        if (exitIfEmpty()) {
            return;
        }
        for (Product product : products) {
            if (product.getName().equals(name)) {
                if (product.getCategoryProduct() == categoryProduct) {
                    products.remove(product);
                    log.info("Продукст под именем {} удален из категории: {}", name, categoryProduct);
                    return;
                }
            }
        }
        log.info("В категории {} такого товара и так нет", categoryProduct);
    }

    public List<String> findProductsByCategory(CategoryProduct categoryProduct) {
        if (exitIfEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategoryProduct() == categoryProduct) {
                result.add(product.getName());
            }
        }
        log.info("Товара в этом каталоге пока нет.");
        return null;
    }

    public Map<CategoryProduct, List<Product>> groupProductsByCategory() {
        if (exitIfEmpty()) {
            return null;
        }

        Map<CategoryProduct, List<Product>> result = new HashMap<>();
        for (CategoryProduct categoryProduct : CategoryProduct.values()) {
            for (Product product : products) {
                if (categoryProduct == product.getCategoryProduct()) {
                    result.computeIfAbsent(categoryProduct, k -> new ArrayList<>()).add(product);
                }
            }
        }
        return result;
    }

    public void printAllProducts() {
        Map<CategoryProduct, List<Product>> map;
        map = groupProductsByCategory();
        if (map == null) {
            return;
        } else {
            for (Map.Entry<CategoryProduct, List<Product>> entry : map.entrySet()) {
                System.out.println("Категория: " + entry.getKey());
                System.out.println("Продукты:");
                for (Product product : entry.getValue()) {
                    System.out.println("- " + product.getName());
                }
                System.out.println();
            }
        }
    }
}
