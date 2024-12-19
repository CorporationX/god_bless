package school.faang.bjs245600;

public class Main {
    private static final int DISCOUNT = 2;
    private static final int MIN_VALUE = 500;
    private static final int UPDATE_VALUE = 1000;

    public static void main(String[] args) {
        Character character = new Character("Baron");
        Item sack = new Item("Sack", 500);
        Item sword = new Item("Sword", 1200);
        InventoryManager manager = new InventoryManager();

        manager.addItem(character, sack, item -> System.out.printf(String.format("%s %d added to the inventory %n",
                item.getName(), item.getValue())));
        manager.addItem(character, sword, item -> System.out.printf(String.format("%s %d added to the inventory %n",
                item.getName(), item.getValue())));
        manager.updateItem(character, item -> item.getValue() <= UPDATE_VALUE,
                item -> new Item(item.getName(), item.getValue() / DISCOUNT));
        manager.removeItem(character, item -> item.getValue() <= MIN_VALUE);

        character.getInventory().forEach(item -> System.out.printf("%s %d%n", item.getName(), item.getValue()));
    }
}