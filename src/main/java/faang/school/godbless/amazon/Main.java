package faang.school.godbless.amazon;

import java.util.*;

public class Main {
    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        products.add(new Product(1, "IPhone", "phone"));
        products.add(new Product(2, "Laptop", "PC"));
        products.add(new Product(3, "Macbook", "PC"));
        groupByCategory(products);
    }

    public static Map<String, List<Product>> groupByCategory(Set<Product> products) {
        Map<String, List<Product>> res = new HashMap<>();
        products.forEach(el -> {
            res.put(el.getCategory(),new ArrayList<>(products).stream().filter(p->p.getCategory().equals(el.getCategory())).toList());
        });
        for (Map.Entry<String,List<Product>>item:res.entrySet()) {
            System.out.println(item.getKey()+" "+item.getValue());
        }
        return res;
    }
}
