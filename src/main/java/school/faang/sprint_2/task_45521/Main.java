package school.faang.sprint_2.task_45521;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("The One Ring", 1000);
        Character character = new Character();

        InventoryManager manager = new InventoryManager(character);

        manager.addItem(ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem((item) -> item.getName().equals("The One Ring"));

        manager.addItem(ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        character.getItems().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
