package school.faang.bjs286886;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        if (eventType == null || actionDescription == null) {
            throw new IllegalArgumentException("eventType and actionDescription must not be null");
        }
        SpellEvent spellEvent = new SpellEvent(eventType, actionDescription);

        spellById.put(spellEvent.getId(), spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> spellEvents = spellsByType.get(spellEvent.getEventType());
            if (spellEvents != null) {
                spellEvents.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> spellEvent : spellById.entrySet()) {
            System.out.println(spellEvent.getValue());
        }
    }
}
