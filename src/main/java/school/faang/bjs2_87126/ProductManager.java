package school.faang.bjs2_87126;

import java.util.*;


public class ProductManager {
    Set<Product> products = new HashSet<>();
    public int id = 0;

    public void addProduct(Category category, String name) {
        int count = id++;
        Product product = new Product(count, name, category);

        products.add(product);

    }

    public void removeProduct(Category category, String name) {
        Product removeProduct = null;
        for (Product product : products) {
            if (product.category == category && product.name == name) {
                removeProduct = product;
                break;
            }
        }
        products.remove(removeProduct);
    }

    public List<Product> findProduct(Category category) {
        List<Product> listOfProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.category == category) {
                listOfProducts.add(product);
            }
        }
        return listOfProducts;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> categoryMap = new HashMap<>();

        for (Product product : products) {
            Category catOfProduct = product.category;
            if (!categoryMap.containsKey(catOfProduct)) {
                categoryMap.put(catOfProduct, new ArrayList<>());
            }
            categoryMap.get(catOfProduct).add(product);

        }
        return categoryMap;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> grouped = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> entry : grouped.entrySet()) {
            System.out.println("Категория " + entry.getKey());
            System.out.println("Продукты ");
            for (Product value : entry.getValue()) {
                System.out.println(value.name);
            }
        }
    }
}
