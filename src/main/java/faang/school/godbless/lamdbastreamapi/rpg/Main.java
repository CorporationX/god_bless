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
                (item) -> System.out.println(item.name() + " было добавлено в инвентарь")
        );
        inventoryManager.addItem(
                frodo,
                sword,
                (item) -> System.out.println(item.name() + " успешно добавлен в инвентарь")
        );
        inventoryManager.addItem(
                frodo,
                armor,
                (item) -> System.out.println(item.name() + " получен персонажем")
        );
        System.out.println(frodo);

        inventoryManager.removeItem(frodo, (item) -> item.value() > 500);
        System.out.println(frodo);

        inventoryManager.updateItem(
                frodo,
                (item) -> item.value() == 500,
                (item) -> new Item(item.name(), item.value() + 100)
        );
        System.out.println(frodo);
    }
}
