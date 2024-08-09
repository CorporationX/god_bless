package faang.school.godbless.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static faang.school.godbless.amazon.ProductService.groupProductsByCategory;
import static faang.school.godbless.amazon.ProductService.printProducts;

public class Main {

    public static HashSet<Product> products = new HashSet<>();

    static {
        products.add(new Product(1, "apple", "fruit"));
        products.add(new Product(2, "orange", "fruit"));
        products.add(new Product(3, "tomato", "veg"));
        products.add(new Product(3, "cucumber", "veg"));
        products.add(new Product(3, "cucumber", "veg"));
    }

    public static void main(String[] args) {
        HashMap<String, List<Product>> productsMap = groupProductsByCategory(products);
        printProducts(productsMap);
    }

}
