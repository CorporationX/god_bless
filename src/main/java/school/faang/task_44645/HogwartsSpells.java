package school.faang.task_44645;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, event);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = getSpellEventById(id);
        spellById.remove(id);

        List<SpellEvent> events = getSpellEventsByType(event.getEventType());
        if (events.size() > 1) {
            events.remove(event);
        } else {
            spellsByType.remove(event.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
