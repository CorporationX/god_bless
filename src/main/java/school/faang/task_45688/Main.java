package school.faang.task_45688;

public class Main {
    public static void main(String[] args) {
        Character gandalf = new Character("Гэндальф");
        Item stick = new Item("Посох", 10_000);
        Item ring = new Item("Кольцо", 10);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(stick, gandalf, (item) ->
                System.out.println("""
                        Вы добавили в интвентарь
                        """ + stick.getName()));
        inventoryManager.addItem(ring, gandalf, (item) ->
                System.out.println("""
                        Вы добавили в интвентарь
                        """ + ring.getName()));
        System.out.println(gandalf.getInventory());
        System.out.println("");

        inventoryManager.removeItem(stick, gandalf, (item) -> item.getName().equals("Посох"));
        System.out.println(gandalf.getInventory());
        System.out.println("");

        inventoryManager.updateItem(gandalf, (item) -> item.getName().equals("Кольцо"),
                (item) -> new Item(item.getName(), item.getValue() + 10_000));
        System.out.println(gandalf.getInventory());
    }
}
