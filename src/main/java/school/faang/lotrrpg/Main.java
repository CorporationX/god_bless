package school.faang.lotrrpg;

public class Main {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item elfRing = new Item("Elf Ring", 1000);

        InventoryManager manager = new InventoryManager();


        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, elfRing, item -> System.out.println(item.getName() + " У Фродо теперь два кольца!"));

        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> System.out.println(item.getName() + " был удален из инвентаря."));
        manager.removeItem(frodo, item -> item.getName().equals("Elf Ring"), item -> System.out.println(
                "Вернул кольцо Галадриэль."
        ));


        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " снова добавлен."));

        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> {
                    item.setValue(item.getValue() * 2);
                    System.out.println(item.getName() + " обновлен. Новая стоимость: " + item.getValue());
                });


        frodo.getInventory();
        for (Item item : frodo.getInventory()) {
            if (item != null) {
                System.out.println(item.getName() + ": " + item.getValue());
            }
        }
    }
}
