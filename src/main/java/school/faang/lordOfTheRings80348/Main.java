package school.faang.lordOfTheRings80348;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item ring = new Item("The Ring", 1000);

        manager.addItem(frodo, ring, (item) -> System.out.printf("Предмет '%s' был добавлен в инвентарь персонажа '%s' %n", item.getName(), frodo.getName()));
        System.out.println(frodo.getInventory());
        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));
        System.out.println(frodo.getInventory());

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));


        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

    }
}
