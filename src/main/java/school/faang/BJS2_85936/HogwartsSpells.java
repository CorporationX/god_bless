package school.faang.BJS2_85936;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(id++, eventType, actionDescription);
        spellById.put(id, newEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent deletedEvent = spellById.remove(id);
        spellsByType.get(deletedEvent.getEventType()).remove(deletedEvent);
    }

    public void printAllSpellEvents() {
        spellById.values().forEach(System.out::print);
    }
}
