package school.faang.task_44522;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.put(spellEvent.getEventType(), new ArrayList<>());
        spellsByType.get(spellEvent.getEventType()).add(spellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> listEvent = spellsByType.get(spellEvent.getEventType());
            if (listEvent != null) {
                listEvent.remove(spellEvent);
                if (listEvent.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public static void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue().getId() + " " + entry.getValue().getEventType() + " "
                    + entry.getValue().getAction());
        }
    }
}

