package BJS256905;

import java.util.*;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private Map<Category, ArrayList<Product>> categoryMap = new HashMap<>();
    private int id;

    /**
     * метод добавляет в мап, только если произошло добавление в множество,
     * т.е. продукта раньше не было
     */
    public void addProduct(Category category, String name) {
        if (category != null && !name.isEmpty()) {
            Product product = new Product(name, category);
            product.setId(++id);
            if (products.add(product)) {
                // Добавление в Map
                categoryMap.putIfAbsent(category, new ArrayList<>());
                categoryMap.get(category).add(product);
                StringBuilder addedProduct = new StringBuilder();

                addedProduct.append("Added product: ")
                        .append(product.getName()).append(", ")
                        .append(product.getCategory()).append("\n");
                System.out.println(addedProduct);
            }
        }
    }

    public void removeProduct(Category category, String name) {
        if (category != null && !name.isEmpty()) {
            Product product = new Product(name, category);
            // Проверяем наличие категории и продукта в коллекциях
            if (products.contains(product) && categoryMap.containsKey(category)) {
                // Удаляем из множества
                products.remove(product);

                // Удаляем из списка продуктов, связанного с категорией
                ArrayList<Product> productList = categoryMap.get(category);
                productList.remove(product);

                // Удаляем пустую категорию из мапы
                if (productList.isEmpty()) {
                    categoryMap.remove(category);
                }

                System.out.println("Removed product: " + product.getName() + ", " + product.getCategory());
            } else {
                System.out.println("Product or category not found.");
            }
        } else {
            System.out.println("Invalid category or product name.");
        }

    }

    public ArrayList<Product> findProductByCategory(Category category) {
        return categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productMap = new HashMap<>();
        for (Product product : products) {
            if (!productMap.containsKey(product.getCategory())) {
                productMap.put(product.getCategory(), new ArrayList<>());
            }
            productMap.get(product.getCategory()).add(product);
        }
        System.out.println(productMap);
        return productMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, ArrayList<Product>> entry : categoryMap.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product.getName());
            }
        }
    }


}
