package school.faang.s13task44546;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        log.info("Added spell event with id {} to spellById map", id);

        List<SpellEvent> spellsOfType = spellsByType.computeIfAbsent(eventType.name(), k -> new ArrayList<>());
        spellsOfType.add(spellEvent);
        log.info("Added spell event with id {} and type {} to spellsByType map", id, eventType.name());
    }

    public void getSpellEventById(int id) {
        spellById.get(id);
    }

    public void getSpellEventsByType(EventType eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("the event type cannot be null");
        }
        spellsByType.get(eventType.name());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent == null) {
            throw new IllegalArgumentException("the spell event " + id + " have not found");
        }

        EventType spellType = spellEvent.getEventType();
        List<SpellEvent> spellsOfType = spellsByType.get(spellType.name());
        spellsOfType.removeIf(event -> event.getId() == id);
        if (spellsOfType.isEmpty()) {
            spellsByType.remove(spellType.name());
        }
        log.info("Deleted spell event with id {}", id);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> log.info("{}: {}", id, spellEvent));
    }
}