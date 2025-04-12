package school.faang;

import school.faang.product.Category;
import school.faang.product.Product;
import school.faang.product.ProductManager;

import java.util.List;
import java.util.Map;

import static school.faang.product.Category.*;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.add(CLOTHING, "Одежда");
        productManager.add(FOOD, "Food");
        productManager.add(FOOD, "Food 1");
        productManager.add(ELECTRONICS, "Iphone");
        productManager.add(OTHER, "Other product");

        productManager.printAll();
        Map<Category, List<Product>> categoryListMap = productManager.groupProductsByCategory();
        System.out.println(categoryListMap);

        productManager.remove(CLOTHING, "Одежда");
        productManager.printAll();

        List<Product> productsByCategory = productManager.findByCategory(FOOD);
        System.out.println(productsByCategory);
    }
}
