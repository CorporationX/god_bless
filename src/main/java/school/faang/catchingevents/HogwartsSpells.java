package school.faang.catchingevents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<EventType, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(EventType eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);
        spellById.put(spellEvent.getId(), spellEvent);

        spellByType
                .computeIfAbsent(eventType, spellEvents -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellByType(EventType eventType) {
        return spellByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.get(id);
        if (spellEvent == null) {
            return;
        }
        List<SpellEvent> spellEvents = spellByType.get(spellEvent.getEventType());
        spellEvents.remove(spellEvent);
        if (spellEvents.isEmpty()) {
            spellByType.remove(spellEvent.getEventType());
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
