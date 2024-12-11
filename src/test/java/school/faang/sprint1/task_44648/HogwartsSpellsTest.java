package school.faang.sprint1.task_44648;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static school.faang.sprint1.task_44648.SpellEvent.EventTypes.CHARM;
import static school.faang.sprint1.task_44648.SpellEvent.EventTypes.PROTECTION;

public class HogwartsSpellsTest {

    private final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    @BeforeEach
    public void setUp() {
        hogwartsSpells.clearAll();
    }

    @Test
    public void testAddSpellEvent() {
        SpellEvent eventToAdd = new SpellEvent(1, CHARM, "This charm is bad!");
        hogwartsSpells.addSpellEvent(1, CHARM, "This charm is bad!");
        assertEquals(eventToAdd, hogwartsSpells.getSpellEventById(1));
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent(1, CHARM, "This charm is awesome!"));
        assertThrows(IllegalArgumentException.class,
                () -> hogwartsSpells.addSpellEvent(2, CHARM, "This charm is bad!"));
    }

    @Test
    public void testGetSpellEventById() {
        SpellEvent eventToAdd = new SpellEvent(1, CHARM, "This charm is bad!");
        hogwartsSpells.addSpellEvent(1, CHARM, "This charm is bad!");
        assertEquals(eventToAdd, hogwartsSpells.getSpellEventById(1));
        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.getSpellEventById(123));
    }

    @Test
    public void testGetSpellEventsByType() {
        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.getSpellEventsByType(CHARM));
        SpellEvent charm1 = new SpellEvent(1, CHARM, "This charm is bad!");
        hogwartsSpells.addSpellEvent(1, CHARM, "This charm is bad!");
        assertEquals(List.of(charm1), hogwartsSpells.getSpellEventsByType(CHARM));

        SpellEvent charm2 = new SpellEvent(2, CHARM, "This charm is very very bad!");
        hogwartsSpells.addSpellEvent(2, CHARM, "This charm is very very bad!");
        assertEquals(List.of(charm1, charm2), hogwartsSpells.getSpellEventsByType(CHARM));

        SpellEvent protection = new SpellEvent(3, PROTECTION, "This protection is good!");
        hogwartsSpells.addSpellEvent(3, PROTECTION, "This protection is good!");
        assertEquals(List.of(protection), hogwartsSpells.getSpellEventsByType(PROTECTION));

        hogwartsSpells.deleteSpellEvent(3);

        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.getSpellEventsByType(PROTECTION));
    }

    @Test
    public void testDeleteSpellEvent() {
        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.deleteSpellEvent(123));

        hogwartsSpells.addSpellEvent(1, CHARM, "This charm is bad!");
        hogwartsSpells.deleteSpellEvent(1);
        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.getSpellEventById(1));
        assertThrows(NoSuchElementException.class, () -> hogwartsSpells.getSpellEventsByType(CHARM));
    }
}
