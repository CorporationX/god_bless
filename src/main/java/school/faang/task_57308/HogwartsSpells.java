package school.faang.task_57308;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int currentId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (!(spellById.remove(id) == null)) {
            SpellEvent spellEvent = spellById.remove(id);
            if (spellEvent != null) {
                List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
                if (events != null) {
                    events.remove(spellEvent);
                }
            }
        } else {
            log.info("You are trying to remove a non-existent spell.");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            log.info(String.valueOf(entry.getValue()));
        }
    }
}
