package school.faang.sprint_1.task_lordofringsbjs2n45608;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LordOfTheRingsMain {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item book = new Item("Magic book", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> log.info("{} был добавлен в инвентарь.", item.getName()));
        manager.addItem(frodo, book, (item) -> log.info("{} был добавлен в инвентарь.", item.getName()));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        log.info("The One Ring пытались удалить из инвентаря {}", frodo.getName());
        log.info(frodo.toString());

        manager.addItem(frodo, ring, (item) -> log.info("{} снова добавлен.", item.getName()));
        log.info(frodo.toString());
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> log.info("{} : {}", item.getName(), item.getValue()));
    }
}
