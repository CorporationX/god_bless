package school.faang.BJS2_79698;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(RandomGenerator.getDefault().nextInt(30), eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removed = spellById.remove(id);
        if (removed == null) return;

        spellsByType.computeIfPresent(removed.getEventType(), (type, events) -> {
            events.removeIf(e -> e.getId() == id);
            return events.isEmpty() ? null : events;
        });
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, event) -> {
            System.out.println(event);
        });
    }
}
