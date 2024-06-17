package faang.school.godbless.stream_split.rpg_game;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", null);
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        frodo = manager.addItem(frodo, ring, (item) -> System.out.println(item + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"), (item) -> new Item(item.name(), item.value() * 2));
        System.out.println(frodo);
    }
}