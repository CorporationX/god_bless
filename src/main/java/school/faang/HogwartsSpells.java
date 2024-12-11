package school.faang;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class HogwartsSpells {
    static Map<Integer, SpellEvent> spellById = new HashMap<>();
    static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public static void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
        System.out.println("Событие " + spellEvent + " было добавлено в Map.");
    }

    public static SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public static List<SpellEvent> getSpellEventsType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public static void printAllSpellEvents() {
        System.out.println("\nВсе события заклинаний, которые есть в Map:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
