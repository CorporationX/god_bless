package school.faang.sprint1.taskbjs244396;

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
        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType.isBlank() || eventType == null) {
            throw new IllegalArgumentException();
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        SpellEvent deletedEvent = spellById.remove(id);
        spellsByType.get(deletedEvent.getEventType()).remove(deletedEvent);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry);
        }
    }
}
