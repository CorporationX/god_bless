package school.faang.amazon79806;

import java.util.*;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private static int idCount = 0;


    public void addProduct(Category category, String name) {
        for (Product product : products) {
            if (Objects.equals(product.getName(), name) && product.getCategory() == category) {
                System.out.printf("Товар %s с категорией %s уже есть", name, category);
                return;
            }
        }
        products.add(new Product(++idCount, category, name));
    }

    public void removeProduct(Category category, String name) {
        if (category == null || name == null) {
            System.out.println("вы ввели пустые поля");
            return;
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (Objects.equals(product.getName(), name) && product.getCategory() == category) {
                iterator.remove();
                System.out.println("Товар удалён");
                return;
            }
            System.out.printf("Товара %s из категории %s на складе нет. Его удаление не возможно", name, category);
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                productList.add(product);
            }
        }
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {
        Map<Category, List<Product>> productsMap = new HashMap<>();
        for (Product product : products) {
            productsMap.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsMap.get(product.getCategory()).add(product);
        }
        return productsMap;
    }

    public void printAllProducts() {
        Map<Category, List<Product>> productsMap = groupProductsByCategory();
        for (Map.Entry<Category, List<Product>> prod : productsMap.entrySet()) {
            String category = String.format("Категория %s: %nТовары: ", prod.getKey());
            System.out.println(category);
            for (Product productValue : prod.getValue()) {
                String product = String.format("-%s", productValue.getName());
                System.out.println(product);
            }
        }
    }
}