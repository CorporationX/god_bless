package aboutAmazon;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1, "Продукт 1", "Категория 1"));
        products.add(new Product(2, "Продукт 2", "Категория 2"));
        products.add(new Product(3, "Продукт 3", "Категория 2"));
        products.add(new Product(4, "Продукт 4", "Категория 3"));
        products.add(new Product(5, "Продукт 5", "Категория 3"));

        Product.printCategoriesAndProducts(Product.groupProductsByCategory(products));
    }
}
