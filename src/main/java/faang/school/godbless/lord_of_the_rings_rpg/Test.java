package faang.school.godbless.lord_of_the_rings_rpg;

public class Test {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Character pippin = new Character("pippin");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        frodo.getInventory().add(new Item("Item1", 500));
        frodo.getInventory().add(new Item("Item2", 700));
        frodo.getInventory().add(new Item("Item3", 1200));

        System.out.println(frodo.getInventory());

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println("---------------------------------------");
        System.out.println(frodo.getInventory());
// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("Item3"));
        System.out.println("---------------------------------------");
        System.out.println(frodo.getInventory());
// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("Item2"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory());
    }
}
