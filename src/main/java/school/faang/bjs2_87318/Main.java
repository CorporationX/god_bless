package school.faang.bjs2_87318;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь"));

        InventoryManager.removeItem(frodo, item -> item.getName().contains("Ring"));

        InventoryManager.addItem(frodo, ring, item -> System.out.println(item.getName() + " снова добавлен."));
        InventoryManager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
