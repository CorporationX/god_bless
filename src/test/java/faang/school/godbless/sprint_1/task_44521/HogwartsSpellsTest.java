package faang.school.godbless.sprint_1.task_44521;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HogwartsSpellsTest {

    public static final SpellEvent SPELL_EVENT_1 = new SpellEvent(1, "Защита", "Защищает от атак");
    public static final SpellEvent SPELL_EVENT_2 = new SpellEvent(2, "Чары", "Изменяет цвет предмета");
    public static final SpellEvent SPELL_EVENT_3 = new SpellEvent(3, "Трансфигурация", "Изменяет цвет волос");

    public static final SpellEvent SPELL_EVENT_4 = new SpellEvent(4, "Чары", "Заставляет объект левитировать");
    public static final SpellEvent SPELL_EVENT_5 = new SpellEvent(5, "Трансфигурация", "Делает старше");

    public static final Map<Integer, SpellEvent> SPELL_BY_ID_MAP = new HashMap<>();
    public static final Map<String, List<SpellEvent>> SPELL_BY_TYPE_MAP = new HashMap<>();

    public static final HogwartsSpells HOGWARTS_SPELLS = new HogwartsSpells();

    @BeforeAll
    static void init() {
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_1.getId(), SPELL_EVENT_1.getEventType(), SPELL_EVENT_1.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_2.getId(), SPELL_EVENT_2.getEventType(), SPELL_EVENT_2.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_3.getId(), SPELL_EVENT_3.getEventType(), SPELL_EVENT_3.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_4.getId(), SPELL_EVENT_4.getEventType(), SPELL_EVENT_4.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_5.getId(), SPELL_EVENT_5.getEventType(), SPELL_EVENT_5.getAction());

        SPELL_BY_ID_MAP.put(1, SPELL_EVENT_1);
        SPELL_BY_ID_MAP.put(2, SPELL_EVENT_2);
        SPELL_BY_ID_MAP.put(3, SPELL_EVENT_3);
        SPELL_BY_ID_MAP.put(4, SPELL_EVENT_4);
        SPELL_BY_ID_MAP.put(5, SPELL_EVENT_5);

        List<SpellEvent> protectionSpellEvents = new ArrayList<>();
        protectionSpellEvents.add(SPELL_EVENT_1);
        SPELL_BY_TYPE_MAP.put("Защита", protectionSpellEvents);

        List<SpellEvent> charmSpellEvents = new ArrayList<>();
        charmSpellEvents.add(SPELL_EVENT_2);
        charmSpellEvents.add(SPELL_EVENT_4);
        SPELL_BY_TYPE_MAP.put("Чары", charmSpellEvents);

        List<SpellEvent> transfigurationSpellEvents = new ArrayList<>();
        transfigurationSpellEvents.add(SPELL_EVENT_3);
        transfigurationSpellEvents.add(SPELL_EVENT_5);
        SPELL_BY_TYPE_MAP.put("Трансфигурация", transfigurationSpellEvents);
    }

    @Test
    public void testAddSpellEvent() {
        assertEquals(SPELL_BY_ID_MAP, HOGWARTS_SPELLS.getSpellById());
        assertEquals(SPELL_BY_TYPE_MAP, HOGWARTS_SPELLS.getSpellsByType());
    }

    @Test
    public void testGetSpellEventById() {
        assertEquals(SPELL_EVENT_3, HOGWARTS_SPELLS.getSpellEventById(3));
        assertNull(HOGWARTS_SPELLS.getSpellEventById(6));
    }

    @Test
    public void testGetSpellEventsByType() {
        assertEquals(SPELL_BY_TYPE_MAP.get("Трансфигурация"), HOGWARTS_SPELLS.getSpellEventsByType("Трансфигурация"));
    }

    @Test
    public void testDeleteSpellEvent() {
        SPELL_BY_ID_MAP.remove(2);
        SPELL_BY_TYPE_MAP.get("Чары").remove(SPELL_EVENT_2);
        HOGWARTS_SPELLS.deleteSpellEvent(2);
        assertEquals(SPELL_BY_ID_MAP, HOGWARTS_SPELLS.getSpellById());
        assertEquals(SPELL_BY_TYPE_MAP, HOGWARTS_SPELLS.getSpellsByType());
    }
}
