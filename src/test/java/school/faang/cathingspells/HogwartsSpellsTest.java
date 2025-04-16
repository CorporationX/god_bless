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
        SpellEvent spellEvent1 = hogwartsSpells.addSpellEvent("Common",
                "Lumos for getting area lighten");
        SpellEvent spellEvent2 = hogwartsSpells.addSpellEvent("Common",
                "Reparo for getting things fixed");
        SpellEvent spellEvent3 = hogwartsSpells.addSpellEvent("Battle",
                "Expeliarmus for disarming your opponent");
        Integer id1 = spellEvent1.getId();
        Integer id2 = spellEvent2.getId();
        Integer id3 = spellEvent3.getId();

        assertEquals(1, id1);
        assertEquals(2, id2);
        assertEquals(3, id3);
        assertEquals(hogwartsSpells.getSpellById().get(id1), hogwartsSpells.getSpellEventById(id1));
    }

    @Test
    void shouldGetSpellEventsByType() {
        hogwartsSpells.addSpellEvent("Common", "Lumos for getting area lighten");
        hogwartsSpells.addSpellEvent("Common", "Reparo for getting things fixed");
        hogwartsSpells.addSpellEvent("Battle", "Expeliarmus for disarming your opponent");

        assertEquals(hogwartsSpells.getSpellEventsByType("Common"),
                hogwartsSpells.getSpellsByType().get("Common"));
    }

    @Test
    void shouldDeleteSpellEvent() {
        SpellEvent spellEvent1 = hogwartsSpells.addSpellEvent("Common",
                "Lumos for getting area lighten");
        SpellEvent spellEvent2 = hogwartsSpells.addSpellEvent("Common",
                "Reparo for getting things fixed");
        SpellEvent spellEvent3 = hogwartsSpells.addSpellEvent("Battle",
                "Expeliarmus for disarming your opponent");

        hogwartsSpells.deleteSpellEvent(spellEvent1.getId());

        assertTrue(hogwartsSpells.getSpellById().containsKey(spellEvent2.getId()));
        assertTrue(hogwartsSpells.getSpellById().containsKey(spellEvent3.getId()));
        assertFalse(hogwartsSpells.getSpellById().containsKey(spellEvent1.getId()));
    }
}