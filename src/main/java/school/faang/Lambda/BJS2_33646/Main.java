package school.faang.Lambda.BJS2_33646;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item sword = new Item("Sword", 100);
        Item shield = new Item("Shield", 150);
        Item bow = new Item("Bow", 120);
        Item stone = new Item("Stone", 0);
        Item cloak = new Item("Elven Cloak", 200);
        Item stick = new Item("Stick", 0);

        inventoryManager.addItem(frodo, sword,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        inventoryManager.addItem(frodo, shield,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        inventoryManager.addItem(frodo, bow,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        inventoryManager.addItem(frodo, stone,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        inventoryManager.addItem(frodo, cloak,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        inventoryManager.addItem(frodo, stick,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        inventoryManager.removeItem(frodo,
                (item) -> item.getValue() == 0);
        inventoryManager.removeItem(frodo,
                (item) -> item.getValue() == 0);
        inventoryManager.removeItem(frodo,
                (item) -> item.getName().equals("Bow"));

        inventoryManager.updateItem(frodo,
                (item) -> item.getName().equals("Shield"),
                (item) -> item.setValue(item.getValue() * 2));


        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
