package school.faang.sprint_1.taskbjs244629;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellEventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, SpellEventType eventType) {
        requireNonNullOrThrow(eventType, "SpellEventType cannot be null");

        SpellEvent spellEvent = new SpellEvent(id, eventType);
        SpellEvent addedEvent = spellById.computeIfAbsent(id, key -> spellEvent);
        List<SpellEvent> eventsByType = spellsByType.computeIfAbsent(eventType, key -> new ArrayList<>());
        eventsByType.add(addedEvent);
        System.out.println("spell " + addedEvent.eventType().name() + " was added");
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        return requireNonNullOrThrow(spellEvent, "spell doesn't exists");
    }

    public List<SpellEvent> getSpellEventsByType(SpellEventType eventType) {
        List<SpellEvent> events = spellsByType.get(eventType);
        return requireNonNullOrThrow(events, "spell type doesn't exists");
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        requireNonNullOrThrow(event, "SpellEvent doesn't exist");
        List<SpellEvent> events = spellsByType.get(event.eventType());
        events.remove(event);
        return event;
    }

    public void printAllSpellEvents() {
        spellById.forEach((key1, value) -> System.out.println(value));
    }

    private <T> T requireNonNullOrThrow(T obj, String message) {
        if (obj == null) {
            throw new NoSuchElementException(message);
        }
        return obj;
    }
}
