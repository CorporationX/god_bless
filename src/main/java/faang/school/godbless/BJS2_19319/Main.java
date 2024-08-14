package faang.school.godbless.BJS2_19319;

import java.util.*;

public class Main {
    public static final Product PRODUCT_1 = new Product(1, "Платье", "Одежда");
    public static final Product PRODUCT_2 = new Product(2, "Кроссовки", "Обувь");
    public static final Product PRODUCT_3 = new Product(3, "Наушники", "Аксессуары");
    public static final Product PRODUCT_4 = new Product(4, "Книга", "Печатная продукция");
    public static final Product PRODUCT_5 = new Product(5, "Телефон", "Средство связи");
    public static final Product PRODUCT_6 = new Product(6, "Зарядное устройство", "Аксессуары");
    public static final Product PRODUCT_7 = new Product(7, "Футболка", "Одежда");

    public static final Set<Product> products = new HashSet<>() {{
        add(PRODUCT_1);
        add(PRODUCT_2);
        add(PRODUCT_3);
        add(PRODUCT_4);
        add(PRODUCT_5);
        add(PRODUCT_6);
        add(PRODUCT_7);
    }};

    public static Map<String, List<Product>> groupProductsByCategory (Set<Product> products) {
        Map<String, List<Product>> productsCategoryMap = new HashMap<>();
        for (Product product : products) {
            String productCategory = product.getCategory();
            if (productsCategoryMap.containsKey(productCategory)) {
                productsCategoryMap.get(productCategory).add(product);
            } else {
                productsCategoryMap.put(productCategory, new ArrayList<>(List.of(product)));
            }
        }
        return productsCategoryMap;
    }

    public static void printProductsGroupedByCategory (Map<String, List<Product>> groupProductsByCategory) {
        for (Map.Entry<String, List<Product>> entry : groupProductsByCategory.entrySet()) {
            System.out.println("Категория: \"" + entry.getKey() + "\", товары: " + entry.getValue() + ".");
        }
    }

    public static void main(String[] args) {
        printProductsGroupedByCategory(groupProductsByCategory(products));
    }
}
