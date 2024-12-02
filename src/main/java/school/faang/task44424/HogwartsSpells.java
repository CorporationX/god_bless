package school.faang.task44424;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellsById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        this.spellsById = new HashMap<>();
        this.spellsByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        if (eventType == null || actionDescription == null) {
            System.out.println("Event type is null!");
        } else {
            if (!spellsByType.containsKey(eventType)) {
                spellsByType.put(spellEvent.getEventType(), new ArrayList<>());
            }
            if (!spellsById.containsKey(id)) {
                spellsById.put(spellEvent.getId(), spellEvent);
                spellsByType.get(eventType).add(spellEvent);
            } else {
                System.out.println("Spell already exists!");
            }

            System.out.println("Added spell " + spellEvent + " to " + id);
        }
    }

    public SpellEvent getSpellsById(int id) {
        if (spellsById.containsKey(id)) {
            System.out.println("Spell by id " + spellsById.get(id) + "\n");
        } else {
            System.out.println("Spell by id " + id + " not found\n");
        }
        return spellsById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (!spellsByType.containsKey(eventType)) {
            System.out.println("Spell by type " + eventType + "not found\n");
        }
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedSpellEvent = getSpellsById(id);
        if (spellsById.containsKey(id)) {
            System.out.println("Removed spell " + spellsById.remove(id) + "\n");
            spellsByType.get(removedSpellEvent.getEventType()).remove(removedSpellEvent);
        } else {
            System.out.println("Spell by id " + id + " not found.\n");
        }
    }

    public void printAllSpellEvents() {
        if (!spellsById.isEmpty() && spellsByType != null) {
            for (var event : spellsById.values()) {
                System.out.println(event);
            }
        } else {
            System.out.println("No spell events found.\n");
        }
    }
}
