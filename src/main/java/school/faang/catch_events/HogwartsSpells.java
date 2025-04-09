package school.faang.catch_events;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int id = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, newSpellEvent);
        spellByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(newSpellEvent);
        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = spellById.get(id);
        List<SpellEvent> events = spellByType.get(event.getEventType());
        if (events != null) {
            events.removeIf(e -> e.getId() == id);
            if (events.isEmpty()) {
                spellByType.remove(event.getEventType());
            }
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            Integer id = entry.getKey();
            SpellEvent spellEvent = entry.getValue();
            System.out.println("ID: " + id +
                    ", type: " + spellEvent.getEventType() +
                    ", action: " + spellEvent.getAction());
        }
    }
}