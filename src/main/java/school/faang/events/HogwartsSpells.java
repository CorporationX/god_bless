package school.faang.events;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
@Getter
public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();
    private int lastId = 0;

    public void addSpellEvent(@NonNull String eventType, @NonNull String actionDescription) {
        if (isTypeUnknown(eventType)) {
            return;
        }
        var id = lastId++;
        var event = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, event);
        spellByType.putIfAbsent(eventType, new ArrayList<>());
        spellByType.get(eventType).add(event);
    }

    public SpellEvent getSpellEventById(int id) {
        var spellEvent = spellById.get(id);
        if (spellEvent == null) {
            System.out.println("No spell event found with id " + id);
            return SpellEvent.EMPTY;
        }
        return spellEvent;
    }

    public List<SpellEvent> getSpellEventsByType(@NonNull String type) {
        if (isTypeUnknown(type)) {
            return List.of();
        }
        var spellEvents = spellByType.get(type);
        if (spellEvents == null) {
            System.out.printf("SpellEvents not found by type '%s'", type);
            return List.of();
        }
        return spellEvents;
    }

    private boolean isTypeUnknown(String type) {
        if (!SpellEventType.getValuesSet().contains(type)) {
            System.out.printf("Type %s is unknown%n", type);
            return true;
        }
        return false;
    }

    public void deleteSpellEvent(@NonNull Integer id) {
        var event = spellById.remove(id);
        if (event != null) {
            System.out.printf("Deleted spell event by id: %s%n", event);
            var spellEvents = getSpellEventsByType(event.eventType());
            var removed = spellEvents.remove(event);
            if (removed) {
                System.out.printf("Deleted spell event by type: %s%n", event);
                if (spellEvents.isEmpty()) {
                    spellByType.remove(event.eventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (var entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
