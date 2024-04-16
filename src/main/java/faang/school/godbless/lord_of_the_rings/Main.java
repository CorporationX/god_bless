package faang.school.godbless.lord_of_the_rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Фродо");
        Item ring = new Item("Одно кольцо", 10000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " добавлен(о) в инвентарь"));

        manager.updateItem(frodo, (item) -> item.getName().equals("Одно кольцо"),
                (item) -> new Item(item.getName(), item.getValue() * 2),
                (item) -> System.out.println(item.getName() + " было обновлено"));

        manager.removeItem(frodo, (item) -> item.getName().equals("Одно кольцо"),
                (item) -> System.out.println(item.getName() + " удалено из инвентаря"));

        manager.updateItem(frodo, (item) -> item.getName().equals("Одно кольцо"),
                (item) -> new Item(item.getName(), item.getValue() * 2),
                (item) -> System.out.println(item.getName() + " было обновлено"));

        manager.removeItem(frodo, (item) -> item.getName().equals("Одно кольцо"),
                (item) -> System.out.println(item.getName() + " удалено из инвентаря"));
    }
}
