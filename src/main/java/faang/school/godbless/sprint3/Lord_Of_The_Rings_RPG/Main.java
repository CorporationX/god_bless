package faang.school.godbless.sprint3.Lord_Of_The_Rings_RPG;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws Exception {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        Consumer<Item> test = (item) -> System.out.println(item.getName() + " was added to the inventory.");
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, test);
        System.out.println("Frodo add " + frodo.getInventory().get(0).getValue());

        // Обновляем предмет в инвентаре
        try {
            manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("Frodo update " + frodo.getInventory().get(0).getValue());

        // Удаляем предмет из инвентаря
        try {
            manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("Frodo remove " + frodo);


    }
}
