package school.faang.bjs2_80424;

public class Main {
    public static void main(String[] args) {
        Item sword = new Item("Arbus", 500);
        Character aragorn = new Character("Aragorn");
        Item ring = new Item("Ring of Ashes", 1000);
        Character legolas = new Character("Legolas");
        Item potion = new Item("Healing potion", 100);
        Character gimli = new Character("Gimli");


        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(aragorn, sword,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь"));
        inventoryManager.addItem(aragorn, potion,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь"));

        inventoryManager.removeItem(aragorn, item -> item.getName().contains("Arbus"));

        inventoryManager.updateItem(aragorn, item -> item.getName().equals("Healing potion"),
                item -> new Item(item.getName(), item.getValue() * 2));

        aragorn.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

    }
}
