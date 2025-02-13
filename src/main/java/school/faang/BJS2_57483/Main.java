package school.faang.BJS2_57483;

public class Main {
    private static final int MAX_VALUE = 800;

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring,
                (item -> System.out.printf("%s успешно добавлен в инвентарь\n", item.getName())));
        System.out.printf("%s\n", frodo);
        System.out.println("--------------");

        manager.updateItem(frodo, item -> item.getValue() <= 1000,
                item -> new Item(item.getName(), item.getValue() * 2));
        System.out.printf("%s\n", frodo);
        System.out.println("--------------");

        manager.removeItem(frodo, item -> item.getValue() > MAX_VALUE);
        System.out.printf("%s\n", frodo);
    }
}
