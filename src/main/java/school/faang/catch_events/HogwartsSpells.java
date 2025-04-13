package school.faang.catch_events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    private int eventId;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
        eventId = 0;
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(++eventId, eventType, actionDescription);
        spellById.put(eventId, event);
        spellsByType.computeIfAbsent(eventType, a -> new ArrayList<>()).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event == null) {
            throw new IllegalArgumentException("Event with ID=" + id + " not found");
        }
        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("The type of event cannot be null");
        }

        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID should be a positive number");
        }

        SpellEvent removedEvent = spellById.remove(id);
        if (removedEvent == null) {
            return;
        }

        String eventType = removedEvent.getEventType();
        spellsByType.computeIfPresent(eventType, (type, eventsList) -> {
            eventsList.removeIf(e -> e.getId() == id);
            return eventsList.isEmpty() ? null : eventsList;
        });

    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            System.out.println("No stored spell events");
            return;
        }

        System.out.println("All used of spells");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent event = entry.getValue();
            System.out.printf("[ID: %d, Type: %s, Action: %s]%n",
                    event.getId(),
                    event.getEventType(),
                    event.getAction());
        }
        System.out.println("All applications: " + spellById.size());
    }
}
