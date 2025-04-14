package school.faang.catchevents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HogwartsSpellsTest {
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    void setUp() {
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    void shouldAddSpellEvent() {
        SpellEvent spellEvent = hogwartsSpells.addSpellEvent("Defence", "Fire spell defence");

        assertTrue(hogwartsSpells.getSpellById().containsKey(spellEvent.getId()));
        assertEquals(hogwartsSpells.getSpellById().get(spellEvent.getId()), spellEvent);
        assertTrue(hogwartsSpells.getSpellsByType().containsKey(spellEvent.getEventType()));
        assertTrue(hogwartsSpells.getSpellsByType().get(spellEvent.getEventType()).contains(spellEvent));
    }

    @Test
    void shouldGetSpellEventById() {
        SpellEvent addedSpellEvent = hogwartsSpells.addSpellEvent("Defence", "Fire spell defence");

        SpellEvent foundSpellEvent = hogwartsSpells.getSpellEventById(addedSpellEvent.getId());

        assertNotNull(foundSpellEvent);
    }

    @Test
    void shouldGetSpellEventsByType() {
        SpellEvent addedSpellEvent = hogwartsSpells.addSpellEvent("Defence", "Fire spell defence");

        List<SpellEvent> foundSpellEvents = hogwartsSpells.getSpellEventsByType(addedSpellEvent.getEventType());

        assertFalse(foundSpellEvents.isEmpty());
        assertTrue(foundSpellEvents.contains(addedSpellEvent));
    }

    @Test
    void shouldDeleteSpellEvent() {
        SpellEvent addedSpellEvent = hogwartsSpells.addSpellEvent("Defence", "Fire spell defence");

        boolean isDeleted = hogwartsSpells.deleteSpellEvent(addedSpellEvent.getId());

        assertTrue(isDeleted);
        assertFalse(hogwartsSpells.getSpellById().containsKey(addedSpellEvent.getId()));
        assertTrue(hogwartsSpells.getSpellsByType().containsKey(addedSpellEvent.getEventType()));
        assertFalse(hogwartsSpells.getSpellsByType().get(addedSpellEvent.getEventType()).contains(addedSpellEvent));
    }
}