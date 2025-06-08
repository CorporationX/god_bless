package school.faang.bjs2_79787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private static Map<Integer, SpellEvent> spellById = new HashMap<>();
    private static Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private static Map<Integer, Integer> spellIndex = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpellEvent = new SpellEvent(SpellEvent.getCurrentSpellCount(), eventType, actionDescription);
        spellById.put(newSpellEvent.getId(), newSpellEvent);
        if (!spellsByType.containsKey(eventType)) {
            spellsByType.put(eventType, new ArrayList<>());
        }
        spellsByType.get(eventType).add(newSpellEvent);
        spellIndex.put(newSpellEvent.getId(), spellsByType.get(eventType).size() - 1);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.get(eventType);
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellToDelete = spellById.get(id);
        String eventType = spellToDelete.getEventType();

        spellById.remove(id);
        spellsByType.get(eventType).remove(spellIndex.get(id));
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

}
