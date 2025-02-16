package school.faang.lord_of_rings;

public class Main {

    public static void main(String[] args) {
        Character indian = new Character("Indian");
        Item ring = new Item("The Sharpest Sword", 100);
        InventoryManager manager = new InventoryManager();

        manager.addItem(indian, ring, item -> System.out.println(item.getName() +
                " added to inventory and itemConsumer can do everything with this item"));

        manager.removeItem(indian, item -> "The Sharpest Sword".equals(item.getName()));

        manager.addItem(indian, ring, item -> System.out.println(item.getName() + " added again"));

        manager.updateItem(indian, item -> "The Sharpest Sword".equals(item.getName()),
                item -> item.getValue() * 2);

        indian.getInventory().forEach(item -> System.out.println(item.getName() +
                ": " + item.getValue()));
    }
}
