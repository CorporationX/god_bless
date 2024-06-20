package faang.school.godbless.java_sql.task_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    static HashSet<Product> products = ProductProvider.provideProducts();
    static HashMap<String, List<Product>> productsGroupedByCategory =
            ProductUtils.groupProductsByCategory(products);

    public static void main(String[] args) {
        ProductUtils.printProductsDescription(productsGroupedByCategory);
    }
}
