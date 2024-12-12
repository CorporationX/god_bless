package school.faang.bjs244699;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static final Logger logger = LoggerFactory.getLogger(HogwartsSpells.class);

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
        logger.info("Added SpellEvent: {}", spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        logger.info("Retrieved SpellEvent by ID {}: {}", id, spellEvent);
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> spellEvents = spellsByType.getOrDefault(eventType, new ArrayList<>());
        logger.info("Retrieved SpellEvents by type '{}': {}", eventType, spellEvents);
        return spellEvents;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                if (events.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
            logger.info("Deleted SpellEvent: {}", spellEvent);
        } else {
            logger.warn("No SpellEvent found with ID: {}", id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> event : spellById.entrySet()) {
            System.out.println(event.getValue());
        }
        logger.info("Printed all SpellEvents");
    }
}


