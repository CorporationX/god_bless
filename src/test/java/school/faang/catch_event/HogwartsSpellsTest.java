package school.faang.catch_event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HogwartsSpellsTest {
    private HogwartsSpells hogwartsSpells;
    private SpellEvent spellEvent;

    @BeforeEach
    public void setUp() {
        hogwartsSpells = new HogwartsSpells();
        String eventType = "lumos";
        String action = "shine bright like a dymond";
        spellEvent = hogwartsSpells.addSpellEvent(eventType, action);
    }

    @Test
    public void testAddSpellEvent() {
        String eventType = "bombardo";
        String action = "boom";

        SpellEvent spellEvent = hogwartsSpells.addSpellEvent(eventType, action);
        assertEquals(eventType, spellEvent.getEventType());
        assertEquals(action, spellEvent.getAction());
    }

    @Test
    public void testGetSpellById() {
        SpellEvent spell = hogwartsSpells.getSpellEventById(spellEvent.getId());
        assertEquals(spellEvent, spell);
    }

    @Test
    public void testGetSpellsByType() {
        List<SpellEvent> spells = hogwartsSpells.getSpellEventsByType(spellEvent.getEventType());
        assertEquals(spellEvent, spells.get(0));
    }

    @Test
    public void testDeleteSpellEvent() {
        SpellEvent spell = hogwartsSpells.deleteSpellEvent(spellEvent.getId());
        assertEquals(spellEvent, spell);

        spell = hogwartsSpells.getSpellEventById(spellEvent.getId());
        assertNull(spell);
    }
}
