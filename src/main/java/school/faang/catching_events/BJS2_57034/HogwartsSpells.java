package school.faang.catching_events.BJS2_57034;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HogwartsSpells {
    private static final Logger LOGGER = LoggerFactory.getLogger(HogwartsSpells.class);

    private int id = 0;

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        if (eventType.isBlank() || actionDescription.isBlank()) {
            LOGGER.warn("Event type or action description is blank");
            throw new IllegalArgumentException("Event type and action description cannot be empty or blank");
        }

        int uniqueId = ++id;
        SpellEvent spellEvent = new SpellEvent(uniqueId, eventType, actionDescription);
        spellById.put(uniqueId, spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);

        LOGGER.info("Added spell event for type {} and description {}", eventType, actionDescription);
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent != null) {
            LOGGER.info("Found spell event for id {}", id);
            return spellEvent;
        } else {
            LOGGER.info("No spell event found for id {}", id);
            throw new NoSuchElementException("No spell event found for id " + id);
        }
    }

    public List<SpellEvent> getSpellEventsByType(@NonNull String eventType) {
        if (eventType.isBlank()) {
            LOGGER.warn("{} is blank", eventType);
            throw new IllegalArgumentException(eventType + " is blank");
        }

        List<SpellEvent> spellEvents = spellsByType.get(eventType);

        if (spellEvents != null && !spellEvents.isEmpty()) {
            LOGGER.info("Found spell event for type {}", eventType);
            return spellEvents;
        } else {
            LOGGER.info("No spell event found for type {}", eventType);
            throw new NoSuchElementException("No spell event found for type " + eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent == null) {
            LOGGER.info("No spell event found for id {}", id);
            return;
        }
        String eventType = spellEvent.eventType();
        List<SpellEvent> spellEvents = spellsByType.get(eventType);

        if (spellEvents != null) {
            spellEvents.remove(spellEvent);
            if (spellEvents.isEmpty()) {
                spellsByType.remove(eventType);
            }
        }
        spellById.remove(id);

        LOGGER.info("Removed spell event for id {}", id);
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.printf("ID: %d, type: %s, action: %s%n",
                    entry.getKey(), entry.getValue().eventType(), entry.getValue().action());
        }
        LOGGER.info("All spell events have been printed");
    }
}
