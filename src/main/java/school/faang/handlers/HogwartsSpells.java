package school.faang.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || actionDescription == null) {
            throw new IllegalArgumentException("eventType и actionDescription не могут быть null");
        }

        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType
                .get(eventType)
                .add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            spellsByType.get(spellEvent.getEventType()).remove(spellEvent);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}