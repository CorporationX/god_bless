package bjs257119;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class HogwartsSpells {
    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    public static int globalId = 0;

    void addSpellEvent(String eventType, String actionDescription) {
        globalId++;
        int id = globalId;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        if (spellsByType.get(spellEvent.getEventType()) == null) {
            List<SpellEvent> spellEvents = new ArrayList<>();
            spellEvents.add(spellEvent);
            spellsByType.put(spellEvent.getEventType(), spellEvents);
        } else {
            spellsByType.get(spellEvent.getEventType()).add(spellEvent);
        }
    }

    SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
        spellEvents.remove(spellEvent);
        spellsByType.put(spellEvent.getEventType(), spellEvents);
        spellById.remove(id);
    }

    void printAllSpellEvents() {
        spellById.forEach((key, value) -> System.out.printf("ID: %d, Event type: %s, Action: %s %n",
                value.getId(), value.getEventType(), value.getAction()));
    }
}
