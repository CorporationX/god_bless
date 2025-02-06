package school.BJS57042;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
    ArrayList<Integer> spellIds = new ArrayList<>();

    public void addSpellEvent(String eventType, String action) {
        int id = 0;
        SpellEvent spellEvent = new SpellEvent(id, eventType, action);

        for (Integer usedId : spellById.keySet()) {
            if (!spellIds.contains(usedId)) {
                spellIds.add(usedId);
            }
            spellEvent.setId(spellIds.get(spellIds.size() - 1));
            System.out.println("last used id: " + spellIds.get(spellIds.size() - 1));
        }
        spellById.put(id, spellEvent);
        System.out.println("spellEvent add: " + spellEvent);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(spellEvent);
        System.out.println(" type : " + eventType + " | | " + spellsByType);

    }

    public void getSpellEventById(int id) {
        System.out.println("Your spell Event ----> " + spellById.get(id));
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteSpellEvent(int id) {
        System.out.println("Your spell Event ----> " + spellById.get(id));
        if (spellById.containsKey(id)) {
            SpellEvent spellEvent = spellById.remove(id);
            spellIds.remove(id);
            List<SpellEvent> events = spellsByType.get(spellEvent.getEventType());
            if (events != null) {
                events.remove(spellEvent);
                System.out.println("delete event successfully ");
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
