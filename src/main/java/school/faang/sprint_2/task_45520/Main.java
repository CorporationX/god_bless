package school.faang.sprint_2.task_45520;

public class Main {
    public static void main(String[] args) {
        Character alex = new Character("Alex");
        Item ring = new Item("Ring", 100);
        Item sword = new Item("Sword", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(
                alex,
                ring,
                item -> System.out.println(item.getName() + " was added to inventory")
        );
        manager.addItem(
                alex,
                sword,
                item -> System.out.println(item.getName() + " was added to inventory")
        );
        System.out.println(alex);

        manager.removeItem(
                alex,
                item -> item.getName().equals("Sword")
        );
        System.out.println(alex);

        manager.updateItem(
                alex,
                item -> item.getName().equals("Ring"),
                item -> new Item(item.getName(), (item.getValue() * 5))
        );
        System.out.println(alex);
    }
}
