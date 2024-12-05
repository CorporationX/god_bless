package school.faang.sprint_1.task_44439;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();


    void addSpellEvent(int id, String eventType, String actionDescription) {
        if (spellById.containsKey(id)) {
            System.out.printf("Spell %s with ID: %d is already exist. Choose another one", eventType, id);
            return;
        }
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    List<SpellEvent> getSpellEventByType(String eventType) {
        return spellsByType.get(eventType);
    }

    void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            int id = entry.getKey();
            String type = entry.getValue().getEventType();
            String action = entry.getValue().getAction();
            System.out.printf("ID: %d, Type: %s, Action: %s\n", id, type, action);
        }
    }
}
