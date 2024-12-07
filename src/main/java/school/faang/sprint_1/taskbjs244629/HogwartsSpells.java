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
        if (!eventsByType.contains(addedEvent)) {
            eventsByType.add(addedEvent);
        }
        requireNonNullOrThrow(addedEvent, "spell " + addedEvent.eventType().name() + " was added");
    }

    public SpellEvent getSpellEventById(int id) {
        return requireNonNullOrThrow(spellById.get(id), "spell doesn't exists");
    }

    public List<SpellEvent> getSpellEventsByType(SpellEventType eventType) {
        return requireNonNullOrThrow(spellsByType.get(eventType), "spell doesn't exists");
    }

    public SpellEvent deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        requireNonNullOrThrow(event, "SpellEvent doesn't exist");
        List<SpellEvent> events = spellsByType.get(event.eventType());
        if (events != null) {
            events.remove(event);
            if (events.isEmpty()) {
                spellsByType.remove(event.eventType());
            }
        }
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
