package theLordOfTheRings;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " was added to the inventory"));
        manager.printInfoAboutCharacter(frodo);

        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> {
            item.setValue(item.getValue() * 2);
            return item;
        });
        manager.printInfoAboutCharacter(frodo);

        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));
        manager.printInfoAboutCharacter(frodo);

    }
}
