package school.faang.bjs245552;

public class SampleData {
    public void test() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem(frodo, (item) -> item != null && item.getName().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
