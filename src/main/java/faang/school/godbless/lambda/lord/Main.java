package faang.school.godbless.lambda.lord;

public class Main {

    private static final String ITEM_RING = "The One Ring";
    private static final String ITEM_FOOD = "Food";

    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item(ITEM_RING, 1000);
        Item food = new Item(ITEM_FOOD, 10);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, afterAdd -> System.out.println(ring + " was added to the inventory of " + frodo));
        manager.addItem(frodo, food, afterAdd -> System.out.println(ring + " was added to the inventory of " + frodo));
        manager.printInventory(frodo);

        manager.removeItem(frodo, item -> item.getName().equals(ITEM_FOOD));
        manager.printInventory(frodo);

        manager.updateItem(frodo, item -> item.getName().equals(ITEM_RING), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.printInventory(frodo);
    }
}
