package school.faang.task_45138;

import school.faang.task_45138.entity.CategoryType;
import school.faang.task_45138.entity.Product;
import school.faang.task_45138.storage.ProductStorage;


public class Main {
    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorage();
        Product meatPork = new Product("Pork", CategoryType.MEAT);
        Product meatChicken = new Product("Chicken", CategoryType.MEAT);
        Product dairyMilk = new Product("Milk", CategoryType.DAIRY);
        Product dairyCheese = new Product("Cheese", CategoryType.DAIRY);

        productStorage.addItem(meatPork);
        productStorage.addItem(meatChicken);
        productStorage.addItem(dairyMilk);
        productStorage.addItem(dairyCheese);
        productStorage.printAllItems();
        System.out.println(productStorage.findItemsByCategory(CategoryType.DAIRY));
        productStorage.removeItem(dairyCheese);
        productStorage.removeItem(dairyMilk);
        productStorage.printAllItems();
    }
}
