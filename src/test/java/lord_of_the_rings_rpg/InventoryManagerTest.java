package lord_of_the_rings_rpg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private final List<Item> INVENTORY = new ArrayList<>();
    private final Character FRODO = new Character(INVENTORY);
    private final Item RING = new Item("The One Ring", 1);
    private final Item SWORD = new Item("The Sword of Frodo", 2);
    private final Item BOW = new Item("The Battle Bow of Frodo", 3);
    private final InventoryManager MANAGER = new InventoryManager();

    @BeforeEach
    void setUp() {
        MANAGER.addItem(FRODO, SWORD, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        MANAGER.addItem(FRODO, BOW, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    }

    @AfterEach
    void tearDown() {
        INVENTORY.clear();
    }

    @Test
    void addItem() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        MANAGER.addItem(FRODO, RING, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        assertEquals("The One Ring был добавлен в инвентарь.\n", outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void removeItem() {
        MANAGER.removeItem(FRODO, (item) -> item.getName().equals("The Battle Bow of Frodo"));
        assertFalse(FRODO.getInventory().contains(BOW));
    }

    @Test
    void updateItem() {
        MANAGER.updateItem(FRODO, (item) -> item.getName().equals("The Sword of Frodo"), (item) -> new Item(item.getName(), item.getValue() * 10));
        assertTrue(FRODO.getInventory().contains(new Item(SWORD.getName(), SWORD.getValue() * 10)));
    }
}