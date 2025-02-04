package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for managing spell events at Hogwarts.
 * Allows you to add, delete, search, and output spell events.
 */

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById  = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(nextId, eventType, actionDescription);
        spellById.put(nextId, spellEvent);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
        nextId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEventById(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.println("ID" + spellEvent.getId() +
                    ", Type: " + spellEvent.getEventType() +
                    ", Action: " + spellEvent.getAction());
        }
    }
}