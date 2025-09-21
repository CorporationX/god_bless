package school.faang;

import java.util.*;

import static school.faang.Product.Category.FOOD;

public class ProductManager {
    public static Set<Product> products=new HashSet<>();
    private static int startId;

    static {
        startId = 1;
    }

    public void addProduct(Product.Category category, String name) {
        Product product = new Product("apple", FOOD);
        product.setId(startId);
        product.setName(name);
        product.setCategory(category);
        products.add(product);
        System.out.println("Added product " + product.getName());
        startId++;
    }

    public void removeProduct(Product.Category category, String name) {
        for (Product product : products) {
            if (product.getCategory() == category && product.getName().equals(name)) {
                products.remove(product);
                System.out.println("Removed product " + product.getName());
                break;
            } else {
                System.out.println("Product " + product.getName() + " not found");
            }
        }
    }

    public Set<Product> findProductsByCategory(Product.Category category) {
        Set<Product> foundProducts = new HashSet<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                foundProducts.add(product);
            }
        }
        if (foundProducts.isEmpty()) {
            Set<Product> notFoundProducts = new HashSet<>();
            System.out.println("No products found");
            return notFoundProducts;
        } else {
            return foundProducts;
        }
    }
    public Map<Product.Category, List<Product>> groupProductsByCategory(Product.Category category) {
        Map<Product.Category, List<Product>> foundProducts = new HashMap<>();
        List<Product> foundProductsList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                foundProductsList.add(product);
            }
        }
        foundProducts.put(category, foundProductsList);
        return foundProducts;
    }
    public void showAllProducts(){
        Map<Product.Category, List<Product>> map= new HashMap<>();
        for (Product product : products) {
            if (!map.containsKey(product.getCategory())){
                map.put(product.getCategory(), new ArrayList<>());
            }map.get(product.getCategory()).add(product);
        }
        for (Map.Entry<Product.Category, List<Product>> entry: map.entrySet()){
            System.out.println("Category: " + entry.getKey());
            System.out.println("Products:");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
        System.out.println();
    }
}
