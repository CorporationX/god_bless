package school.faang.sprint1.task_44648;

import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static school.faang.sprint1.task_44648.SpellEvent.EVENT_TYPES;

@NoArgsConstructor
@Generated
public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public SpellEvent addSpellEvent(int id, String eventType, String actionDescription) {
        //adds new spell event to both maps
        if (!EVENT_TYPES.contains(eventType)) {
            throw new IllegalArgumentException("Unknown event type");
        }

        if (spellById.get(id) != null) {
            throw new IllegalArgumentException("This event with this id is already present in the system!");
        }

        SpellEvent eventToAdd = new SpellEvent(id, eventType, actionDescription);
        List<SpellEvent> eventsOfTypeList = spellsByType.get(eventType);

        if (eventsOfTypeList == null) {
            spellById.put(id, eventToAdd);
            eventsOfTypeList = new ArrayList<>();
            eventsOfTypeList.add(eventToAdd);
            spellsByType.put(eventType, eventsOfTypeList);
            return eventToAdd;
        }

        //check whether the event is already present
        if (eventsOfTypeList.contains(eventToAdd)) {
            throw new IllegalArgumentException("This event is already present in the system!");
        }

        spellById.put(id, eventToAdd);
        eventsOfTypeList.add(eventToAdd);
        spellsByType.put(eventType, eventsOfTypeList);
        return eventToAdd;
    }

    public SpellEvent getSpellEventById(int id) {
        //returns spell event by its id
        SpellEvent eventToReturn = spellById.get(id);
        if (eventToReturn == null) {
            throw new NoSuchElementException("No event found under this id");
        }

        return eventToReturn;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        //returns the list of all events by its type ( make it immutable from the outside )
        if (!EVENT_TYPES.contains(eventType)) {
            throw new IllegalArgumentException("Unknown event type");
        }

        List<SpellEvent> eventsOfType = spellsByType.get(eventType);
        if (eventsOfType == null || eventsOfType.isEmpty()) {
            throw new NoSuchElementException("No events of this event type has been added yet");
        }

        return List.copyOf(eventsOfType);
    }

    public void deleteSpellEvent(int id) {
        //removes event from both maps by using id
        SpellEvent eventToDelete = spellById.get(id);
        if (eventToDelete == null) {
            throw new NoSuchElementException("No event found under this id");
        }

        spellById.remove(id);
        spellsByType.get(eventToDelete.getEventType()).remove(eventToDelete);
    }

    public void printAllSpellEvents() {
        //prints info about all the events from the spellById map
        spellById.forEach((id, event) -> System.out.println(event));
    }
}
