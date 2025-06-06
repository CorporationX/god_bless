package school.faang.events;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int lastId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        var id = lastId++;
        var event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellByType.putIfAbsent(eventType, new ArrayList<>());
        spellByType.get(eventType).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(@NonNull String type) {
        var spellEvents = spellByType.get(type);
        if (spellEvents == null) {
            System.out.printf("SpellEvents not found by type '%s'", type);
            return List.of();
        }
        return spellEvents;
    }

    public void deleteSpellEvent(@NonNull Integer id) {
        var event = spellById.remove(id);
        if (event != null) {
            spellByType.get(event.eventType()).remove(event);
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
