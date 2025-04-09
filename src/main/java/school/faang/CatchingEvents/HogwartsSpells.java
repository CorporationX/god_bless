package school.faang.CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int spellId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        spellId++;
        SpellEvent spellEvent = new SpellEvent(spellId, eventType, actionDescription);
        spellById.put(spellId, spellEvent);
        spellsByType.computeIfAbsent(eventType, e -> new ArrayList<>()).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, null);
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            String eventTypeById = spellById.get(id).getEventType();
            if (spellsByType.get(eventTypeById).size() == 1) {
                spellsByType.remove(eventTypeById);
            } else {
                spellsByType.get(eventTypeById).remove(spellById.get(id));
            }
            spellById.remove(id);
        }
    }

    public void printAllSpellEvents() {
        for (SpellEvent spellEvent : spellById.values()) {
            System.out.println(spellEvent);
        }
    }
}
