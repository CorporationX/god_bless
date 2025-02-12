package task_BJS2_57435;


public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item bread = new Item("Elf bread", 500);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.printf("Предмет: \"%s\" - добавлен в инвентарь\n",
                item.getName()));
        manager.addItem(frodo, bread, item -> System.out.printf("Предмет: \"%s\" - добавлен в инвентарь\n",
                item.getName()));

        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, (item) -> item.getName().equals("Elf bread"),
                (item) -> new Item(item.getName() + " from Rivendel", item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
