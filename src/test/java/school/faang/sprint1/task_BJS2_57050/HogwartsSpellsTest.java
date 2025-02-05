package school.faang.sprint1.task_BJS2_57050;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HogwartsSpellsTest {
    private static final int MIN_ID = 0;
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    public void setUp() {
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    public void addSpellEvent_RightParam() {
        assertDoesNotThrow(
                () -> hogwartsSpells.addSpellEvent("Защита", "Защищает от атак"));
    }

    @Test
    public void addSpellEvent_emptyEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("", "Защищает от атак"));
    }

    @Test
    public void addSpellEvent_nullEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent(null, "Защищает от атак"));
    }

    @Test
    public void addSpellEvent_emptyActionDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("Защита", ""));
    }

    @Test
    public void addSpellEvent_nullActionDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent("Защита", null));
    }


    @Test
    public void getSpellEventById_wrongId() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventById(MIN_ID - 1));
    }

    @Test
    public void getSpellEventById_boundOfId() {
        assertNull(hogwartsSpells.getSpellEventById(MIN_ID));
    }

    @Test
    public void getSpellEventById_findSpellEvent() {
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        assertNotNull(hogwartsSpells.getSpellEventById(MIN_ID));
    }

    @Test
    public void getSpellEventsByType_emptyEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventsByType(""));
    }

    @Test
    public void getSpellEventsByType_nullEventType() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.getSpellEventsByType(null));
    }

    @Test
    public void getSpellEventsByType_findSpellEvents() {
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        assertNotNull(hogwartsSpells.getSpellEventsByType("Защита"));
    }

    @Test
    public void deleteSpellEvent_wrongId() {
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.deleteSpellEvent(MIN_ID - 1));
    }

    @Test
    public void deleteSpellEvent_delete() {
        hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        assertNotNull(hogwartsSpells.getSpellEventById(MIN_ID));
        hogwartsSpells.deleteSpellEvent(MIN_ID);
        assertNull(hogwartsSpells.getSpellEventById(MIN_ID));
    }

    @Test
    public void printAllSpellEvents_checkDoesNotThrow() {
        assertDoesNotThrow(() -> hogwartsSpells.printAllSpellEvents());
    }

}