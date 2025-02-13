package school.faang.BJS2_57426;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character inventoryFrodo = new Character("Frodo");
        Item ring = new Item("золотое кольцо", 1000);
        Consumer<Item> handler = item -> System.out.printf("%s положил %s в инвентарь\n",
                inventoryFrodo.getName(), ring.getName());
        manager.addItem(ring, inventoryFrodo, handler);
        System.out.println(inventoryFrodo.getInventory());

        Predicate<Item> isInventory = item -> inventoryFrodo.getInventory().contains(item);
        manager.removeItem(ring, inventoryFrodo, isInventory);
        System.out.println(inventoryFrodo.getInventory());

        Function<Item, Integer> doublePrice = item -> item.getValue() * 2;
        manager.addItem(ring, inventoryFrodo, handler);
        System.out.println(inventoryFrodo.getInventory());
        manager.updateItem(ring, inventoryFrodo, doublePrice);
        System.out.println(inventoryFrodo.getInventory());
    }
}
