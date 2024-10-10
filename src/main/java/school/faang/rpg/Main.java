package school.faang.rpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        System.out.println("предмет удален");

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " снова добавлен в инвентарь."));
        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item("The One Ring", item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

    }

}
