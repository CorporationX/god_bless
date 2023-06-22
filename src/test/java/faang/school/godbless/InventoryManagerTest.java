package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.provider.ValueSource;

class InventoryManagerTest {
    InventoryManager inventoryManager;
    Item ring;
    Character Frodo;


    @BeforeEach
    void setUp() {
        inventoryManager = new InventoryManager();
        ring = new Item("The One Ring", 1000);
        Frodo = new Character("Frodo");
    }
    @ParameterizedTest
    void TestAddItem() {
        inventoryManager.addItem(Frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));

    }
    @Test
    void removeItem() {


    }

    @Test
    void updateItem() {
    }
}