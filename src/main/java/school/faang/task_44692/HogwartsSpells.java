package school.faang.task_44692;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        if (!(spellsByType.containsKey(eventType))) {
            spellsByType.put(eventType, new LinkedList<>());
        }
        spellsByType.get(eventType).add(spellEvent);
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public static void deleteSpellEvent(int id) {
        String eventType = spellById.get(id).eventType;
        spellsByType.get(eventType).remove(spellById.get(id));
        spellById.remove(id);
    }

    public static void prinAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
