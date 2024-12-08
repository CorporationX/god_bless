package school.faang.task_44609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();

    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();


    public void addSpellEvent(int id, String eventType, String actionDescription) {
        if (eventType == null || eventType.isEmpty()) {
            throw new IllegalArgumentException("Event type cannot be null or empty");
        }
        if (actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException("Action description cannot be null or empty");
        }
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, newSpellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(newSpellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
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
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
