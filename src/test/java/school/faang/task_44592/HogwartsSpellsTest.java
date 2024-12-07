package school.faang.task_44592;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HogwartsSpellsTest {
    private static final int VALID_ID = 1;
    private static final int INVALID_ID = 2;
    private final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    @Test
    void testAddSuccessSpellEvent() {
        assertDoesNotThrow(
            () -> hogwartsSpells.addSpellEvent(1, "Огненный шар", "Наносит урон")
        );
    }

    @Test
    void testAddFailSpellEvent() {
        assertThrows(
            IllegalArgumentException.class,
            () -> hogwartsSpells.addSpellEvent(VALID_ID, "", "Наносит урон")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> hogwartsSpells.addSpellEvent(VALID_ID, null, "Наносит урон")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "  ")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", null)
        );
    }

    @Test
    void testGetSuccessSpellEventById() {
        hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "Наносит урон");
        assertNotNull(hogwartsSpells.getSpellEventById(1));
    }

    @Test
    void testGetFailSpellEventById() {
        hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "Наносит урон");
        assertNull(hogwartsSpells.getSpellEventById(INVALID_ID));
    }

    @Test
    void testGetSuccessSpellEventsByType() {
        hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "Наносит урон");
        hogwartsSpells.addSpellEvent(3, "Щит", "Защищает от урона");
        hogwartsSpells.addSpellEvent(43, "Щит", "Защищает от магического урона");

        assertEquals(2, hogwartsSpells.getSpellEventsByType("Щит").size());
    }

    @Test
    void testGetSpellEventsByTypeWithNonExistingEventType() {
        hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "Наносит урон");

        assertNull(hogwartsSpells.getSpellEventsByType("Удар"));
    }

    @Test
    void testSuccessDeleteSpellEvent() {
        hogwartsSpells.addSpellEvent(VALID_ID, "Огненный шар", "Наносит урон");
        hogwartsSpells.addSpellEvent(4, "Огненный шар", "Наносит магический урон");
        hogwartsSpells.addSpellEvent(9, "Заморозка", "Обездвиживает противника");


        assertDoesNotThrow(() -> hogwartsSpells.deleteSpellEvent(VALID_ID));
        assertDoesNotThrow(() -> hogwartsSpells.deleteSpellEvent(INVALID_ID));

        assertDoesNotThrow(() -> hogwartsSpells.deleteSpellEvent(9));
        hogwartsSpells.printAllSpellEvents();
    }
}