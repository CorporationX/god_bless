package school.faang.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<EventType, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        List<SpellEvent> spellEvents;
        if (spellByType.containsKey(eventType)) {
            spellEvents = spellByType.get(eventType);
        } else {
            spellEvents = new ArrayList<>();
        }
        spellEvents.add(spellEvent);
        spellByType.put(eventType, spellEvents);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(EventType eventType) {
        return spellByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        List<SpellEvent> spellEvents;
        if (spellByType.containsKey(spellEvent.getEventType())) {
            spellEvents = spellByType.get(spellEvent.getEventType());
            spellEvents.remove(spellEvent);
            spellByType.put(spellEvent.getEventType(), spellEvents);
        }
        spellById.remove(id);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println("=".repeat(30));
            System.out.println("ID: " + spellEvent.getKey() +
                    "\nEvent type: " + spellEvent.getValue().getEventType() +
                    "\nAction: " + spellEvent.getValue().getAction());
        }
    }
}
