package faang.school.godbless.BJS2_5141;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(1, "Крауч энд", "book"),
                new Product(2, "Том соер", "book"),
                new Product(3, "Кукуруза", "food"),
                new Product(4, "Картошка", "food"),
                new Product(5, "Шоколад", "food")
        );
        ProductsByGroup productsByGroup = new ProductsByGroup();
        productsByGroup.toGroupProducts(products);
        productsByGroup.printAllProductsByGroup();
    }
}
