package faang.school.godbless.BJS2_21245;

public class Main {
    public static void main(String[] args) {
        Character bilbo = new Character("Bilbo");
        Item stinger = new Item("Stinger", 1);
        Item handkerchief = new Item("Handkerchief", 1);

        InventoryManager manager = new InventoryManager();
        manager.addItem(bilbo, stinger, (item) -> System.out.println(item.getName() + " was added to the inventory"));
        manager.addItem(bilbo, handkerchief, (item) -> System.out.println(item.getName() + " was added to the inventory"));
        manager.removeItem(bilbo, (item) -> item.getName().equals("Handkerchief"));
        manager.updateItem(bilbo, (item) -> item.getName().equals("Stinger"), (item) -> new Item("GlowingStinger", 1));
    }
}
