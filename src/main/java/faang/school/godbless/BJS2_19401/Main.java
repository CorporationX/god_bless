package faang.school.godbless.BJS2_19401;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();
        Product bmw = new Product(1, "bmw", "car");
        Product volkswagen = new Product(2, "Volkswagen", "car");
        Product boeing747 = new Product(5, "Boeing 747", "airplane");
        Product boeing737 = new Product(6, "Boeing 737", "airplane");
        productSet.add(bmw);
        productSet.add(volkswagen);
        productSet.add(boeing747);
        productSet.add(boeing737);

        Product.GroupingProductsByCategory(productSet);


    }
}
