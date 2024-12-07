package school.faang.task44690.service;

import school.faang.task44690.model.EventType;
import school.faang.task44690.model.SpellEvent;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(int id, EventType eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellByType.computeIfAbsent(eventType, init -> new ArrayList<>()).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent eventToDelete = spellById.get(id);
        List<SpellEvent> events = spellByType.get(eventToDelete.getEventType());
        events.removeIf(event -> event.getId().equals(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("All spell events:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("Spell: " + entry.getValue());
        }
    }
}
