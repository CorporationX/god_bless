package school.faang.task_44635;

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
        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
        }
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new IllegalArgumentException("No spell found with this ID " + id);
        }
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        if (event != null) {
            String eventType = event.getEventType();
            spellById.remove(id);
            List<SpellEvent> events = spellsByType.get(eventType);
            if (events != null) {
                events.remove(event);
                if (events.isEmpty()) {
                    spellsByType.remove(eventType);
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            int id = entry.getKey();
            SpellEvent spellEvent = entry.getValue();
            String eventType = spellEvent.getEventType();
            String action = spellEvent.getAction();
            System.out.println("ID: " + id + " Type: " + eventType + " Action: " + action);
        }
    }
}
