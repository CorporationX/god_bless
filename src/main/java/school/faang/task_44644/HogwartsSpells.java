package school.faang.task_44644;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public void getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            SpellEvent value = spellById.get(id);
            System.out.println("Getting spell by ID: " + value);
        } else {
            System.out.println("ID not found");
        }
    }

    public void getSpellEventsByType(String eventType) {
        if (spellsByType.containsKey(eventType)) {
            List<SpellEvent> events = spellsByType.getOrDefault(eventType, new ArrayList<>());
            System.out.println("Getting spell by type: " + events);
        } else {
            System.out.println("Spell not found");
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
        System.out.println("Deleted spell: " + spellEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " spell: " + entry.getValue());
        }
    }
}