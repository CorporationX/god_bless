package school.faang.sprint_1.task_45133;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        products.add(new Product(1, "Carrot", "Vegetables"));
        products.add(new Product(2,"Apple", "Fruits"));
        products.add(new Product(3,"Banana", "Fruits"));
        products.add(new Product(4,"Milk", "Dairy"));
        System.out.println(products);


        ProductService items = new ProductService();


    }


}
