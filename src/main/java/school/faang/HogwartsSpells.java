package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null) {
            throw new IllegalArgumentException("EventType is required!");
        }
        if (actionDescription == null) {
            throw new IllegalArgumentException("ActionDescription is required!");
        }

        SpellEvent spellEvent = new SpellEvent(spellById.size() + 1, eventType, actionDescription);
        spellById.put(spellById.size() + 1, spellEvent);
        if (spellsByType.containsKey(eventType)) {
            spellsByType.get(eventType).add(spellEvent);
        } else {
            spellsByType.put(eventType, new ArrayList<>());
        }
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            System.out.println("SpellEvent with id = " + id + "was not found!");
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        if (spellEvents == null) {
            System.out.println("SpellEvents with type = " + eventType + " + was not found!");
        }
        return spellEvents;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent != null) {
            String eventType = spellEvent.getEventType();
            List<SpellEvent> spellEvents = spellsByType.get(eventType);
            spellEvents.remove(spellEvent);
            spellById.remove(id);
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
