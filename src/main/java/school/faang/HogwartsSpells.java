package school.faang;

import lombok.ToString;

import java.util.*;

@ToString
public class HogwartsSpells {

    private List<SpellEvent> spellEventList = new ArrayList<>();
    private Map<UUID, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(newEvent.generatId(), newEvent);
        spellEventList.add(newEvent);
        spellsByType.put(eventType, spellEventList);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
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
        for (Map.Entry<UUID, SpellEvent> entry : spellById.entrySet()) {
            UUID key = entry.getKey();
            SpellEvent value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

    }
}
