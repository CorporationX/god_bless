package derschrank.sprint02.task05.bjstwo_45515;

public class Main {
    //Это не бизнес логика, а файл проверки. Так что комментарии, которые я скопировал из задания, я оставил для себя
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " был добавлен в инвентарь."));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));

        // Проверяем результат
        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
