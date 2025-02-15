package school.faang.lord;

public class Main {
    public static void main(String[] args) {
        Character character = new Character();

        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 1500);
        Item bodyArmor = new Item("Body armor", 800);

        InventoryManager inventoryManager = new InventoryManager();

        InventoryManager.addItem(character, ring, item -> System.out.println(item.getName() +
                " has been added to the inventory"));
        InventoryManager.addItem(character, sword, item -> System.out.println(item.getName() +
                " has been added to the inventory"));
        InventoryManager.addItem(character, bodyArmor, item -> System.out.println(item.getName() +
                " has been added to the inventory"));

        InventoryManager.removeItem(character, item -> "Sword".equals(item.getName()));

        InventoryManager.updateItem(character, item -> "Body armor".equals(item.getName()), item -> {
            item.setValue(item.getValue() * 2);
            return item;
        });

        System.out.println("Character inventory: ");
        character.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
