package school.faang.sprint2.task_57076;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class HogwartsSpells {
    private Map<UUID, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Event type cant be empty or null");
        } else if (actionDescription == null || actionDescription.isBlank()) {
            throw new IllegalArgumentException("Action description type cant be empty or null");
        }
        UUID id = UUID.randomUUID();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(UUID id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(UUID id) {
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
            var value = entry.getValue();
            System.out.printf("Id: " + value.getId() + "\nEvent Type: %s \nAction: %s\n\n",
                    value.getEventType(), value.getAction());
        }
    }
}
