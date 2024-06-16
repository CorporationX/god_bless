package faang.school.godbless.BJS29199;

public class Main {
    public static void main(String[] args) {
        Character gollum = new Character("Gollum");
        Item myPrecious = new Item("My Precious", 100);
        InventoryManager manager = new InventoryManager();

        manager.printInventory(gollum);

        manager.addItem(gollum, myPrecious, (item) ->
                System.out.println(item.getName() + "'s value: " + item.getValue()));
        manager.printInventory(gollum);

        manager.addItem(gollum, myPrecious, (item) ->
                System.out.println(item.getName() + "'s value: " + item.getValue()));
        manager.printInventory(gollum);

        manager.removeItem(gollum, myPrecious, (item) -> item.getValue() > 100);
        manager.printInventory(gollum);

        manager.updateItem(gollum, (item) -> item.getValue() < 200,
                (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.printInventory(gollum);

        manager.removeItem(gollum, myPrecious, (item) -> item.getValue() > 100);
        manager.printInventory(gollum);
    }
}
