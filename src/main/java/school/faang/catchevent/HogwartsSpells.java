package school.faang.catchevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(Integer id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);
        spellById.put(id, spellEvent);
        List<SpellEvent> spellEventsList = spellsByType.getOrDefault(eventType, new ArrayList<>());
        spellEventsList.add(spellEvent);
        spellsByType.put(eventType, spellEventsList);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellEvent = spellById.remove(id);
        if (spellEvent != null) {
            List<SpellEvent> listEvents = spellsByType.get(spellEvent.getEventType());
            if (listEvents != null) {
                listEvents.remove(spellEvent);
                if (listEvents.isEmpty()) {
                    spellsByType.remove(spellEvent.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry);
        }
    }
}
