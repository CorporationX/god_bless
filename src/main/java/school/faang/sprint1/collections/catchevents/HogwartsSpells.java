package school.faang.sprint1.collections.catchevents;

import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventIdException;
import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventTypeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static int countId = 0;
    private Map<Integer, SpellEvent> spellById = new HashMap<Integer, SpellEvent>();
    private Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(countId++, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);
        if (!spellByType.containsKey(eventType)) {
            spellByType.put(eventType, new ArrayList<>());
        }
        spellByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.containsKey(id)) {
            return spellById.get(id);
        } else {
            throw new NotFoundSpellEventTypeException("SpellEvent with such event type does not exist");
        }

    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.get(id);
            if (spellByType.containsKey(spellEvent.getEventType())) {
                spellByType.remove(spellEvent.getEventType());
                spellById.remove(id);
            } else {
                throw new NotFoundSpellEventTypeException("SpellEvent with event type '" + spellEvent.getEventType() +
                        "' does not exist");
            }
        } else {
            String message = "SpellEvent with id = " + id + " does not exist";
            throw new NotFoundSpellEventIdException(message);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = spellById.get(entry.getKey());
            System.out.println("id = " + spellEvent.getId() + ", event type = " + spellEvent.getEventType()
            + ", spell action = " + spellEvent.getAction());
        }
    }
}
