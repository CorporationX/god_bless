package LambdaStream.bc1273;

public class Application {
    public static void main(String[] args) {

        java.lang.Character frodo = new java.lang.Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));


// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));


// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

    }
}
