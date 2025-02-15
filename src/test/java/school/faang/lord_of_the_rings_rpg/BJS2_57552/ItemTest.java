package school.faang.lord_of_the_rings_rpg.BJS2_57552;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {
    private Item sword;

    @BeforeEach
    void testSetUp() {
        sword = new Item("Sword", 50000);
    }

    @Test
    void testGetName() {
        assertEquals("Sword", sword.getName());
    }

    @Test
    void testGetValue() {
        assertEquals(50000, sword.getValue());
    }

    @Test
    void testSetValue() {
        sword.setValue(sword.getValue() + 1);
        assertEquals(50000 + 1, sword.getValue());
    }
}