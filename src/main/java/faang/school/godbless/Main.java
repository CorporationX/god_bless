package faang.school.godbless;

import java.util.*;

public class Main {
    private static Set<Product> allProduct = new HashSet<>();
    private static Map<String, List<Product>> groupByCategory = new HashMap<>();

    public static void main(String[] args) {

        allProduct.add(new Product(1, "AAA", "aaa"));
        allProduct.add(new Product(2, "BBB", "bbb"));
        allProduct.add(new Product(3, "FFF", "aaa"));
        allProduct.add(new Product(4, "EEE", "aaa"));

        groupProductByCategory(allProduct);

        System.out.println(allProduct);
        System.out.println(groupByCategory);

        infoProducts();
    }

    static Map<String, List<Product>> groupProductByCategory(Set<Product> products) {
        for (Product oneProduct : products) {
            if (!groupByCategory.containsKey(oneProduct.getCategory())) {
                groupByCategory.computeIfAbsent(oneProduct.getCategory(), newProduct -> new ArrayList<>()).add(oneProduct);
            } else
                groupByCategory.get(oneProduct.getCategory()).add(oneProduct);
        }
        return groupByCategory;
    }

    static void infoProducts() {
        for (Map.Entry<String, List<Product>> entryCategoryAndList : groupByCategory.entrySet()) {
            System.out.println(entryCategoryAndList.getKey() + " -> " + entryCategoryAndList.getValue());
        }
    }
}
