package faang.school.godbless.lord;

public class Main {
    public static void main(String[] args) {
        Hero testHero = new Hero("test hero");
        Item sword = new Item("sword", 550);
        Item pike = new Item("pike", 1000);
        Item onion = new Item("onion", 1500);

        InventoryManager manager = new InventoryManager();
        manager.addItem(testHero, sword, item -> System.out.println(
                String.format("Hero %s hand %s in inventory", testHero.getName(), item.getName())));
        manager.addItem(testHero, pike, item -> System.out.println(
                String.format("Hero %s hand %s in inventory", testHero.getName(), item.getName())));
        manager.addItem(testHero, onion, item -> System.out.println(
                String.format("Hero %s hand %s in inventory", testHero.getName(), item.getName())));

        manager.removeItem(testHero, item -> item.getName().equals("pike"));
        System.out.println(testHero.getInventory());

        manager.updateItem(testHero, item -> item.getName().equals("onion"),
                item -> new Item(item.getName(), item.getValue() * 3));
    }


}
