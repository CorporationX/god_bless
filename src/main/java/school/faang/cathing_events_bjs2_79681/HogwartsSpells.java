package school.faang.cathing_events_bjs2_79681;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HogwartsSpells {
    HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    HashMap<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 0;

    public int generateId() {
        return nextId++;
    }

    public void addSpellEvent(String eventType, String actionDescription) {
        int id = generateId();
        SpellEvent spellEvent = new SpellEvent(id, eventType, actionDescription);

        spellById.put(id, spellEvent);

        spellsByType.putIfAbsent(eventType, new ArrayList<>());
        spellsByType.get(eventType).add(spellEvent);
    }

    public SpellEvent getSpellEventById(int id) {
        System.out.printf("Событие: %s\n", spellById.get(id).toString());
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        System.out.printf("События: %s\n", spellsByType.get(eventType).toString());
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        spellById.remove(id);
        spellsByType.remove(spellById.get(id));
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            Integer id = entry.getKey();
            SpellEvent spellEvent = entry.getValue();
            System.out.printf("id: %d \t value: %s\n", id, spellEvent);
        }
    }
}
