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
            throw new NotFoundSpellEventIdException("Spell event with id = %d not found", id);
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType != null && !eventType.isBlank()) {
            return spellByType.get(eventType);
        } else {
            throw new NotFoundSpellEventTypeException("Spell event with type %s not found!", eventType);
        }

    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.get(id);
            if (spellByType.containsKey(spellEvent.getEventType())) {
                spellById.remove(id);
                //spellByType.remove(spellEvent.getEventType());
                spellByType.get(spellEvent.getEventType()).remove(spellEvent);
            } else {
                throw new NotFoundSpellEventTypeException("Spell event with type %s not found!", spellEvent.getEventType());
            }
        } else {
            String message = "SpellEvent with id = " + id + " does not exist";
            throw new NotFoundSpellEventIdException("Spell event with id = %d not found", id);
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
