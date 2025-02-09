package school.faang.sprint1.collections.catchevents;

import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventIdException;
import school.faang.sprint1.collections.catchevents.exceptions.NotFoundSpellEventTypeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final String spellTypeErrorMessage = "Заклинание типа '%s' не обнаружено";
    private final String spellIdErrorMessage = "Заклинание с id = %d не обнаружено";
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
            throw new NotFoundSpellEventIdException(spellIdErrorMessage, id);
        }
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        if (eventType != null && !eventType.isBlank()) {
            if (spellByType.containsKey(eventType)) {
                return spellByType.get(eventType);
            } else {
                throw new NotFoundSpellEventTypeException(spellTypeErrorMessage, eventType);
            }
        } else {
            throw new NotFoundSpellEventTypeException(spellTypeErrorMessage, eventType);
        }
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.get(id);
            String eventType = spellEvent.getEventType();
            if (spellByType.containsKey(eventType)) {
                spellById.remove(id);
                List<SpellEvent> spellEvents = spellByType.get(eventType);
                spellEvents.remove(spellEvent);
                if (spellEvents.size() == 0) {
                    spellByType.remove(eventType);
                }
            } else {
                throw new NotFoundSpellEventTypeException(spellTypeErrorMessage, spellEvent.getEventType());
            }
        } else {
            throw new NotFoundSpellEventIdException(spellIdErrorMessage, id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent spellEvent = entry.getValue();
            System.out.print("id = " + spellEvent.getId());
            System.out.print(", event type = " + spellEvent.getEventType());
            System.out.println(", spell action = " + spellEvent.getAction());
        }
    }
}
