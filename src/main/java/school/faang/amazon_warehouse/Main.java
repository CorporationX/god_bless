package school.faang.amazon_warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> productSet= new HashSet<>();
        productSet.add(new Product(1, "Apple", "Fruits"));
        productSet.add(new Product(2, "Carrot", "Vegetables"));
        productSet.add(new Product(3, "Banana", "Fruits"));
        productSet.add(new Product(4, "Broccoli", "Vegetables"));
        productSet.add(new Product(5, "Milk", "Dairy"));

        Warehouse warehouse = new Warehouse(productSet);
        Map<String, List<Product>> mapByCategory = warehouse.groupProductsByCategory(warehouse.getProducts());
        warehouse.printProductsByCategory(mapByCategory);


    }
}
