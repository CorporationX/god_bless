package faang.school.godbless.amazon_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Set<Product> products = Stream.of(new Product(1, "Laptop", "Electronics"),
                new Product(2, "Book", "Books"),
                new Product(3, "Shoes", "Fashion"),
                new Product(4, "Smartphone", "Electronics")).collect( Collectors.toSet());

        Map<String, List<Product>> sortedProducts = sortProductsByCategory(products);
        printAllCategories(sortedProducts);
    }



    public static Map<String, List<Product>> sortProductsByCategory(Set<Product> products){
        Map<String, List<Product>> sortedProducts = new HashMap<>();
        for(Product product: products){
            if(!sortedProducts.containsKey(product.getCategory())){
                sortedProducts.put( product.getCategory(), new ArrayList<>() );
            }
            sortedProducts.get(product.getCategory()).add( product );
        }
        return sortedProducts;
    }

    public static void printAllCategories(Map<String, List<Product>> sortedProducts){
        for(Map.Entry<String, List<Product>> entry: sortedProducts.entrySet()){
            System.out.println("Product category: " + entry.getKey()  + " : " + entry.getValue());
        }
    }

}
