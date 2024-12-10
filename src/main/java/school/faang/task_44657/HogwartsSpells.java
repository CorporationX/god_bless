package school.faang.task_44657;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        if (spellById.containsKey(id)) {
            log.warn("Spell with ID {} already exists!", id);
            return;
        }

        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, newSpellEvent);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newSpellEvent);
        log.info("Added spell: ID = {}, Type = {}, Action = {}", id, eventType, actionDescription);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent event = spellById.get(id);
        if (event != null) {
            log.info("Retrieved spell by ID {}: {}", id, event);
        } else {
            log.warn("Spell with ID {} not found", id);
        }

        return event;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> events = spellsByType.getOrDefault(eventType, Collections.emptyList());
        log.info("Retrieved {} spells of type '{}'", events.size(), eventType);

        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removedEvent = spellById.remove(id);
        if (removedEvent != null) {
            spellsByType.get(removedEvent.getEventType()).remove(removedEvent);
            log.info("Deleted spell with ID {}: {}", id, removedEvent);
        } else {
            log.warn("Attempted to delete non existing spell with ID {}", id);
        }
    }

    public void printAllSpellEvents() {
        log.info("Printing all spell events:");
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Type: " + entry.getValue().getEventType()
                    + ", Action: " + entry.getValue().getAction());
        }
    }
}
