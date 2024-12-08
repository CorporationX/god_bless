package school.faang.sprint1.bjs_44553;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HogwartsSpells {
    private final HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private final HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        if (!spellById.containsKey(id)) {
            SpellEvent newEvent = new SpellEvent(id, eventType, actionDescription);
            spellById.put(id, newEvent);
            spellsByType.computeIfAbsent(eventType, event -> new ArrayList<>()).add(newEvent);
        } else {
            System.out.printf("Event with id=%d already exists", id);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent eventForRemove = spellById.remove(id);
        if (eventForRemove != null) {
            String eventType = eventForRemove.getEventType();
            List<SpellEvent> eventsList = spellsByType.get(eventType);
            eventsList.remove(eventForRemove);
            if (eventsList.isEmpty()) {
                spellsByType.remove(eventType);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var pair : spellById.entrySet()) {
            int id = pair.getKey();
            SpellEvent event = pair.getValue();
            System.out.printf("ID: %d, EventType: %s, Description: %s%n",
                    id, event.getEventType(), event.getAction());
        }
    }
}
