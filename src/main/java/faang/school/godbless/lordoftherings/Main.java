package faang.school.godbless.lordoftherings;

public class Main {
    public static void main(String[] args) {
        Character naruto = new Character("Naruto");
        Item ring = new Item("The One Ring", 1000);
        Item knife = new Item("Something", 500);
        Item ak47 = new Item("AK-47", 1500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(naruto, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(naruto, knife, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(naruto, ak47, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.removeItem(naruto, (item) -> item.getName().equals("The One Ring"));
        manager.updateItem(naruto, (item) -> item.getName().equals("The One Ring"),
                                             item -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(naruto.getInventory());
    }
}
