package school.faang.bjs2_56978;

import lombok.ToString;

import java.util.*;

@ToString
public class HogwartsSpells {
    private int generateId = 1;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(generateId, eventType, actionDescription);
        spellById.put(generateId, newEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newEvent);
        generateId++;
    }

    public SpellEvent getSpellEventById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Not valid id");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType) || eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Spell with eventType " + eventType + " not found");
        }
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Not valid id");
        }
        SpellEvent removedSpellEvent = spellById.remove(id);
        if (removedSpellEvent != null) {
            List<SpellEvent> spellEvents = spellsByType.get(removedSpellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(removedSpellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            int key = entry.getKey();
            SpellEvent value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
