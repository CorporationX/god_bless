package school.faang.bjs2_79698;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Integer id = 1;

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id++, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, event -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removed = spellById.remove(id);
        if (removed != null) {
            spellsByType.computeIfPresent(removed.getEventType(), (type, events) -> {
                events.removeIf(event -> event.getId() == id);
                return events.isEmpty() ? null : events;
            });
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, event) -> {
            System.out.println(event);
        });
    }
}
