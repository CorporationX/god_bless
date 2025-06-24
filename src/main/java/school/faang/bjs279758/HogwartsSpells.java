package school.faang.bjs279758;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int spellId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || eventType.trim().isEmpty()) {
            log.error("Event type cannot be null or empty");
            return;
        }
        int id = spellId++;
        SpellEvent event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
        log.info("Spell event added: " + event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public boolean deleteSpellEvent(int id) {
        SpellEvent event = spellById.remove(id);
        if (event != null) {
            List<SpellEvent> list = spellsByType.get(event.getEventType());
            if (list != null) {
                list.removeIf(spell -> spell.getId() == id);
                if (list.isEmpty()) {
                    spellsByType.remove(event.getEventType());
                }
            }
            log.info("Spell event with id deleted: " + id);
            log.info("Deleted spell: " + event);
            return true;
        } else {
            log.warn("Spell event not found: " + id);
            return false;
        }
    }

    public void printAllSpellEvents() {
        if (spellById.isEmpty()) {
            log.info("No spell event found");
            return;
        }
        spellById.values().forEach(spell -> log.info(spell.toString()));
    }
}
