package faang.school.godbless.task_44521;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        addSpellEventByType(spellEvent, eventType);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent deletedSpellEvent = spellById.get(id);
        if (deletedSpellEvent != null) {
            deleteSpellEventByType(deletedSpellEvent);
            spellById.remove(id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent.getKey() + " — " + spellEvent.getValue());
        }
    }

    private void addSpellEventByType(SpellEvent spellEvent, String eventType) {
        List<SpellEvent> spellEvents;
        if (spellsByType.containsKey(eventType)) {
            spellEvents = spellsByType.get(eventType);
            spellEvents.add(spellEvent);
        } else {
            spellEvents = new ArrayList<>();
            spellEvents.add(spellEvent);
            spellsByType.put(eventType, spellEvents);
        }
    }

    private void deleteSpellEventByType(SpellEvent deletedSpellEvent) {
        List<SpellEvent> spellEventsWithSpecificType = spellsByType.get(deletedSpellEvent.getEventType());
        if (spellEventsWithSpecificType != null) {
            int spellEventIndex = 0;
            for (SpellEvent spellEvent : spellEventsWithSpecificType) {
                if (spellEvent.equals(deletedSpellEvent)) {
                    break;
                }
                spellEventIndex++;
            }
            spellEventsWithSpecificType.remove(spellEventIndex);
        }
    }
}
