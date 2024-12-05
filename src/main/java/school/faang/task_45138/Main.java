package school.faang.task_45138;

import school.faang.task_45138.storage.ProductStorage;

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

        System.out.println(productStorage.findItemsByCategory(meatCategory));
        productStorage.printProductsByCategory(ProductStorage.groupProductsByCategory(productStorage.products));

        System.out.println(productStorage.removeItem(meatCategory, chicken));
        System.out.println(productStorage.removeItem(dairyCategory, milk));

        productStorage.printAllItems();
    }
}
