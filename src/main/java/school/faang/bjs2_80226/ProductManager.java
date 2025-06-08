package school.faang.bjs2_80226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductManager {
    private Set<Product> products = new HashSet<>();
    private int idCounter = 1;

    public void addProduct(CategoryEnum category, String name) {
        Product product = new Product(idCounter++, category, name);
        products.add(product);
    }

    public boolean removeProduct(CategoryEnum category, String name) {
        if (category == null || name == null) {
            throw new IllegalArgumentException("Такого продукта нет");
        }
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getCategory() == category && product.getName().equals(name)) {
                productIterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Product> findProductsByCategory(CategoryEnum category) {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                listProducts.add(product);
            }
        }
        return listProducts;
    }

    public Map<CategoryEnum, List<Product>> groupProductsByCategory() {
        Map<CategoryEnum, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            CategoryEnum category = product.getCategory();
            if (!groupedProducts.containsKey(category)) {
                groupedProducts.put(category, new ArrayList<>());
            }
            groupedProducts.get(category).add(product);
        }

        return groupedProducts;
    }

    public void printAllProducts() {
        for (Product product : products) {
            System.out.printf(
                    "ID: %d, Name: %s, Category: %s%n",
                    product.getId(),
                    product.getName(),
                    product.getCategory().getDisplayName()
            );
        }
    }
}
