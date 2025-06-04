package school.faang.catcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int countId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(countId, eventType, actionDescription);
        spellById.put(countId, spellEvent);
        spellsByType.computeIfAbsent(eventType, u -> new ArrayList<>()).add(spellEvent);
        countId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        for (var spellEntry : spellsByType.entrySet()) {
            List<SpellEvent> events = spellEntry.getValue();
            for (var spellEvent : events) {
                if (spellEvent.getId() == id) {
                    events.remove(spellEvent);
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (var spellEntry : spellById.entrySet()) {
            System.out.println(spellEntry.getValue());
        }
    }


}
