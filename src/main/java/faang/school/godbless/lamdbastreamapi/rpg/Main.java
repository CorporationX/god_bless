package faang.school.godbless.lamdbastreamapi.rpg;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character frodo = new Character("Frodo");

        Item ring = new Item("Кольцо", 100);
        Item sword = new Item("Меч", 1000);
        Item armor = new Item("Комбинезон сталкера", 500);
        inventoryManager.addItem(
                frodo,
                ring,
                (item) -> System.out.println(item.getName() + " было добавлено в инвентарь")
        );
        inventoryManager.addItem(
                frodo,
                sword,
                (item) -> System.out.println(item.getName() + " успешно добавлен в инвентарь")
        );
        inventoryManager.addItem(
                frodo,
                armor,
                (item) -> System.out.println(item.getName() + " получен персонажем")
        );
        System.out.println(frodo);

        inventoryManager.removeItem(frodo, (item) -> item.getValue() > 500);
        System.out.println(frodo);

        inventoryManager.updateItem(
                frodo,
                (item) -> item.getValue() == 500,
                (item) -> new Item(item.getName(), item.getValue() + 100)
        );
        System.out.println(frodo);
    }
}
