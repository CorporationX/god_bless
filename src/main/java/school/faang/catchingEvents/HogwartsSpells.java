package school.faang.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Random random = new Random();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Event type or action description cannot be empty");
        }

        int eventId = random.nextInt(1, 99999);
        SpellEvent spellEvent = new SpellEvent(eventId, eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(spellEvent.getEventType(), value -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Id " + id + " was not found.");
        }

        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("No spell event with type " + eventType);
        }

        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id <= 1 || !spellById.containsKey(id)) {
            throw new IllegalArgumentException("Id " + id + " was not found.");
        }

        spellsByType.remove(spellById.get(id).getEventType());
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(String.format("ID %s, is type %s, is action %s",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getAction()));
        }
    }
}