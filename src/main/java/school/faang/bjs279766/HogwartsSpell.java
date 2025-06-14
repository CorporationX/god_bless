package school.faang.bjs279766;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpell {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        addSpellEvent(eventType.getLabel(), actionDescription);
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        var spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        var spellEvents = spellsByType.get(spellEvent.getEventType());
        if (spellEvents != null) {
            spellEvents.add(spellEvent);
        } else {
            var events = new ArrayList<SpellEvent>();
            events.add(spellEvent);
            spellsByType.put(spellEvent.getEventType(), events);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        return getSpellEventsByType(eventType.getLabel());
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public SpellEvent deleteSpellEvent(int id) {
        var deletedSpellEvent = spellById.remove(id);
        if (deletedSpellEvent != null) {
            var spellEvents = spellsByType.get(deletedSpellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(deletedSpellEvent);
            }
        }
        return deletedSpellEvent;
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> System.out.println(spellEvent));
    }

    public void printSpellEventsByType(EventType eventType) {
        printSpellEventsByType(eventType.getLabel());
    }

    public void printSpellEventsByType(String eventType) {
        var spellEvents = getSpellEventsByType(eventType);
        spellEvents.forEach(System.out::println);
    }
}
