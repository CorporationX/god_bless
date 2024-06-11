package faang.school.godbless.BJS2_9040;

public class Application {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring",1000);
        Item oldBoots = new Item("Old Boots", 1);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo,ring,(item)-> System.out.println(item.getName() + " was added to " + frodo.getName() + " inventory"));
        inventoryManager.addItem(frodo,oldBoots,(item)-> System.out.println(item.getName() + " was added to " + frodo.getName() + " inventory"));
        inventoryManager.deleteItem(frodo, oldBoots, item -> item.getName().equals("Old Boots"));
        inventoryManager.updateItem(frodo,ring,item -> item.getName().equals("The One Ring")),;

        System.out.print("Your inventory is: ");
        frodo.getInventory().forEach(item -> System.out.print(item.getName() + ", "));


    }
}