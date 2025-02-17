package school.faang.bjs2_57543;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("Кольцо всевластия", 3000);
        Character frodo = new Character("Фродо");
        InventoryManager inventoryManager1 = new InventoryManager();

        inventoryManager1.addItem(frodo, ring, (item) ->
                System.out.println("Предмет '" + item.getName() + "' был добавлен в инвентарь персонажу "
                        + frodo.getName()));

        Item sword = new Item("Жало", 500);
        Character sam = new Character("Сэм");
        InventoryManager inventoryManager2 = new InventoryManager();
        inventoryManager2.addItem(sam, sword, (item) ->
                System.out.println("Предмет '" + item.getName() + "' был добавлен в инвентарь персонажу "
                        + sam.getName()));

        inventoryManager2.removeItem(sam, (item) -> item.getName().equals("Жало"));
        sam.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        inventoryManager1.updateItem(frodo, (item) -> item.getName().equals("Кольцо всевластия"), (item) ->
                new Item(item.getName(), item.getValue() * 2));
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
