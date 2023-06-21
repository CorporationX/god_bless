package faang.school.godbless.lordOfRings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring,
                (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println("Инвентарь после добавления: " + frodo.getInventory());

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println("Инвентарь после удаления: " + frodo.getInventory());

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (characterItem) -> characterItem.getName().equals("The One Ring"),
                (characterItem) -> new Item(characterItem.getName(), characterItem.getValue() + 200));
        System.out.println("Инфентарь после обновления: " + frodo.getInventory());
    }
}
