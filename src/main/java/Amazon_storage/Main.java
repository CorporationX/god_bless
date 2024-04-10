package Amazon_storage;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>();
        Product book1 = new Product(1, "Harry Potter by J. K. Rowling", "Fantasy");
        Product b2 = new Product(2, "1984 by George Orwell", "Classic");
        Product b3 = new Product(3, "Misery by Stephen King", "Horror");
        Product b4 = new Product(4, "The Coworker by Freida McFadden", "Detective");
        Product b5 = new Product(5, "The Outsiders by S.E. Hinton", "Classic");
        Product b6 = new Product(6, "Hidden Pictures by Jason Rekulak", "Horror");
        Product b7 = new Product(7, "The Diary of a Young Girl by Anne Frank", "Classic");
        Product b8 = new Product(8, "The Midnight Library by Matt Haig", "Fantasy");

        products.add(book1);
        products.add(b2);
        products.add(b3);
        products.add(b4);
        products.add(b5);
        products.add(b6);
        products.add(b7);
        products.add(b8);

        for (Map.Entry<String, List<Product>> entry : Product.groupProducts(products).entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Name: " + entry.getValue());
        }
    }
}
