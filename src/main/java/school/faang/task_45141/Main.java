package school.faang.task_45141;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Warehouse products = new Warehouse();

        products.addItem(new Product(Category.BOOKS, "Kingdom rise"));
        products.addItem(new Product(Category.CLOTHES, "Boots"));
        products.addItem(new Product(Category.ELECTRONICS, "Iphone"));
        products.addItem(new Product(Category.BOOKS, "Math"));
        products.addItem(new Product(Category.CLOTHES, "Shirt"));
        products.addItem(new Product(Category.CLOTHES, "Pants"));

        products.printAllItems();

        products.removeItem(new Product(Category.BOOKS, "Lamp"));
        products.removeItem(new Product(Category.CLOTHES, "Boots"));

        products.findItemsByCategory("Clothes");

        Map<String, List<Product>> grouped = products.groupProductsByCategory();
        products.printProductsByCategory(grouped);
    }
}