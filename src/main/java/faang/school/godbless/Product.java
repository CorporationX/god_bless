package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Product {
    private int id;
    private String name;
    private String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String toString(){
        return name;
    }

    public static void main(String args[]){
        Set<Product> productSet = new HashSet<>();

        Product product1 = new Product(1, "Apple", "Fruits");
        Product product2 = new Product(2, "Banana", "Fruits");
        Product product3 = new Product(3, "Dog", "Animals");
        Product product4 = new Product(4, "Cat", "Animals");
        Product product5 = new Product(5, "Parrot", "Animals");
        Product product6 = new Product(6, "Chips", "Snack");
        Product product7 = new Product(7, "Phone", "Technic");
        Product product8 = new Product(8, "Computer", "Technic");
        Product product9 = new Product(9, "Water", "Drink");
        Product product10 = new Product(10, "Cola", "Drink");

        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product5);
        productSet.add(product6);
        productSet.add(product7);
        productSet.add(product8);
        productSet.add(product9);
        productSet.add(product10);

        Map<String, List<Product>> groupedProducts = groupMap(productSet);

        printAll(groupedProducts);

    }

    public static Map<String, List<Product>> groupMap(Set<Product> productSet){
        Map<String, List<Product>> groupedProducts = new HashMap<>();
        for(Product element : productSet){
            String category = element.getCategory();
            if(!groupedProducts.containsKey(category)){
                groupedProducts.put(category, new ArrayList<>());
            }
            groupedProducts.get(category).add(element);
        }
        return groupedProducts;
    }

    public static void printAll(Map<String, List<Product>> groupMap){
        for(Map.Entry<String, List<Product>> entry: groupMap.entrySet()){
            System.out.println("Категория: " + entry.getKey() + " Товары: " + entry.getValue());
        }
    }
}
