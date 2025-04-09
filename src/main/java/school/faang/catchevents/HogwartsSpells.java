package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    Map<Integer, SpellEvent> spellById = new HashMap<>();
    Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    int currentId = 1;


    public void addSpellEvent(String eventType, String actionDescription) {
        int id = currentId++;
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);
        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        if (spellById.get(id) == null) {
            System.out.println("Событие заклинания отсутствует");
        }
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            String eventType = spellEvent.getEventType();
            List<SpellEvent> event = spellsByType.get(eventType);
            if (event != null) {
                event.remove(spellEvent);
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}