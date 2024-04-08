package faang.school.godbless.lambdas.task_8;

import faang.school.godbless.lambdas.task_8.model.Character;
import faang.school.godbless.lambdas.task_8.model.Item;
import faang.school.godbless.lambdas.task_8.util.InventoryManager;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("Some sword", 150);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println();
        System.out.println("инвентарь до обновления: " + frodo.getInventory());
        manager.updateItem(frodo, (item -> item.getName().equals("The One Ring")), item -> new Item(item.getName(), item.getValue() * 2));
        System.out.println("инвентарь после обновления: " + frodo.getInventory());
        System.out.println();
        System.out.println("инвентарь до удаления: " + frodo.getInventory());
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println("инвентарь после удаления: " + frodo.getInventory());
    }
}