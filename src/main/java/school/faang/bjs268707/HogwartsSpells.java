package school.faang.bjs268707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private int id = 1;
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        List<SpellEvent> spellEvents = spellByType.get(eventType);
        if (spellEvents == null) {
            spellEvents = new ArrayList<>();
            spellByType.put(eventType, spellEvents);
        }
        spellEvents.add(spellEvent);
        spellById.put(id, new SpellEvent(id, eventType, actionDescription));
        id++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType);
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
