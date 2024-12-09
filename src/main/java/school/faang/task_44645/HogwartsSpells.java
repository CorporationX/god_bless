package school.faang.task_44645;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, event);

        List<SpellEvent> events = spellsByType.getOrDefault(eventType, new ArrayList<>());
        events.add(event);

        spellsByType.put(eventType, events);
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
