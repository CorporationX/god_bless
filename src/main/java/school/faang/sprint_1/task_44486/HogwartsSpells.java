package school.faang.sprint_1.task_44486;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new TreeMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellByType.computeIfAbsent(eventType, key -> new LinkedList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.getOrDefault(eventType, new LinkedList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedSpellEvent = spellById.remove(id);
        spellByType.get(removedSpellEvent.getEventType()).remove(removedSpellEvent);
    }

    public void printAllSpellEvents() {
        for (var spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent.getKey() + " : " + spellEvent.getValue());
        }
    }
}
