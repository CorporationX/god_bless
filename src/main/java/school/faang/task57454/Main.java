package school.faang.task57454;

import school.faang.task57454.service.Character;
import school.faang.task57454.service.InventoryManager;
import school.faang.task57454.service.Item;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Фродо");
        Item ring = new Item("Кольцо", 1000);

        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    }
}
