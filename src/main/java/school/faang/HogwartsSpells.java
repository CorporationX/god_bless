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

        int newId = spellById.size() + 1;
        SpellEvent spellEvent = new SpellEvent(newId, eventType, actionDescription);
        spellById.put(newId, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.getOrDefault(id, null);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            String eventType = spellEvent.getEventType();
            List<SpellEvent> spellEvents = spellsByType.get(eventType);
            spellEvents.remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
