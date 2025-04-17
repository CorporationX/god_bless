package school.faang.bjs2_68730;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();
    private final Map<SpellEvent, Integer> spellEventIndexes = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(counter.incrementAndGet(), eventType, actionDescription);
        this.spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.computeIfAbsent(eventType, spell -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(Integer id) {
        var spellEvent = this.spellById.get(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("Заклинание с id %d отсутствует".formatted(id));
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(EventType eventType) {
        var spellEvents = this.spellsByType.get(eventType);
        if (spellEvents == null || spellEvents.isEmpty()) {
            throw new NoSuchElementException("Заклинание с eventType %s отсутствует".formatted(eventType));
        }
        return spellEvents;
    }

    public void deleteSpellEvent(Integer id) {
        var spellEvent = this.spellById.remove(id);
        if (spellEvent == null) {
            throw new NoSuchElementException("Заклинание с id %d отсутствует".formatted(id));
        }
        EventType eventType = spellEvent.getEventType();
        List<SpellEvent> eventTypes = spellsByType.get(eventType);
        generateIndexes(eventTypes);
        int index = spellEventIndexes.get(spellEvent);
        eventTypes.remove(index);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, event) ->
                log.info("{} - {}", id, event));
    }

    public void printAllSpellsByType() {
        spellsByType.forEach((event, spell) ->
                log.info("{} - {}", event, spell));
    }

    private void generateIndexes(List<SpellEvent> spellEvents) {
        spellEvents.forEach(event ->
                spellEventIndexes.put(event, spellEvents.indexOf(event)));
    }
}
