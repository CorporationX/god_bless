package school.faang.bjs_44565;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById  = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType  = new HashMap<>();


    public void addSpellEvent(int id, String eventType, String actionDescription) throws IllegalArgumentException {
        validateEventParameters(eventType, actionDescription);
        SpellEvent spellEvent = new SpellEvent(id, EventType.valueOfName(eventType), actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        List<SpellEvent> spellEvents = spellsByType.computeIfAbsent(spellEvent.getEventType().getName(),
                k -> new ArrayList<>());
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
