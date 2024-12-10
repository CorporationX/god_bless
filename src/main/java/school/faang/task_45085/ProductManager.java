package school.faang.task_45085;

import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class ProductManager {

    private Set<Product> productSet = new HashSet<>();
    private Map<String, List<Product>> groupedProduct = new HashMap<>();

    public void addItem(String category, String name) {
        if (category == null || name == null || category.isEmpty() || name.isEmpty()) {
            System.out.println("Категория или имя не могут быть пустыми");
            return;
        }
        Product product = new Product(name, category);
        productSet.add(product);
        groupedProduct.computeIfAbsent(category, key -> new ArrayList<>()).add(product);
    }

    public void removeItem(String category, String name) {
        List<Product> categoryProducts = groupedProduct.get(category);
        if (categoryProducts != null) {
            Iterator<Product> iteratorProductCategory = categoryProducts.iterator();
            boolean productFound = false;

            while (iteratorProductCategory.hasNext()) {
                Product product = iteratorProductCategory.next();
                if (Objects.equals(product.getName(), name)) {
                    iteratorProductCategory.remove();
                    productSet.remove(product);
                    productFound = true;
                    break;
                }
            }
            if (!productFound) {
                System.out.println("Продукт не найден в категории " + category);
            }
        } else {
            System.out.println("Категория не найдена");
        }
    }

    public void findItemsByCategory(String category) {
        if (groupedProduct.containsKey(category)) {
            System.out.println("В категории " + category + " находятся следующие продукты:");
            List<Product> categoryProducts = groupedProduct.get(category);
            for (Product product : categoryProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Данной категории не существует");
        }
    }

    public void printAllItems() {
        if (groupedProduct.isEmpty()) {
            System.out.println("На складе нет товаров");
        } else {
            for (var entry : groupedProduct.entrySet()) {
                String category = entry.getKey();
                List<Product> categoryProducts = entry.getValue();
                System.out.println("В категории " + category + " находятся следующие продукты:");

                for (Product product : categoryProducts) {
                    System.out.println(product);
                }
                System.out.println();
            }
        }
    }

    public Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }
        return productMap;
    }

    public void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        if (groupedProducts.isEmpty()) {
            System.out.println("Данные отсутствуют");
            return;
        }
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            List<Product> categoryProducts = entry.getValue();
            if (categoryProducts.isEmpty()) {
                System.out.println("В этой категории нет продуктов");
            } else {
                for (Product product : categoryProducts) {
                    System.out.println(product);
                }
            }
        }
        System.out.println();
    }
}
