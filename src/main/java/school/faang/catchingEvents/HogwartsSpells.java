package school.faang.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int eventId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Event type or action description cannot be empty");
        }

        SpellEvent spellEvent = new SpellEvent(eventId++, eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(), value -> new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Id " + id + " was not found.");
        }

        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.printf("ID %s, is type %s, is action %s%n",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction());
        }
    }
}