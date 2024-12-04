package school.faang.task45099;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ProductManagement {

    private Map<String, List<Product>> productsByCategory;

    private void validation(String category, String nameProduct) {
        if (category == null || nameProduct == null) {
            throw new IllegalArgumentException("Category and name cannot be null");
        }
    }

    private void findCategory(String category) {
        if (!productsByCategory.containsKey(category)) {
            throw new IllegalArgumentException("There is no such category.");
        }
    }

    public void addItem(int id, String nameProduct, String category) {
        validation(category, nameProduct);

        productsByCategory.putIfAbsent(category, new ArrayList<>());

        List<Product> productCategory = productsByCategory.get(category);
        Product product = new Product(id, nameProduct, category);

        if (productCategory.contains(product)) {
            throw new IllegalArgumentException("The product has already been successfully added to the category.");
        } else {
            productCategory.add(product);
            System.out.println("The product has been successfully added to the category.");
        }
    }

    public void removeItem(int id, String nameProduct, String category) {
        validation(category, nameProduct);

        List<Product> products = productsByCategory.get(category);
        Product product = new Product(id, nameProduct, category);

        findCategory(category);

        if (!products.remove(product)) {
            throw new IllegalArgumentException("There is no such product.");
        } else {
            System.out.println("The product has been successfully deleted.");
        }

    }

    public void findItemsByCategory(String category) {
        findCategory(category);
        productsByCategory.get(category).forEach(System.out::println);
    }

    public void printAllItems() {
        if (productsByCategory.isEmpty()) {
            throw new IllegalArgumentException("There is no such category.");
        }
        productsByCategory.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
