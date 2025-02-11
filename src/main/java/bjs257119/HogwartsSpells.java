package bjs257119;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int globalId = 0;
    private final Logger logger = LoggerFactory.getLogger(HogwartsSpells.class);

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(++globalId, eventType, actionDescription);
        spellById.putIfAbsent(spellEvent.getId(), spellEvent);

        spellsByType.computeIfPresent(eventType,
                (eventTypeInMap, spellEventsInMap) -> {
                    List<SpellEvent> spellEvents = spellsByType.get(eventTypeInMap);
                    spellEvents.add(spellEvent);
                    return spellEvents;
                });
        spellsByType.computeIfAbsent(eventType,
                (eventTypeInMap) -> {
                    ArrayList<SpellEvent> spellEvents = new ArrayList<>();
                    spellEvents.add(spellEvent);
                    return spellEvents;
                });
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.getOrDefault(id, new SpellEvent(0, null, null));
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent removed = spellById.remove(id);
        if (removed != null) {
            List<SpellEvent> events = spellsByType.get(removed.getEventType());
            if (events != null) {
                events.remove(removed);
            }
        }
    }

    public void printAllSpellEvents() {
        spellById.forEach((key, value) -> logger.info("ID: {}, Event type: {}, Action: {}",
                value.getId(), value.getEventType(), value.getAction()));
    }
}
