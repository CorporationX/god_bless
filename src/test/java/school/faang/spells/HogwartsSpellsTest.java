package school.faang.spells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static school.faang.spells.EventType.charm;
import static school.faang.spells.EventType.protection;
import static school.faang.spells.EventType.transfiguration;

class HogwartsSpellsTest {

    private final HogwartsSpells hogwartsSpells = new HogwartsSpells();
    private SpellEvent spellEventProtection;
    private SpellEvent spellEventTransfiguration;
    private SpellEvent spellEventCharm;

    @BeforeEach
    void beforeEach() {
        spellEventProtection = hogwartsSpells.addSpellEvent(protection, "protects from attacks");
        spellEventTransfiguration = hogwartsSpells.addSpellEvent(transfiguration, "transform vine to water");
        spellEventCharm = hogwartsSpells.addSpellEvent(charm, "charms opponent");
    }


    @Test
    void testAddSpell() {
        Assertions.assertEquals(new SpellEvent(0, protection, "protects from attacks"), spellEventProtection);
    }

    @Test
    void testGetSpellEventById() {
        Optional<SpellEvent> foundSpell = hogwartsSpells.getSpellEventById(10);
        Assertions.assertTrue(foundSpell.isEmpty());

        foundSpell = hogwartsSpells.getSpellEventById(0);
        Assertions.assertEquals(foundSpell.get(), spellEventProtection);
    }

    @Test
    void testGetSpellEventsByType() {
        SpellEvent spellEventProtection2 = hogwartsSpells.addSpellEvent(protection, "protects from yourself");

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType(protection);

        Assertions.assertTrue(spellEvents.containsAll(List.of(spellEventProtection, spellEventProtection2)));
        Assertions.assertFalse(spellEvents.contains(spellEventTransfiguration));
        Assertions.assertFalse(spellEvents.contains(spellEventCharm));
    }

    @Test
    void testDeleteSpell() {
        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType(charm);
        Assertions.assertTrue(spellEvents.containsAll(List.of(spellEventCharm)));

        hogwartsSpells.deleteSpellEvent(spellEventCharm.getId());
        spellEvents = hogwartsSpells.getSpellEventsByType(charm);
        Assertions.assertNull(spellEvents);

        Optional<SpellEvent> foundSpell = hogwartsSpells.getSpellEventById(spellEventCharm.getId());
        Assertions.assertTrue(foundSpell.isEmpty());
    }
}