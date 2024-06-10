package faang.school.godbless.LordOfTheRingsRPG;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("A", 201);
        Item item2 = new Item("B", 22);
        Item item3 = new Item("C", 100);
        Character character = new Character("frodo");

        InventoryManager inventoryManager = new InventoryManager();
        // Добавляем предмет в инвентарь
        inventoryManager.addItem(character, item1, (item) -> System.out.println(item.getName() + " добавили в инвентарь"));
        inventoryManager.addItem(character, item2, (item) -> System.out.println(item.getName() + " добавили в инвентарь"));
        inventoryManager.addItem(character, item3, (item) -> System.out.println(item.getName() + " добавили в инвентарь"));
        // Удаляем предмет из инвентаря
        inventoryManager.removeItem(character, (item) -> item.getName().equals("B"));
        // Обновляем предмет в инвентаре
        inventoryManager.updateItem(character, (item) -> item.getName().equals("C"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}
