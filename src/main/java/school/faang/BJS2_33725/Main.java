package school.faang.BJS2_33725;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item, character) ->
                System.out.println(item.getName() + " был добавлен в инвентарь персонажа " + character.getName()));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
