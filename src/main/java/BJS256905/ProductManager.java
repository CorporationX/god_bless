package BJS256905;

import java.util.*;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private Map<Category, ArrayList<Product>> categoryMap = new HashMap<>();
    private int id;


    public void addProduct(Category category, String name) {
        if (category != null && !name.isEmpty()) {
            Product product = new Product(name, category);
            product.setId(++id);
            ArrayList<Product> productToList = new ArrayList<>();
            productToList.add(product);
            products.add(product);
            categoryMap.put(category, productToList);
            StringBuilder addedProduct = new StringBuilder();

            addedProduct.append("Added product: ")
                    .append(product.getName()).append(", ")
                    .append(product.getCategory()).append("\n");
            System.out.println(addedProduct);
        }
    }

    public void removeProduct(Category category, String name) {
        if (category != null && !name.isEmpty()) {
            Product product = new Product(name, category);
            if (categoryMap.equals(product.getCategory())) {
                if (products.contains(product)) {
                    StringBuilder removedProduct = new StringBuilder();
                    removedProduct.append("Removed product: ")
                            .append(product.getName()).append(", ")
                            .append(product.getCategory()).append("\n");
                    products.remove(product);
                    categoryMap.remove(product);

                    System.out.println(removedProduct.toString());
                }
            }
        }

    }

    public ArrayList<Product> findProductByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }


}
