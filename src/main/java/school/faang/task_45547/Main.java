package school.faang.task_45547;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> logger.info("{} был добавлен в инвентарь.", item.name()));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> logger.info("{} снова добавлен.", item.name()));
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));

        // Проверяем результат
        frodo.getInventory().forEach(item -> logger.info("{}: {}", item.name(), item.value()));
    }

}
