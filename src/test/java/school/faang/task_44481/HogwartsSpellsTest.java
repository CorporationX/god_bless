package school.faang.task_44481;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HogwartsSpellsTest {
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    void setUp() {
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    void testAddSpellEventWithNormalInput() {
        int inputId = 1;
        String inputEventType = "Чар";
        String inputAction = "Зачаровывает предмет";

        SpellEvent expected = new SpellEvent(inputId, inputEventType, inputAction);

        hogwartsSpells.addSpellEvent(inputId, inputEventType, inputAction);
        SpellEvent spellEventByIdResult = hogwartsSpells.getSpellEventById(inputId);
        List<SpellEvent> spellsByTypeResult = hogwartsSpells.getSpellsByType(inputEventType);

        assertNotNull(spellEventByIdResult);
        assertEquals(expected, spellEventByIdResult);

        assertNotNull(spellsByTypeResult);
        assertTrue(spellsByTypeResult.contains(expected), "spellsByTypeResult must contain expectedElement");
    }

    @Test
    void testAddSpellEventWithNullInput() {
        int inputId = 0;
        String inputEventType = null;
        String inputAction = null;

        assertThrows(NullPointerException.class,
                () -> hogwartsSpells.addSpellEvent(inputId, inputEventType, inputAction));
    }

    @Test
    void getSpellsByType() {
        hogwartsSpells.addSpellEvent(3, "Защита", "Щит");
        hogwartsSpells.addSpellEvent(4, "Защита", "Стена");

        List<SpellEvent> defenseSpells = hogwartsSpells.getSpellsByType("Защита");
        assertNotNull(defenseSpells);
        assertEquals(2, defenseSpells.size(), "Defense spells list should contain two events");
    }

    @Test
    void testDeleteSpellEvent() {
        hogwartsSpells.addSpellEvent(5, "Лечение", "Частичное лечение");

        hogwartsSpells.deleteSpellEvent(5);

        assertNull(hogwartsSpells.getSpellEventById(5), "Spell event should be null after deletion");
        List<SpellEvent> healingSpells = hogwartsSpells.getSpellsByType("Лечение");
        assertTrue(healingSpells == null || healingSpells.isEmpty(),
                "Healing spells list should be empty after deletion");
    }

    @Test
    void testDeleteNonExistingSpellEvent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hogwartsSpells.deleteSpellEvent(99));

        assertEquals("No spell event with id 99 found", exception.getMessage(), "Exception message should match");
    }
}