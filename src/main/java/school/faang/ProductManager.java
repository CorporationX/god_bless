package school.faang;

import java.util.*;

public class ProductManager {
    private int currentId;
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                return;
            }
        }
        Product product = new Product(currentId++, name, category);
        products.add(product);
        System.out.println("Добавлен товар:" + product);
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getCategory().equals(category) && product.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();

        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }
        return productMap;
    }

    public ArrayList<String> findProductsByCategory(Category category) {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        ArrayList<String> groupedProductList = new ArrayList<>();
        for (Product product : groupedProducts.get(category)) {
            groupedProductList.add(product.getName());
        }
        return groupedProductList;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> groupedProducts = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            System.out.println("Продукты:");
            for (Product product : entry.getValue()) {
                System.out.println(" - " + product.getName());
            }
        }
    }
}
