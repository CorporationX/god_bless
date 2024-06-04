package faang.school.godbless.amazon;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Pen", "Chancellery");
        Product product2 = new Product(2, "PencilBox", "Chancellery");
        Product product3 = new Product(3, "Pencil", "Chancellery");
        Product product4 = new Product(4, "MP3 player", "Technology");
        Product product5 = new Product(5, "Speaker", "Technology");
        Product product6 = new Product(6, "Microphone", "Technology");
        Product product7 = new Product(7, "Table", "Furniture");
        Product product8 = new Product(8, "Chair", "Furniture");
        Product product9 = new Product(9, "Door", "Furniture");

        Set<Product> productSet = Set.of(product1, product2, product3, product4, product5,
                                         product6, product7, product8, product9);

        Map<String, List<Product>> categoryMap = Product.groupByCategory(productSet);

        Product.showAllProductsGroupedByCategory(categoryMap);
    }
}
