package faang.school.godbless.BJS2_19400;

import lombok.Data;

import java.util.*;

@Data
public class Main {
    private Set<Product> products;

    public Main() {
        this.products = new HashSet<>();
        products.add(new Product("Яблоко", "Фрукты"));
        products.add(new Product("Банан", "Фрукты"));
        products.add(new Product("Морковь", "Овощи"));
        products.add(new Product("Картошка", "Овощи"));
        products.add(new Product("Селедка", "Рыба"));
    }

    public Map<String, List<Product>> groupProduct(Set<Product> productSet) {
        Map<String, List<Product>> groupProduct = new HashMap<>();
        for (Product product : productSet) {
            groupProduct.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }
        return groupProduct;
    }

    public void printInfoProductsOfCategory() {
        Map<String, List<Product>> groupProduct = groupProduct(products);
        for (Map.Entry<String, List<Product>> entry : groupProduct.entrySet()) {
            System.out.println("Группировка по категориям: " + entry.getKey());
            System.out.println("Продукты: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.printInfoProductsOfCategory();

        System.out.println("Добавление Груши в категорию Фрукты:");
        main.getProducts().add(new Product("Груша", "Фрукты"));
        main.printInfoProductsOfCategory();
    }
}
