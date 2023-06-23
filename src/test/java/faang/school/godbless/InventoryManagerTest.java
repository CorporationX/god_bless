package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagerTest {
    InventoryManager inventoryManager;
    Character Frodo;

    @BeforeEach
    void setUp() {
        inventoryManager = new InventoryManager();
        Frodo = new Character("Frodo");
    }

    @ParameterizedTest
    @CsvSource({
            "Ring, 1000",
            "Sword, 700",
            "Shield, 550"
    })
    void TestAddItem(String name, int value) {
        Item item = new Item(name, value);
        inventoryManager.addItem(Frodo, item, (thing) -> System.out.println(thing.name() + " was added to the inventory."));
        assertEquals(Frodo.getInventory().get(0), item);
    }

    @ParameterizedTest
    @CsvSource({
            "Ring, 1100, 1",
            "Sword, 700, 0",
            "Shield, 550, 0"
    })
    void removeItem(String name, int value, int expectedLength) {
        Item thing = new Item(name, value);
        Frodo.getInventory().add(thing);

        inventoryManager.removeItem(Frodo, (item -> item.value() < 1000));

        assertEquals(Frodo.getInventory().size(), expectedLength);
    }

    @ParameterizedTest
    @CsvSource({
            "Ring1, 100, Ring2, 1100",
            "Sword1, 700, Sword1, 7000",
            "Shield1, 550, Shield2, 5500"
    })
    void updateItem(String firstName, int firstValue, String secondName, int secondValue) {
        Frodo.getInventory().add(new Item(firstName, firstValue));
        Frodo.getInventory().add(new Item(secondName, secondValue));

        inventoryManager.updateItem(Frodo, item -> item.value() > 1000, item -> new Item(item.name(), item.value() - 1000));

        assertEquals(Frodo.getInventory().get(1).value(), secondValue - 1000);
    }
}