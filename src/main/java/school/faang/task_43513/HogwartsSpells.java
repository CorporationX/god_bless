package school.faang.task_43513;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById;
    private Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        spellById = new HashMap<>();
        spellsByType = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        }

    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent.getKey() + " - " + spellEvent.getValue());
        }
    }
}
