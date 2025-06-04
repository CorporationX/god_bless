package school.faang.amazon79806;

import lombok.Getter;

import java.util.*;

public class ProductManager {
    @Getter
    private Set<Product> products = new HashSet<>();
    private static int idCount = 0;

    public void addProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product productForSet = iterator.next();
            if (Objects.equals(productForSet.getName(), name) && Objects.equals(productForSet.getCategory(), category)) {
                System.out.println("Товар " + name + " с категорией " + category + " уже есть");
                return;
            }
        }
        int id = ++idCount;
        products.add(new Product(id, category, name));
    }

    public void removeProduct(Category category, String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product productForSet = iterator.next();
            if (productForSet.getName() == null || productForSet.getCategory() == null) {
                System.out.println("вы ввели пустые поля");
                return;
            }
            if (Objects.equals(productForSet.getName(), name) && productForSet.getCategory() == category) {
                iterator.remove();
                System.out.println("Товар удалён");
                return;
            }
        }
        System.out.println("Товара " + name + " из категории "
                + category + " на складе нет. Его удаление не возможно");
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
        if (productList.isEmpty()) {
            System.out.println("Товаров указанной " + category + " нет");
            return new ArrayList<>();
        } else {
            System.out.println("Вот список товаров из категории " + category + ": ");
            for (Product product : productList) {
                System.out.println("-" + product.getName());
            }
            return productList;
        }
    }

    @Getter
    private Map<Category, List<Product>> productsMap = new HashMap<>();

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