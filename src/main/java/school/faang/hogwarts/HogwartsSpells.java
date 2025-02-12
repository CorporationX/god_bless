package school.faang.hogwarts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellsById;
    private final Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellsById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.trim().isEmpty()) {
            throw new IllegalArgumentException("eventType cannot be null or empty");
        }
        if (actionDescription == null || actionDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("actionDescription cannot be null or empty");
        }

        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellsById.put(spellEvent.getId(), spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellsById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            events.removeIf(e -> e.getId() == id);
            if (events.isEmpty()) {
                spellsByType.remove(spellEvent.getEventType());
            }
        }
    }

    public void printAllSpellEvents() {
        if (spellsById.isEmpty()) {
            System.out.println("The spell library is empty");
        } else {
            for (Map.Entry<Integer, SpellEvent> entry : spellsById.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}

