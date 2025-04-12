package gratsio_BJS2_68672;

import java.util.*;

public class ProductManager {
    private final Set<Product> products = new HashSet<Product>();
    private int currentIdOfProduct = 1;

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("A product with that name already exists in another category!");
                return;
            }
        }
        int id = currentIdOfProduct++;
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCategory().equals(category) && iterator.next().getName().equals(name)) {
                System.out.println(iterator.next().getName() + " removed from the category " + iterator.next().getCategory());
                iterator.remove();
                return;
            }
        }
        System.out.println("There is no product with this category in stock.");
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> listOfProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                listOfProducts.add(product);
            }
        }
        if (!listOfProducts.isEmpty()) {
            return listOfProducts;
        } return Collections.emptyList();
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            Category category = product.getCategory();
            if (!productsByCategory.containsKey(category)) {
                productsByCategory.put(category, new ArrayList<>());
            }
            productsByCategory.get(category).add(product);
        }
        return productsByCategory;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> entry : groupProductsByCategory().entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Products: ");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
