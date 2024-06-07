package faang.school.godbless.module.second.lambda.rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        
        InventoryManager manager = new InventoryManager();
        
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        frodo.showInventory();
        
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        frodo.showInventory();
        
        // Обновляем предмет в инвентаре
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.updateItem(
            frodo,
            (item) -> item.getName().equals("The One Ring"),
            (item) -> new Item(item.getName(), item.getValue() * 2)
        );
        frodo.showInventory();
    }
}
