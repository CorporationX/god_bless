package school.faang.lord_of_the_rings;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("Кольцо", 1000);
        Item sword = new Item("Меч", 500);
        Item shield = new Item("Щит", 300);

        Character frodo = new Character("Frodo");
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " добавлено в инвентарь"));
        manager.addItem(frodo, sword, item -> System.out.println(item.getName() + " добавлено в инвентарь"));
        manager.addItem(frodo, shield, item -> System.out.println(item.getName() + " добавлено в инвентарь"));
        System.out.println(frodo);

        manager.removeItem(frodo, item -> item.getName().contains("Кольцо"));
        System.out.println(frodo);

        manager.updateItem(frodo, item -> item.getName().equals("Меч"), item -> {
            item.setValue(item.getValue() * 2);
            return item;
        });
        System.out.println(frodo);
    }
}