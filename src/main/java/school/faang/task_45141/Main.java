package school.faang.task_45141;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Warehouse products = new Warehouse();

        products.addItem(Category.BOOKS, "Kingdom rise");
        products.addItem(Category.CLOTHES, "Boots");
        products.addItem(Category.ELECTRONICS, "Iphone");
        products.addItem(Category.BOOKS, "Math");
        products.addItem(Category.CLOTHES, "Shirt");
        products.addItem(Category.CLOTHES, "Pants");

        products.printAllItems();

        products.removeItem(Category.BOOKS, "Lamp");
        products.removeItem(Category.CLOTHES, "Boots");

        products.findItemsByCategory("Clothes");

        Map<String, List<Product>> grouped = products.groupProductsByCategory();
        products.printProductsByCategory(grouped);
    }
}