package school.faang.sprint1.task_44561;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();


    static public boolean addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        if (!spellsByType.containsKey(spellEvent.getEventType())) {
            spellsByType.put(spellEvent.getEventType(), new LinkedList<>());
        } else if (spellsByType.get(spellEvent.getEventType()).contains(spellEvent)) {
            System.out.println("Такое заклинание уже существует");
            return false;
        }
        spellsByType.get(spellEvent.getEventType()).add(spellEvent);
        return true;
    }

    public static SpellEvent getSpellEventById(int id) {
        SpellEvent responseEvent = spellById.get(id);

        if (responseEvent == null) {
            throw new NoSuchElementException("Такого заклинания не существует");
        }
        return responseEvent;
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> responseEvents = spellsByType.get(eventType);

        if (responseEvents == null) {
            throw new NoSuchElementException("Заклинаний этого типа не существует");
        }
        return responseEvents;
    }

    public static boolean deleteSpellEvent(int id) {
        try {
            spellsByType.get(getSpellEventById(id).getEventType()).remove(getSpellEventById(id));
            spellById.remove(id, getSpellEventById(id));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent);
        }
    }
}
