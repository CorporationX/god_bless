package school.faang.bjs_44565;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import java.util.*;

@Log
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HogwartsSpells {
    final Map<Integer, SpellEvent> spellById;
    final Map<String, List<SpellEvent>> spellsByType;

    public HogwartsSpells() {
        spellsByType = new HashMap<>();
        spellById = new HashMap<>();
    }

    public void addSpellEvent(int id, String eventType, String actionDescription) throws IllegalArgumentException {
        validateEventParameters(eventType, actionDescription);
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        List<SpellEvent> spellEvents = spellsByType.computeIfAbsent(spellEvent.getEventType(), k -> new ArrayList<>());
        spellEvents.add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) throws IllegalArgumentException {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException();
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spellEvents = spellsByType.get(eventType);
        if (spellEvents == null || spellEvents.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Collections.unmodifiableList(spellEvents);
    }

    public void deleteSpellEvent(int id) throws IllegalArgumentException {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException();
        }
        List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
        spellEvents.remove(spellEvent);
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((key, value) -> log.info(value.toString()));
    }

    private void validateEventParameters(String eventType, String actionDescription) {
        if (eventType == null || eventType.isEmpty() || actionDescription == null || actionDescription.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
