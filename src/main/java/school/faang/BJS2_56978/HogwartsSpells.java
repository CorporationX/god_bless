package school.faang.BJS2_56978;

import lombok.ToString;

import java.util.*;

@ToString
public class HogwartsSpells {

    private List<SpellEvent> spellEventList = new ArrayList<>();
    private Map<UUID, SpellEvent> spellById = new HashMap<>();
    private Map<EvantType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EvantType eventType, String actionDescription) {
        SpellEvent newEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(newEvent.generatId(), newEvent);
        spellEventList.add(newEvent);
        spellsByType.put(eventType, spellEventList);
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
        for (Map.Entry<UUID, SpellEvent> entry : spellById.entrySet()) {
            UUID key = entry.getKey();
            SpellEvent value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

    }
}
