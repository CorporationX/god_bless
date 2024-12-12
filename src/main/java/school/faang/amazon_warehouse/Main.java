package school.faang.amazon_warehouse;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Product> productSet= new HashSet<>();
        productSet.add(new Product("Apple", "Fruits"));
        productSet.add(new Product("Carrot", "Vegetables"));
        productSet.add(new Product("Banana", "Fruits"));
        productSet.add(new Product("Broccoli", "Vegetables"));
        productSet.add(new Product("Milk", "Dairy"));

        Warehouse warehouse = new Warehouse(productSet);
        Map<String, List<Product>> mapByCategory = warehouse.groupProductsByCategory(warehouse.getProducts());
        warehouse.printProductsByCategory(mapByCategory);


    }
}
