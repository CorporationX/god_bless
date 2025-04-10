package school.faang.bjs268707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private int id = 1;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, SpellEvent> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        spellByType.put(eventType, new SpellEvent(id, eventType, actionDescription));
        spellById.put(id, new SpellEvent(id, eventType, actionDescription));
        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            if (entry.getKey().equals(id)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        List<SpellEvent> events = new ArrayList<>();
        for (Map.Entry<String, SpellEvent> entry : spellByType.entrySet()) {
            if (entry.getKey().equals(eventType)) {
                events.add(entry.getValue());
            }
        }
        return events;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = getSpellEventById(id);
        if (spellEvent.getId() == id) {
            spellById.remove(spellEvent.getId());
            spellByType.remove(spellEvent.getEventType());
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("Id: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}
