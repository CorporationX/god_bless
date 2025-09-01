package school.faang.spells;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class HogwartsSpellsTest {

    private final HogwartsSpells hogwartsSpells = new HogwartsSpells();

    @Test
    void testAddSpell() {
        SpellEvent spellEvent = hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        Assertions.assertEquals(new SpellEvent(0, "Защита", "Защищает от атак"), spellEvent);
    }

    @Test
    void testGetSpellEventById() {
        SpellEvent spellEvent = hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        Optional<SpellEvent> foundSpell = hogwartsSpells.getSpellEventById(1);
        Assertions.assertTrue(foundSpell.isEmpty());

        foundSpell = hogwartsSpells.getSpellEventById(0);
        Assertions.assertEquals(foundSpell.get(), spellEvent);
    }

    @Test
    void testGetSpellEventsByType() {
        SpellEvent spellEvent1 = hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        SpellEvent spellEvent2 = hogwartsSpells.addSpellEvent("Защита", "Защищает от влияния на разум");
        SpellEvent spellEvent3 = hogwartsSpells.addSpellEvent("Защита", "Защищает от одного заклятия");
        SpellEvent spellEvent4 = hogwartsSpells.addSpellEvent("Трансфигурация", "Превращает крысу в крота");

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Защита");

        Assertions.assertTrue(spellEvents.containsAll(List.of(spellEvent1, spellEvent3, spellEvent2)));
        Assertions.assertFalse(spellEvents.contains(spellEvent4));
    }

    @Test
    void testDeleteSpell() {
        SpellEvent spellEvent1 = hogwartsSpells.addSpellEvent("Защита", "Защищает от атак");
        SpellEvent spellEvent2 = hogwartsSpells.addSpellEvent("Защита", "Защищает от влияния на разум");
        SpellEvent spellEvent3 = hogwartsSpells.addSpellEvent("Защита", "Защищает от одного заклятия");
        SpellEvent spellEvent4 = hogwartsSpells.addSpellEvent("Трансфигурация", "Превращает крысу в крота");
        SpellEvent spellEvent5 = hogwartsSpells.addSpellEvent("Чары", "Завладевает разумом противника");
        SpellEvent spellEvent6 = hogwartsSpells.addSpellEvent("Чары", "Делает невидимым");

        hogwartsSpells.deleteSpellEvent(spellEvent5.getId());

        List<SpellEvent> spellEvents = hogwartsSpells.getSpellEventsByType("Чары");
        Assertions.assertFalse(spellEvents.contains(spellEvent5));
        Optional<SpellEvent> foundSpell = hogwartsSpells.getSpellEventById(spellEvent5.getId());
        Assertions.assertTrue(foundSpell.isEmpty());

        hogwartsSpells.printAllSpellEvents();
    }


}