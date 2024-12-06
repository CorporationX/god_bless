package school.faang.task_45138;

import school.faang.task_45138.entity.Product;
import school.faang.task_45138.storage.ProductStorage;

public class Main {
    public static void main(String[] args) {
        ProductStorage productStorage = new ProductStorage();
        Product meatPork = new Product("Pork","Meat" );
        Product meatChicken = new Product("Chicken","Meat" );
        Product dairyMilk = new Product("Milk","Dairy" );
        Product dairyCheese = new Product("Cheese","Dairy" );

        productStorage.addItem(meatPork);
        productStorage.addItem(meatChicken);
        productStorage.addItem(dairyMilk);
        productStorage.addItem(dairyCheese);
        productStorage.printAllItems();
        System.out.println(productStorage.findItemsByCategory("Meat"));
        productStorage.removeItem(dairyCheese);
        productStorage.removeItem(dairyMilk);
        productStorage.printAllItems();
    }
}
