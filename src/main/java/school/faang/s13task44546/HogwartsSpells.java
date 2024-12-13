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
        log.info("the spell event have added to the spell by id");

        spellsByType.putIfAbsent(eventType.name(), new ArrayList<>());
        spellsByType.get(eventType.name()).add(spellEvent);
        log.info("the spell event have added to the spells by type");
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
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, spellEvent) -> log.info("{}: {}", id, spellEvent));
    }
}