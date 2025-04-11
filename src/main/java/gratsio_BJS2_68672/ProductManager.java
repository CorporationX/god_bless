package gratsio_BJS2_68672;

import java.util.*;
import gratsio_BJS2_68672.Category;

public class ProductManager {
    private final Set<Product> products = new HashSet<Product>();
    private int CurrentIdOfProduct = 1;

    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (product.getName().equals(name) && product.getCategory().equals(category)) {
                System.out.println("Товар с таким именем уже существует в другой категории");
                return;
            }
        }
        int id = CurrentIdOfProduct++;
        Product product = new Product(id, name, category);
        products.add(product);
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCategory().equals(category) && iterator.next().getName().equals(name)) {
                System.out.println(iterator.next().getName() + " удален из категории " + iterator.next().getCategory());
                iterator.remove();
                return;
            }
        }
        System.out.println("Продукта с такой категорией нет на складе");
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> ListOfProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                ListOfProducts.add(product);
            }
        }
        if (!ListOfProducts.isEmpty()) {
            return ListOfProducts;
        } return null;
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
            System.out.println("Категория: " + entry.getKey());
            System.out.println("Продукты: ");
            for (Product product : entry.getValue()) {
                System.out.println("- " + product.getName());
            }
        }
    }
}
