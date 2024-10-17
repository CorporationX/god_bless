package school.faang.lor.rpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Character legolas = new Character("Legolas");

        Item ring = new Item("The One Ring", 1000);
        Item cloak = new Item("Elven cloak", 200);
        Item bow = new Item("Bow of Legolas", 350);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(legolas, cloak, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(legolas, bow, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.updateItem(legolas, (item) -> item.getName().equals("Bow of Legolas"), (item) -> new Item(item.getName(), item.getValue() * 3));

// Проверяем результат
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        legolas.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
