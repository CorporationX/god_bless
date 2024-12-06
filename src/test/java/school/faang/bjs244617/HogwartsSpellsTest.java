package school.faang.bjs244617;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs244617.spells.SpellsData;

import java.util.List;

public class HogwartsSpellsTest {
    private HogwartsSpells hogwartsSpells;

    @BeforeEach
    public void setUp() {
        hogwartsSpells = new HogwartsSpells();
    }

    @Test
    public void testGetSpellEventById() {
        SpellsData data = SpellsData.CHARMS;
        hogwartsSpells.addSpellEvent(data.getId(), data.getEventType());

        SpellEvent event = hogwartsSpells.getSpellEventById(data.getId());
        Assertions.assertEquals(new SpellEvent(1, SpellEvent.SpellType.CHARMS), event);
    }

    @Test
    public void testGetSpellEventsByType() {
        SpellsData data = SpellsData.CHARMS;
        hogwartsSpells.addSpellEvent(data.getId(), data.getEventType());

        List<SpellEvent> events = hogwartsSpells.getSpellEventsByType(SpellEvent.SpellType.CHARMS);
        Assertions.assertEquals(List.of(new SpellEvent(1, SpellEvent.SpellType.CHARMS)), events);
    }

    @Test
    public void testDeleteSpellEvent() {
        SpellsData data = SpellsData.CHARMS;
        hogwartsSpells.addSpellEvent(data.getId(), data.getEventType());

        hogwartsSpells.deleteSpellEvent(data.getId());
        Assertions.assertNull(hogwartsSpells.getSpellEventById(data.getId()));
    }

    @Test
    public void testPrintAllSpellEvents() {
        SpellsData data = SpellsData.CHARMS;
        hogwartsSpells.addSpellEvent(data.getId(), data.getEventType());
        hogwartsSpells.printAllSpellEvents();
    }
}
