package school.faang.task_44559;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_44559.entity.SpellEvent;
import school.faang.task_44559.entity.SpellType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HogwartsSpells {
    private static final Logger log = LoggerFactory.getLogger(HogwartsSpells.class);
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<SpellType, List<SpellEvent>> spellByType = new HashMap<>();


    public Boolean addSpellEvent(int id, SpellType eventType, String actionDescription) {
        if (eventType == null && actionDescription == null) {
            throw new IllegalArgumentException("Event type and action description cannot be null");
        }
        //не перезаписываем во избежания ошибки случайного ввода
        if (spellById.containsKey(id)) {
            throw new IllegalArgumentException("Event id " + id + " already exists");
        }
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);

        List<SpellEvent> spells = spellByType.computeIfAbsent(eventType, k -> new ArrayList<>());
        spells.add(spellEvent);
        return true;
    }

    public SpellEvent getSpellEventById(int id) {
        return Optional.of(spellById.get(id))
                .orElseThrow(() -> new IllegalArgumentException("No such spell event"));
    }

    public List<SpellEvent> getSpellsByType(SpellType eventType) {
        if (spellByType.containsKey(eventType)) {
            return spellByType.get(eventType);
        }
        throw new IllegalArgumentException("No such spell event");
    }

    public Boolean deleteSpellEvent(int id) {
        SpellEvent spellEventToDelete = spellById.get(id);
        if (spellEventToDelete == null) {
            log.info("No such spell event");
            return false;
        }
        spellByType.get(spellEventToDelete.getType()).remove(spellEventToDelete);
        spellById.remove(id);
        return true;
    }

    public void printAllSpellEvents() {
        System.out.println("=== All Spell Events by ID ===");
        spellById.forEach((id, event) ->
                System.out.printf("ID: %d | Type: %s | Data: %s%n", id, event.getType(), event.getDescription())
        );
    }
}
