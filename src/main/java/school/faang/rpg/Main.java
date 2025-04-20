package school.faang.rpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring,
                item -> System.out.printf("➕ %s был добавлен в инвентарь.%n", item.name()));

        manager.removeItem(frodo,
                item -> item.name().contains("Ring"));

        manager.addItem(frodo, ring,
                item -> System.out.printf("🔁 %s снова добавлен.%n", item.name()));
        manager.updateItem(frodo,
                item -> item.name().equals("The One Ring"),
                item -> new Item(item.name(), item.value() * 2));

        System.out.println("📦 Инвентарь Фродо:");
        frodo.getInventory().forEach(
                item -> System.out.printf("• %s — %d золота%n", item.name(), item.value()));
    }
}