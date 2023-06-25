package faang.school.godbless.lambda.lords;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item panties = new Item("SuperMan", 250);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, panties, item -> System.out.println(item.getName() + " - " +
                item.getValue() + " добавлен в инвентарь"));

        System.out.println(frodo.getItemList());
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"),
                item -> System.out.println(item.getName() + " удален!"));

        System.out.println(frodo.getItemList());

        // добавляем снова
        Item boots = new Item("Nike", 1500);
        manager.addItem(frodo, boots, item -> System.out.println("Были добавлены " + item.getName()));

        System.out.println(frodo.getItemList());

        manager.updateItem(frodo, (item) -> item.getName().equals("Nike"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo.getItemList());
    }
}
