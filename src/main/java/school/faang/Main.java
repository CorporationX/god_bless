package school.faang;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("%s был добавлен в инвентарь.\n", item.getName())
        );
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        frodo.getInventory().forEach(item -> System.out.printf("%s : %d\n", item.getName(), item.getValue()));

    }
}
