package school.faang.BJS2_57426;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character inventoryFrodo = new Character("Frodo");
        Item ring = new Item("золотое кольцо", 1000);
        Consumer<Item> handler = item -> System.out.printf("%s положил %s в инвентарь\n",
                inventoryFrodo.getName(), ring.getName());
        manager.addItem(ring, inventoryFrodo, handler);
        System.out.println(inventoryFrodo.getInventory());

        manager.removeItem(ring, inventoryFrodo);
        System.out.println(inventoryFrodo.getInventory());

        UnaryOperator<Item> update = item -> {
            item.setValue(item.getValue() * 2);
            return item;
        };

        manager.addItem(ring, inventoryFrodo, handler);
        System.out.println(inventoryFrodo.getInventory());
        manager.updateItem(ring, inventoryFrodo, update);
        System.out.println(inventoryFrodo.getInventory());
    }
}
