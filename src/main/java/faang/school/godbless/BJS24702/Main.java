package faang.school.godbless.BJS24702;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Ноут", "Электроника"));
        products.add(new Product(2, "Телек", "Электроника"));
        products.add(new Product(3, "Трусы", "Шмот"));
        products.add(new Product(4, "Джинсы", "Шмот"));
        products.add(new Product(5, "Телефон", "Электроника"));

        Map<String, List<Product>> productsByCategory = Product.groupProductsByCategory(products);

        System.out.println("Продукты по категориям:");
        Product.printProductsByCategory(productsByCategory);
    }
}
