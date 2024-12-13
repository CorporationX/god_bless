package school.faang.sprint1.task_44648;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static school.faang.sprint1.task_44648.SpellEvent.EventTypes;

@NoArgsConstructor
@Slf4j
public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public SpellEvent addSpellEvent(int id, EventTypes eventType, String description) {
        if (spellById.containsKey(id)) {
            throw new IllegalArgumentException(String.format("This event with id %d is already present!", id));
        }

        SpellEvent eventToAdd = new SpellEvent(id, eventType, description);
        List<SpellEvent> eventsOfTypeList = spellsByType.computeIfAbsent(eventType.name(), evType -> new ArrayList<>());
        //check whether the event with this eventType and description is already present
        if (eventsOfTypeList.contains(eventToAdd)) {
            throw new IllegalArgumentException(String.format("The event %s is already present!", eventToAdd));
        }

        spellById.put(id, eventToAdd);
        eventsOfTypeList.add(eventToAdd);
        return eventToAdd;
    }

    public SpellEvent getSpellEventById(int id) {
        SpellEvent eventToReturn = spellById.get(id);
        if (eventToReturn == null) {
            throw new NoSuchElementException("No event found under this id");
        }

        return eventToReturn;
    }

    /**
     * returns an immutable copied list of all events by its type
     */
    public List<SpellEvent> getSpellEventsByType(EventTypes eventType) {
        List<SpellEvent> eventsOfType = spellsByType.get(eventType.name());
        if (eventsOfType == null || eventsOfType.isEmpty()) {
            throw new NoSuchElementException(String.format("No events of the event type %s has been added", eventType));
        }

        return List.copyOf(eventsOfType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent eventToDelete = spellById.remove(id);
        if (eventToDelete == null) {
            throw new NoSuchElementException(String.format("No event found under id %d", id));
        }

        spellsByType.get(eventToDelete.getEventType().name()).remove(eventToDelete);
    }

    public void printAllSpellEvents() {
        spellById.forEach((id, event) -> System.out.println(event));
    }

    public void clearAll() {
        spellById.clear();
        spellsByType.clear();
    }
}
