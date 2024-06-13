package faang.school.godbless.lotr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryManagerTest {

    Character frodo;
    Item ring;
    InventoryManager manager;

    @BeforeEach
    void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        manager = new InventoryManager();
    }

    @Test
    public void testAdd() {
// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));
    }

    @Test
    public void testRemove() {
// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));
        manager.addItem(frodo, new Item("Stick", 1), (item) -> System.out.println(item.name() + " was added to the inventory."));
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));
        System.out.println(frodo.getInventory().toString());
    }

    @Test
    public void testUpdate() {
// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));
// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"), (item) -> new Item(item.name(), item.value() * 2));
        System.out.println(frodo.getInventory().toString());
    }
}