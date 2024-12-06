package school.faang.sprint1.task_44561;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private static final Map<Integer, SpellEvent> SPELL_BY_ID = new HashMap<>();
    private static final Map<String, List<SpellEvent>> SPELLS_BY_TYPE = new HashMap<>();

    public static boolean addSpellEvent(Integer id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        SPELL_BY_ID.put(id, spellEvent);

        SPELLS_BY_TYPE.putIfAbsent(eventType, new LinkedList<>());
        if (SPELLS_BY_TYPE.get(eventType).contains(spellEvent)) {
            System.out.println("Такое заклинание уже существует");
            return false;
        }
        SPELLS_BY_TYPE.get(eventType).add(spellEvent);
        return true;
    }

    public static SpellEvent getSpellEventById(Integer id) {
        SpellEvent responseEvent = SPELL_BY_ID.get(id);

        if (responseEvent == null) {
            throw new NoSuchElementException("Такого заклинания не существует");
        }
        return responseEvent;
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> responseEvents = SPELLS_BY_TYPE.get(eventType);

        if (responseEvents == null) {
            throw new NoSuchElementException("Заклинаний этого типа не существует");
        }
        return responseEvents;
    }

    public static boolean deleteSpellEvent(Integer id) {
        try {
            SPELLS_BY_TYPE.get(getSpellEventById(id).getEventType()).remove(getSpellEventById(id));
            SPELL_BY_ID.remove(id, getSpellEventById(id));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : SPELL_BY_ID.entrySet()) {
            System.out.println(spellEvent);
        }
    }
}
