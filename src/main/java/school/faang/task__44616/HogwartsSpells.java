package school.faang.task__44616;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private Map<Integer, SpellEvent> spellById = new HashMap<>();
    private Map<String, List<SpellEvent>> spellsByType = new HashMap<>();

    public void addSpellEvent(int id, String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, newSpellEvent);

        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newSpellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }


    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        SpellEvent spellEvent = spellById.get(id);

        if (spellEvent != null) {
            String eventType = spellEvent.getEventType();
            List<SpellEvent> eventList = spellsByType.get(eventType);
            if (eventList != null) {
                eventList.remove(spellEvent);
                if (eventList.isEmpty()) {  //если список пуст
                    spellsByType.remove(eventType);
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            SpellEvent event = entry.getValue();
            System.out.println("id: " + entry.getKey()
                    + ", Type: " + event.getEventType()
                    + ", Acton: " + event.getAction());
        }
    }

}
