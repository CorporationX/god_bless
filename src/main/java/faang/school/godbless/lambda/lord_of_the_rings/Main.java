package faang.school.godbless.lambda.lord_of_the_rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item food = new Item("Бутерброд", 10);
        Item sword = new Item("Меч", 1);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println("Добавлен новый предмет: " + item.getName()));
        manager.addItem(frodo, food, item -> System.out.println("Добавлен новый предмет: " + item.getName()));
        manager.removeItem(frodo, item -> item.getValue() < 15);
        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item(item.getName(), item.getValue() * 2));
        manager.addItem(frodo, sword, item -> System.out.println("Добавлен новый предмет: " + item.getName()));
        System.out.println(frodo.getInventory());
    }
}
