package school.faang.task_bjs245611;

public class Main {
    public static void main(String[] args) {
        Character character1 = new Character("Frodo");
        InventoryManager frodoInventoryManager = new InventoryManager(character1);
        frodoInventoryManager.addItem(new Item("Gold ring", 1000),
                item -> System.out.println("В инвентаре новый предмет: " + item.getName()));
        frodoInventoryManager.addItem(new Item("Iron sword", 400),
                item -> System.out.println("В инвентаре новый предмет: " + item.getName()));
        frodoInventoryManager.addItem(new Item("Iron sword", 400),
                item -> System.out.println("В инвентаре новый предмет: " + item.getName()));
        frodoInventoryManager.addItem(new Item("Silver ring", 600),
                item -> System.out.println("В инвентаре новый предмет: " + item.getName()));
        frodoInventoryManager.removeItem(item -> item.getName().equals("Iron sword"));
        frodoInventoryManager.updateItem(item -> item.getValue() > 800,
                item -> new Item(item.getName(), item.getValue() / 2));
        System.out.println(character1.getInventory());
    }
}
