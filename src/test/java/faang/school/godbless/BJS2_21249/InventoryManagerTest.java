package faang.school.godbless.BJS2_21249;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.BJS2_21249.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InventoryManagerTest {

    private final Character frodo = new Character("Frodo");
    private final Character sam = new Character("Sam");

    private static final List<Item> FRODO_INVENTORY_CORRECT = new ArrayList<>();
    private static final List<Item> FRODO_INVENTORY_INCORRECT = new ArrayList<>();

    private static final List<Item> SAM_INVENTORY_CORRECT = new ArrayList<>();
    private static final List<Item> SAM_INVENTORY_INCORRECT = new ArrayList<>();

    @BeforeAll
    static void init() {
        FRODO_INVENTORY_CORRECT.add(RING);

        FRODO_INVENTORY_INCORRECT.add(FOOD);
        FRODO_INVENTORY_INCORRECT.add(WATER);

        SAM_INVENTORY_CORRECT.add(FOOD);
        SAM_INVENTORY_CORRECT.add(WATER);
        SAM_INVENTORY_CORRECT.add(CLOTHES);

        SAM_INVENTORY_INCORRECT.add(RING);
        SAM_INVENTORY_INCORRECT.add(FOOD);
        SAM_INVENTORY_INCORRECT.add(CLOTHES);
    }

    @Test
    void testAddItem() {
        fillHobbitsInventoryWithInventoryManager();

        assertEquals(FRODO_INVENTORY_CORRECT, frodo.getInventory());
        assertEquals(SAM_INVENTORY_CORRECT, sam.getInventory());
    }

    @Test
    void testAddItemIncorrect() {
        fillHobbitsInventoryWithInventoryManager();

        assertNotEquals(FRODO_INVENTORY_INCORRECT, frodo.getInventory());
        assertNotEquals(SAM_INVENTORY_INCORRECT, sam.getInventory());
    }

    @Test
    void testRemoveItemCorrect() {
        frodo.setInventory(FRODO_INVENTORY_CORRECT);

        assertEquals(FRODO_INVENTORY_CORRECT, frodo.getInventory());
        INVENTORY_MANAGER.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        assertEquals(new ArrayList<>(), frodo.getInventory());

        sam.setInventory(SAM_INVENTORY_CORRECT);

        assertEquals(SAM_INVENTORY_CORRECT, sam.getInventory());
        INVENTORY_MANAGER.removeItem(sam, (item) -> item.getName().equals("Food"));
        INVENTORY_MANAGER.removeItem(sam, (item) -> item.getName().equals("Water"));
        assertEquals(List.of(WATER), sam.getInventory());
    }

    @Test
    void testRemoveItemIncorrect() {
        frodo.setInventory(FRODO_INVENTORY_CORRECT);

        assertEquals(FRODO_INVENTORY_CORRECT, frodo.getInventory());
        INVENTORY_MANAGER.removeItem(frodo, (item) -> item.getName().equals("One Ring"));
        assertNotEquals(new ArrayList<>(), frodo.getInventory());

        sam.setInventory(SAM_INVENTORY_CORRECT);

        assertEquals(SAM_INVENTORY_CORRECT, sam.getInventory());
        INVENTORY_MANAGER.removeItem(frodo, (item) -> item.getName().equals("Mantle"));
        INVENTORY_MANAGER.removeItem(frodo, (item) -> item.getName().equals("Bread"));
        assertNotEquals(List.of(CLOTHES), frodo.getInventory());
    }

    @Test
    void testUpdateItemCorrect() {
        frodo.setInventory(FRODO_INVENTORY_CORRECT);

        assertEquals(FRODO_INVENTORY_CORRECT, frodo.getInventory());
        INVENTORY_MANAGER.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> MANTLE);
        assertEquals(FRODO_INVENTORY_AFTER_UPDATE, frodo.getInventory());

        sam.setInventory(SAM_INVENTORY_CORRECT);

        assertEquals(SAM_INVENTORY_CORRECT, sam.getInventory());
        INVENTORY_MANAGER.updateItem(sam, (item) -> item.getName().equals("Food"), (item) -> BREAD);
        INVENTORY_MANAGER.updateItem(sam, (item) -> item.getName().equals("Clothes"), (item) -> SHIRT);
        assertEquals(SAM_INVENTORY_AFTER_UPDATE, sam.getInventory());
    }

    @Test
    void testUpdateItemIncorrect() {
        frodo.setInventory(FRODO_INVENTORY_CORRECT);

        assertEquals(FRODO_INVENTORY_CORRECT, frodo.getInventory());
        INVENTORY_MANAGER.updateItem(frodo, (item) -> item.getName().equals("Trousers"), (item) -> MANTLE);
        assertNotEquals(FRODO_INVENTORY_AFTER_UPDATE, frodo.getInventory());

        sam.setInventory(SAM_INVENTORY_CORRECT);

        assertEquals(SAM_INVENTORY_CORRECT, sam.getInventory());
        INVENTORY_MANAGER.updateItem(sam, (item) -> item.getName().equals("The One Ring"), (item) -> BREAD);
        INVENTORY_MANAGER.updateItem(sam, (item) -> item.getName().equals("Blanket"), (item) -> SHIRT);
        assertNotEquals(SAM_INVENTORY_AFTER_UPDATE, sam.getInventory());
    }

    private void fillHobbitsInventoryWithInventoryManager() {
        INVENTORY_MANAGER.addItem(frodo, RING, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        INVENTORY_MANAGER.addItem(sam, FOOD, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        INVENTORY_MANAGER.addItem(sam, WATER, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        INVENTORY_MANAGER.addItem(sam, CLOTHES, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    }
}