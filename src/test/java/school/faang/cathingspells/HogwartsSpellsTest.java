package school.faang.cathingspells;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HogwartsSpellsTest {
    HogwartsSpells hogwartsSpells;

    @BeforeEach
    void setUp() {
        this.hogwartsSpells = new HogwartsSpells();
    }

    @Test
    void shouldAddSpellEvent() {
        SpellEvent spellEvent = hogwartsSpells.addSpellEvent("Common",
                "Lumos for getting area lighten");

        assertTrue(hogwartsSpells.getSpellsByType().containsKey("Common"));
        assertTrue(hogwartsSpells.getSpellById().containsKey(spellEvent.getId()));
    }

    @Test
    void shouldGetSpellEventById() {
        SpellEvent spellEvent = hogwartsSpells.addSpellEvent("Common",
                "Lumos for getting area lighten");
        Integer id = spellEvent.getId();

        assertEquals(hogwartsSpells.getSpellById().get(id), spellEvent);
    }

    @Test
    void shouldGetSpellEventsByType() {

    }

    @Test
    void shouldDeleteSpellEvent() {
    }
}