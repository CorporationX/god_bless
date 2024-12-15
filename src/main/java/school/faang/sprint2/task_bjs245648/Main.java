package school.faang.sprint2.task_bjs245648;

public class Main {

    public static final String ITEM_ONE_RING = "The One Ring";

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item(ITEM_ONE_RING, 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, (item) -> item.getName().equals(ITEM_ONE_RING));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo,
                (item) -> item.getName().equals(ITEM_ONE_RING),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
