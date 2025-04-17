package school.faang.bjs2_70032;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.printf("%s был добавлен в инвентарь.%n", item.getName()));
        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));
        manager.addItem(frodo, ring, (item) -> System.out.printf("%s снова добавлен.%n", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The Two Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        frodo.getInventory().forEach(item -> System.out.printf("%s : %s%n", item.getName(), item.getValue()));
    }
}