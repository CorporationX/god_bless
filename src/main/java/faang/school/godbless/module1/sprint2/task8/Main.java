package faang.school.godbless.module1.sprint2.task8;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item helm = new Item("Helm of Fury", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, helm, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("Helm of Fury"));

        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}
