package faang.school.godbless.lordsofthering;

public class Main {

    public static void main(String[] args) {
        Character archer = new Character("Harry");
        Item bow = new Item("Soul Eater", 2500);
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(archer, bow, item -> System.out.println("Item collected: " + item.getName()));
        System.out.println(archer.getInventory());
        inventoryManager.updateItem(archer, item -> item.getName().equals("Soul Eater"), item -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(archer.getInventory());
        inventoryManager.removeItem(archer, item -> item.getName().equals("Soul Eater"));
        System.out.println(archer.getInventory());
    }
}