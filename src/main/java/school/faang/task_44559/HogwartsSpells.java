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


    public Boolean addSpellEvent(SpellEvent spellEvent) {
        if (spellById.containsKey(spellEvent.getId())) {
            throw new IllegalArgumentException("Event id " + spellEvent.getId() + " already exists");
        }

        spellById.put(spellEvent.getId(), spellEvent);

        List<SpellEvent> spells = spellByType.computeIfAbsent(spellEvent.getType(), k -> new ArrayList<>());
        spells.add(spellEvent);
        return true;
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent spellEvent = spellById.get(id);
        return Optional.ofNullable(spellEvent)
                .orElseThrow(() -> new IllegalArgumentException("No such spell event"));
    }

    public List<SpellEvent> getSpellsByType(SpellType eventType) {
        if (spellByType.containsKey(eventType)) {
            return spellByType.get(eventType);
        }
        throw new IllegalArgumentException("No such spell event");
    }

    public void deleteSpellEvent(int id) {
        if (spellById.get(id) == null) {
            throw new IllegalArgumentException("No such spell event");
        }
        spellByType.get(spellById.get(id).getType()).remove(spellById.get(id));
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        System.out.println("=== All Spell Events by ID ===");
        spellById.forEach((id, event) ->
                System.out.printf("ID: %d | Type: %s | Data: %s%n", id, event.getType(), event.getDescription())
        );
    }
}
