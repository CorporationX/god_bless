package school.faang.lordoftherings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("кольцо", 1000);
        Item sword = new Item("меч", 800);
        Item shield = new Item("щит", 2000);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, item ->
                System.out.println(String.format("Предмет %s был добавлен в инвентарь", item.getName())));

        manager.addItem(frodo, sword, item ->
                System.out.println(String.format("Предмет %s был добавлен в инвентарь", item.getName())));

        manager.addItem(frodo, shield, item ->
                System.out.println(String.format("Предмет %s был добавлен в инвентарь", item.getName())));
        System.out.println("\nИнвентарь после добавления предметов");
        manager.printInventory(frodo);
        System.out.println("\nИнвентарь после удаления кольца");
        manager.removeItem(frodo, item -> item.getName().equals("кольцо"));
        manager.printInventory(frodo);
        System.out.println("\nИнвентарь после обновления стоимости меча");
        manager.updateItem(frodo, item -> item.getName().equals("меч"),
                item -> new Item(item.getName(), item.getValue() * 2));
        manager.printInventory(frodo);


    }
}
