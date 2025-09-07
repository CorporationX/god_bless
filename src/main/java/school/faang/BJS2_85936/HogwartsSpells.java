package school.faang.BJS2_85936;

import java.util.*;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int id = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(id++, eventType, actionDescription);
        spellById.put(id, newEvent);
        List<SpellEvent> spells = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spells.add(newEvent);
        spellsByType.put(eventType, spells);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent deletedEvent = spellById.remove(id);
        spellsByType.remove(deletedEvent.getEventType());
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> e : spellById.entrySet()) {
            SpellEvent event = e.getValue();
            System.out.print(event);
        }
    }
}
