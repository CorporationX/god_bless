package school.faang.lordOfTheRingsRPG;

public class Main {
  public static void main(String[] args) {
    Character frodo = new Character();
    Item ring = new Item("ring", 1000);
    Item armor = new Item("armor", 500);
    Item sword = new Item("sword", 700);

    InventoryManager manager = new InventoryManager();

    manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    manager.addItem(frodo, armor, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

    frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getPrice()));

    manager.removeItem(frodo, (item) -> item.getName().equals("ring"));

    manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
    manager.updateItem(frodo, (item) -> item.getName().equals("ring"), (item) -> new Item(item.getName(), item.getPrice() * 2));

    frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getPrice()));
  }
}
