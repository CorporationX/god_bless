package faang.school.godbless.sprint3.task14;

import faang.school.godbless.sprint3.lambda.task14.Character;
import faang.school.godbless.sprint3.lambda.task14.InventoryManager;
import faang.school.godbless.sprint3.lambda.task14.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private Character frodo;
    private Item ring;
    private InventoryManager manager;

    @BeforeEach
    void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        manager = new InventoryManager();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void setOut() {
        System.setOut(originalOut);
    }

    @Test
    void addItem() {
        String expected = "The One Ring was added to the inventory.\r\n";

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertEquals(expected, outContent.toString());
    }

    @Test
    void removeItem() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        boolean actual = false;
        for (Item item : frodo.getInventory()) {
            if (item.getName().equals("The One Ring")) {
                actual = true;
            }
        }
        assertFalse(actual);
    }

    @Test
    void updateItem() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        boolean actual = false;
        for (Item item : frodo.getInventory()) {
            if (item.getName().equals("The One Ring") && item.getValue() == 2000) {
                actual = true;
            }
        }
        assertTrue(actual);
    }

    @Test
    void testValidationAddItemIsNull() {
        assertThrows(IllegalArgumentException.class, () -> manager.addItem(null, ring, null));
        assertThrows(IllegalArgumentException.class, () -> manager.addItem(frodo, null, null));
        assertThrows(NullPointerException.class, () -> manager.addItem(frodo, ring, null));
    }

    @Test
    void testValidationRemoveItemIsNull() {
        assertThrows(IllegalArgumentException.class, () -> manager.removeItem(null, null));
        assertThrows(NullPointerException.class, () -> manager.removeItem(frodo, null));
    }

    @Test
    void testValidationUpdateItemIsNull() {
        assertThrows(IllegalArgumentException.class, () -> manager.updateItem(null, null, null));
        assertThrows(NullPointerException.class, () -> manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), null));
        assertThrows(NullPointerException.class, () -> manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), null));
    }
}