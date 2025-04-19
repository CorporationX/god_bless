package school.faang.rpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring,
                item -> System.out.printf("➕ %s был добавлен в инвентарь.%n", item.getName()));

        manager.removeItem(frodo,
                item -> item.getName().contains("Ring"));

        manager.addItem(frodo, ring,
                item -> System.out.printf("🔁 %s снова добавлен.%n", item.getName()));
        manager.updateItem(frodo,
                item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        System.out.println("📦 Инвентарь Фродо:");
        frodo.getInventory().forEach(
                item -> System.out.printf("• %s — %d золота%n", item.getName(), item.getValue()));
    }
}