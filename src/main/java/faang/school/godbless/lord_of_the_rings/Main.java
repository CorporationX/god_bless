package faang.school.godbless.lord_of_the_rings;

public class Main {

    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item anotherRing = new Item("Another ring", 500);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, anotherRing, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("Another ring"), (item) -> {
            item.setValue(item.getValue() * 2);
            return item;
        });
    }
}