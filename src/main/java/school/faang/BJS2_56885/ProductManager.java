package school.faang.BJS2_56885;

import java.util.*;

public class ProductManager {
    private Set<Product> products;
    private Map<Category, List<String>> categoryMap = new HashMap<>();
    List<String> productList = new ArrayList<>();

    public void addProduct(Category category, String name) {
        Product product = new Product(name, category);
        products.add(product);
        if(categoryMap.containsKey(category)) {
            List<String> productsList = new ArrayList<>();
          //додумать логику
            productList.add(name);

        }

    }
    public void removeProduct(Category category, String name) {


    }
    public void findProductsByCategory(Category category) {


    }
    public void groupProductsByCategory() {

    }
    public void printAllProducts() {

    }


}
