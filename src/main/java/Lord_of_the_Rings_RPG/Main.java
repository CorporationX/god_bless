package Lord_of_the_Rings_RPG;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        System.out.println(frodo);
// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println(frodo);

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName()!=null &&
                        item.getName().equals("The One Ring"),
                (item) -> {
                    frodo.setInventory(new Item(item.getName(), item.getValue() * 2));
                    return frodo.getInventory();
                });
        System.out.println(frodo);

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println(frodo);


    }
}
