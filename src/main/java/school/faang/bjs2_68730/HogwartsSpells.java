package school.faang.bjs2_68730;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
class HogwartsSpells {
    private static final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    protected static void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, spell -> new ArrayList<>()).add(spellEvent);
    }

    protected static SpellEvent getSpellEventById(Integer id) {
        var spellEvent = spellById.get(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("Заклинание с id %d отсутствует".formatted(id));
        }
        return spellEvent;
    }

    protected static List<SpellEvent> getSpellEventsByType(EventType eventType) {
        var spellEvents = spellsByType.get(eventType);
        if (spellEvents == null || spellEvents.isEmpty()) {
            throw new NoSuchElementException("Заклинание с eventType %s отсутствует".formatted(eventType));
        }
        return spellEvents;
    }

    protected static void deleteSpellEvent(Integer id) {
        var spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("Заклинание с id %d отсутствует".formatted(id));
        }
        var eventType = spellEvent.getEventType();
        var eventTypes = spellsByType.get(eventType);
        var indexes = generateIndexes(eventTypes);
        int index = indexes.get(spellEvent);
        eventTypes.remove(index);
    }

    protected static void printAllSpellEvents() {
        spellById.forEach((id, event) ->
                log.info("{} - {}", id, event));
    }

    protected static void printAllSpellsByType() {
        spellsByType.forEach((event, spell) ->
                log.info("{} - {}", event, spell));
    }

    private static Map<SpellEvent, Integer> generateIndexes(List<SpellEvent> spellEvents) {
        var indexes = new HashMap<SpellEvent, Integer>();
        spellEvents.forEach(event ->
                indexes.put(event, spellEvents.indexOf(event)));
        return indexes;
    }
}
