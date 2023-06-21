package faang.school.godbless.Lord.of.the.Rings.RPG;

public class Application {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item stick = new Item("Stick", 1);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, stick, (item) -> System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        for (Item item: frodo.getInventory()){
            System.out.println(item.getName() + " " + item.getValue());
        }
    }
}
