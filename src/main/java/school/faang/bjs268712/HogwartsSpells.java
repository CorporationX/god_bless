package school.faang.bjs268712;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map.Entry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent event = new SpellEvent(eventType, actionDescription);
        spellById.put(event.getId(), event);
        spellsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        log.info("Get spell event by id: " + id + ": " + spellById.get(id).getEventType());
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedEvent = spellById.remove(id);
        if (removedEvent == null) {
            log.error("Invalid spell id: {}", id);
            throw new IllegalArgumentException("Invalid spell id: " + id);
        }

        List<SpellEvent> events = spellsByType.get(removedEvent.getEventType());
        if (events != null) {
            events.removeIf(event -> event.getId() == id);
            if (events.isEmpty()) {
                spellsByType.remove(removedEvent.getEventType());
            }
        }
        log.info("Removed spell event by id: " + id + ": " + removedEvent.getEventType());
    }

    public void printAllSpellEvents() {
        for (Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            log.info("Printing all spell event " + entry.getKey());
            SpellEvent event = entry.getValue();
            log.info(event.getEventType());
        }
    }
}