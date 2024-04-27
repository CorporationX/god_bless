package carry;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        for (int i = 0; i<5; i++) {
            inventory.addItem(new Item("InventoryItem" + i, i+5));
        }

        inventory.combineItemsAndAddInInventory();
        inventory.shutdown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        inventory.getItems().forEach(System.out::println);
    }
}
