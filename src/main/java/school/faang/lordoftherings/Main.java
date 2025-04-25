package school.faang.lordoftherings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет %s добавлен в инвентарь", item.getName()));
        manager.addItem(frodo, sword, (item) ->
                System.out.printf("\nПредмет %s добавлен в инвентарь", item.getName()));
        System.out.println("\nFrodo inventory: " + frodo.getInventory());

        manager.updateItem(frodo, item -> "Sword".equals(item.getName()),
                item -> {
                    item.setPrice(item.getPrice() + 200);
                    return item;
                }
        );
        System.out.println("Frodo inventory: " + frodo.getInventory());

        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));
        System.out.println("Frodo inventory: " + frodo.getInventory());
    }
}
