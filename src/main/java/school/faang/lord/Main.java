package school.faang.lord;

public class Main {

  public static void main(String[] args) {
    Character frodo = new Character("Frodo");
    InventoryManager manager = new InventoryManager();

    Item ring = new Item("The ring", 100);
    manager.addItem(frodo, ring, (item -> System.out.println(item.getName() + " added")));

    Item blade = new Item("The blade", 10);
    manager.addItem(frodo, blade, (item -> System.out.println(item.getName() + " added")));

    manager.addItem(frodo, new Item("Some item", 1000),
        (item -> System.out.println(item.getName() + " added")));

    manager.removeItem(frodo, (item) -> item.getName().equals("Some item"));

    manager.updateItem(frodo, (item) -> item.getName().equals("The ring"), (item) -> new Item(
        item.getName() + "*", item.getValue() * 2));

    frodo.getInventory()
        .forEach(item -> System.out.println(item.getName() + " " + item.getValue()));
  }

}
