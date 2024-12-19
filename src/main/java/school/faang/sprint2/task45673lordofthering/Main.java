package school.faang.sprint2.task45673lordofthering;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + "был добавлен в инвентарь."
                + " Стоимость инвентаря: " + frodo.inventoryCost()));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен"));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
