package school.faang.amazon79806;

import lombok.Getter;

import java.util.*;

public class ProductManager {

    private Set<Product> products = new HashSet<>();
    private static int idCount = 0;
    private Map<Category, List<Product>> productsMap = new HashMap<>();

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
            System.out.println("Товара " + name + " из категории "
                    + category + " на складе нет. Его удаление не возможно");
        }
    }

    public List<Product> findProductsByCategory(Category category) {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product productForSet = iterator.next();
            if (productForSet.getCategory() == category) {
                productList.add(productForSet);
            }
        }
        return productList;
    }

    public Map<Category, List<Product>> groupProductsByCategory() {

        for (Product product : products) {
            if (productsMap.get(product.getCategory()) != null) {
                List<Product> productList = productsMap.get(product.getCategory());
                productList.add(product);
            } else {
                productsMap.put(product.getCategory(), new ArrayList<>(List.of(product)));
            }
        }
        return productsMap;
    }

    public void printAllProducts() {
        for (Map.Entry<Category, List<Product>> prod : productsMap.entrySet()) {
            String result = String.format("Категория %s: %nТовары: ", prod.getKey());
            System.out.println(result);
            for (Product product : prod.getValue()) {
                String result2 = String.format("-%s", product.getName());
                System.out.println(result2);
            }
        }
    }
}