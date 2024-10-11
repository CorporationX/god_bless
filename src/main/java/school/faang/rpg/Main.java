package school.faang.rpg;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character();
        Item ring = new Item("The One ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " добавлен в инвентарь"));
        manager.removeItem(frodo, item -> item.getName().equals(ring.getName()));

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " снова добавлен"));
        manager.addItem(frodo, new Item("Bag", 200), item -> System.out.println(item.getName() + " добавлен в инвентарь"));
        manager.updateItem(frodo, item -> "Bag".equals(item.getName()), item -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo);
    }
}
