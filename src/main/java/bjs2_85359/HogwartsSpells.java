package bjs2_85359;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {

    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static int nextId = 0;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent spellEvent = new SpellEvent(++nextId, eventType, actionDescription);
        spellById.put(nextId, spellEvent);
        if (spellsByType.containsKey(eventType)) {
            spellsByType.get(eventType).add(spellEvent);
        } else {
            List<SpellEvent> spellEventList = new ArrayList<>();
            spellEventList.add(spellEvent);
            spellsByType.put(eventType, spellEventList);
        }
    }

    public SpellEvent getSpellEventById(int id) {
        boolean b = spellById.containsKey(id);
        if (b) {
            SpellEvent result = spellById.get(id);
            return result;
        }
        return null;
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        boolean b = spellsByType.containsKey(eventType);
        if (b) {
            List<SpellEvent> result = spellsByType.get(eventType);
            return result;
        }
        return null;
    }

    public void deleteSpellEvent(int id) {
        SpellEvent event = getSpellEventById(id);
        if (event != null) {
            spellsByType.get(spellById.get(id).eventType).remove(spellById.get(id));
            spellById.remove(id);
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, List<SpellEvent>> entry : spellsByType.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
