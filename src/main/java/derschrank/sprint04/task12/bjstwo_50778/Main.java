package derschrank.sprint04.task12.bjstwo_50778;

public class Main {
    private static final int COUNTS_ITEMS_IN_SHOP = 100;
    private static final int COUNTS_ITEMS_IN_INVENTORY = 50;
    private static final int DELAY_FOR_COMBAIN_PROCESS_MILLIS = 100;

    public static void main(String[] args) {
        Inventory unit = new Inventory();
        ProviderItemsInterface shop = new Shop();

        Service.fillItemsInProvider(shop, COUNTS_ITEMS_IN_SHOP);
        System.out.println("\nSHOP HAS ITEMS: \n" + shop.getListOfItems());

        for (int i = 0; i < COUNTS_ITEMS_IN_INVENTORY; i++) {
            unit.buyItem(
                    shop,
                    Service.RND.nextInt(shop.getCountOfItems())
                    );
        }

        System.out.printf("%nNOW INVENTORY HAS %d ITEMS:%n%s%n", unit.getCountOfItems(), unit.getListOfItems());
        System.out.printf("%nNOW SHOP HAS %d ITEMS:%n%s%n", shop.getCountOfItems(), shop.getListOfItems());

        System.out.println("\nNOW WORKSHOP WITH ITEMS FROM SHOP AND INVENTORY: \n" + shop.getListOfItems());
        int originalCountOfItems = unit.getCountOfItems();
        for (int i = 0; i < originalCountOfItems; i++) {
            Item fromShop = shop.getItem(0).get();
            Item fromInventory = unit.getItem(0).get();
            Service.toSleep(DELAY_FOR_COMBAIN_PROCESS_MILLIS);
            Item newItem = unit.combineItems(fromInventory, fromShop);
            System.out.println("Combined new item: " + newItem);
            unit.addItem(newItem);
        }

        System.out.printf("%nNOW INVENTORY HAS %d ITEMS:%n%s%n", unit.getCountOfItems(), unit.getListOfItems());
        System.out.printf("%nNOW SHOP HAS %d ITEMS:%n%s%n", shop.getCountOfItems(), shop.getListOfItems());
    }
}
