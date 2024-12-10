package school.faang.task_44644;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

public class HogwartsSpells {
    private static final Logger logger = LoggerFactory.getLogger(HogwartsSpells.class);
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<EventType, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(SpellEvent spellEvent) {
        spellById.put(spellEvent.getId(), spellEvent);
        spellsByType.putIfAbsent(spellEvent.getEventType(), new ArrayList<>());
    }

    public void getSpellEventById(int id) {
        SpellEvent value = spellById.get(id);
        logger.info("Getting spell by id: {}", id);
        if (value == null) {
            throw new IllegalArgumentException("id not found");
        } else {
            logger.info("The spell: {} found for id: {}", value, id);
        }
    }

    public void getSpellEventsByType(EventType eventType) {
        List<SpellEvent> events = spellsByType.get(eventType);
        if (events == null) {
            throw new IllegalArgumentException("Spell not found");
        } else {
            logger.info("Getting spell by type: {}", eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent value = spellById.remove(id);
        if (value == null) {
            throw new IllegalArgumentException("Spell not found");
        } else {
            logger.info("Spell: {} by id: {} removed", value, id);
        }
        printAllSpellEvents();
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            logger.info("id: {} for spell: {}", entry.getKey(), entry.getValue());
        }
    }
}