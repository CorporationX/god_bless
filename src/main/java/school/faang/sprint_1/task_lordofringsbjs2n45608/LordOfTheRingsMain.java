package school.faang.sprint_1.task_lordofringsbjs2n45608;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LordOfTheRingsMain {
    public static void main(String[] args) {
        Logger mainLogger = LoggerFactory.getLogger("mainLogger");

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item book = new Item("Magic book", 500);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> mainLogger.info("{} был добавлен в инвентарь.", item.getName()));
        manager.addItem(frodo, book, (item) -> mainLogger.info("{} был добавлен в инвентарь.", item.getName()));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        mainLogger.info("The One Ring пытались удалить из инвентаря {}", frodo.getName());
        mainLogger.info(frodo.toString());

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> mainLogger.info("{} снова добавлен.", item.getName()));
        mainLogger.info(frodo.toString());
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        // Проверяем результат
        frodo.getInventory().forEach(item -> mainLogger.info("{} : {}", item.getName(), item.getValue()));
    }
}
