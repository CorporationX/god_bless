package school.faang.sprint2.bjs_45539;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character();
        Item ring = new Item("The One Ring", 1000);
        Item mirror = new Item("The mirror", 300);
        Item hat = new Item("The hat", 700);

        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, mirror, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, hat, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem(frodo, (item) -> item.getName().contains("ir"));
        manager.addItem(frodo, mirror, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The mirror"),
                (item) -> new Item(item.getName(), item.getItemCost() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getItemCost()));
    }
}
