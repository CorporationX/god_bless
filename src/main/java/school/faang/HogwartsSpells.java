package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (!spellById.containsKey(id)) {
            throw new IllegalArgumentException("Spell with id " + id + " not found");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            throw new IllegalArgumentException("Spell with eventType " + eventType + " not found");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedSpellEvent = spellById.remove(id);
        if (removedSpellEvent != null) {
            if (spellsByType.containsKey(removedSpellEvent.getEventType())) {
                spellsByType.get(removedSpellEvent.getEventType()).remove(removedSpellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
