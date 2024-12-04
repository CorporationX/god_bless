package school.faang.task_45105;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorage();

        String meatCategory = "Meat";
        String pork = "Pork";
        String chicken = "Chicken";

        productStorage.addItem(meatCategory, pork);
        productStorage.addItem(meatCategory, chicken);

        String dairyCategory = "Dairy";
        String milk = "Milk";
        String cheese = "Cheese";

        productStorage.addItem(dairyCategory, milk);
        productStorage.addItem(dairyCategory, cheese);

        productStorage.printAllItems();

        Map<String, List<Product>> groupedProductsByCategory = ProductStorage
                .groupProductsByCategory(productStorage.getProducts());
        ProductStorage.printProductsByCategory(groupedProductsByCategory);

        productStorage.removeItem(meatCategory, chicken);
        productStorage.removeItem(dairyCategory, milk);

        productStorage.printAllItems();
    }
}
