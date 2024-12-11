package school.faang.task_45544;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000L);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("%s с стоимостью %s был добавлен в инвентарь%n",
                        item.getName(),
                        item.getValue()));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        // Добавляем обратно предмет
        manager.addItem(frodo, ring, (item) ->
                System.out.println(item.getName() + " снова добавлен."));
        // обновляем его стоимость
        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory()
                .forEach(item ->
                        System.out.println(item.getName() + ": " + item.getValue()));
    }
}
