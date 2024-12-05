package school.faang.task_44559;

import school.faang.task_44559.entity.SpellEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();


    public Boolean addSpellEvent(int id, String eventType, String actionDescription) {
        if (eventType == null && actionDescription == null) {
            System.out.println("Event type and action description is null");
            return false;
        }
        if (spellById.containsKey(id)) {
            return false;
        }
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spells = spellByType.get(eventType);
        if (spells == null) {
            spells = new ArrayList<>();
            spellByType.put(eventType, spells);
        }
        spells.add(spellEvent);
        return true;
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        }
        System.out.println("No such spell event");
        return null;
    }

    public List<SpellEvent> getSpellsByType(String eventType) {
        if (spellByType.containsKey(eventType)) {
            return spellByType.get(eventType);
        }
        System.out.println("No such spell event");
        return null;
    }

    public Boolean deleteSpellEvent(int id) {
        SpellEvent spellEventToDelete = spellById.get(id);
        if (spellEventToDelete == null) {
            System.out.println("No such spell event");
            return false;
        }
        for (Map.Entry<String, List<SpellEvent>> entry : spellByType.entrySet()) {
            entry.getValue().remove(spellEventToDelete);
        }
        spellById.remove(id);
        return true;
    }

    public void printAllSpellEvents() {
        System.out.println("=== All Spell Events by ID ===");
        if (spellById.isEmpty()) {
            System.out.println("No spell events found.");
        } else {
            for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
                int id = entry.getKey();
                SpellEvent event = entry.getValue();
                System.out.printf("ID: %d | Type: %s | Data: %s%n", id, event.getType(), event.getAction());
            }
        }
    }
}
