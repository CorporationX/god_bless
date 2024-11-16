package lord;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        List<Item> itemList = List.of(
                new Item("Меч", 100),
                new Item("Кинжал", 120),
                new Item("Бутерброд", 1000),
                new Item("Фонарик", 30)
        );

        Character frodo = new Character(itemList);

        Item iceCream = new Item("Морожение", 1000);
        inventoryManager.addItem(frodo, iceCream, (item) -> System.out.println(item + " добавлен в инвентарь!"));
        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("Фонарик"));
        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("Бутерброд"), (item) -> new Item(item.getName(), item.getValue() * 2));
        inventoryManager.outputList(frodo.getItemList());
    }
}
