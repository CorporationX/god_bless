package amazon;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> setProduct = new HashSet<>();
        setProduct.add(new Product(0,"Колбаса", "Мясные продукты"));
        setProduct.add(new Product(1,"Молоко", "Молочные продукты"));
        setProduct.add(new Product(2, "Творог", "Молочные продукты"));
        setProduct.add(new Product(3, "Свиная голень", "Мясные продукты"));
        setProduct.add(new Product(4, "Квас", "Напитки"));

        Product.groupProduct(setProduct);
        Product.outputMap(Product.groupProduct(setProduct));
    }
}
