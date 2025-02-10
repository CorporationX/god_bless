package hogwarts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellsById;
    private Map<String, List<SpellEvent>> spellsByType;
    private int id;

    public HogwartsSpells() {
        spellsById = new HashMap<>();
        spellsByType = new HashMap<>();
        id = 1;
    }

    private void validateInput(String value, String errorMessage) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        validateInput(eventType, "Error: Event type cannot be null or empty.");
        validateInput(actionDescription, "Error: Action description cannot be null or empty.");

        int spellId = id++;
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);
        spellsById.put(spellId, spellEvent);
        spellsByType.computeIfAbsent(eventType, eventTypeKey -> new ArrayList<>()).add(spellEvent);
        System.out.println("Added spell event: " + spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removed = spellsById.remove(id);
        if (removed == null) {
            System.out.println("Spell event with Id " + id + " not found.");
            return;
        }

        spellsByType.computeIfPresent(removed.getEventType(), (eventType, eventsList) -> {
            eventsList.removeIf(event -> event.getId() == id);
            return eventsList.isEmpty() ? null : eventsList;
        });

        System.out.println("Deleted spell event: " + removed);
    }

    public void printAllSpellEvents() {
        if (spellsById.isEmpty()) {
            System.out.println("No spell events found.");
            return;
        }

        System.out.println("All spell events:");
        spellsById.forEach((id, event) -> System.out.println("Id " + id + " : " + event));
    }
}
