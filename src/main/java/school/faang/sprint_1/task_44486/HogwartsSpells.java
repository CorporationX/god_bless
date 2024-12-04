package school.faang.sprint_1.task_44486;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    private void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new LinkedList<>()).add(spellEvent);
    }

    private SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    private List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.getOrDefault(eventType, new LinkedList<>());
    }

    private void deleteSpellEvent(int id) {
        SpellEvent removedSpellEvent = spellById.remove(id);
        spellByType.get(removedSpellEvent.getEventType()).remove(removedSpellEvent);
    }

    private void printAllSpellEvents() {
        for (var spellEvent : spellById.entrySet()) {

        }
    }
}
