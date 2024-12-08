package school.faang.task_44575;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        if (spellsByType.containsKey(eventType)) {
            List<SpellEvent> spellEventList =  spellsByType.get(eventType);
            spellEventList.add(spellEvent);
        } else {
            List<SpellEvent> spellEventList =  new ArrayList<>();
            spellEventList.add(0, new SpellEvent(id, eventType, actionDescription));
            spellsByType.put(eventType, spellEventList);
        }
    }

    public String getSpellEventById(int id) {
        return spellById.get(id).getEventType();
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        if (spellById.containsKey(id)) {
            spellById.remove(id);
        } else {
            System.out.println("SpellEvent with id = " + id + " not found");
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ". EventType: " + entry.getValue().getEventType()
                    + ". Action: " + entry.getValue().getAction());
        }
    }
}
