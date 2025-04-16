package school.faang.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private HashMap<Integer, SpellEvent> spellById = new HashMap<>();
    private HashMap<String, List<SpellEvent>> spellByType = new HashMap<>();

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpell = new SpellEvent(eventType, actionDescription);
        spellById.put(newSpell.getId(), newSpell);
        spellByType.computeIfAbsent(eventType, value -> new ArrayList<>()).add(newSpell);
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellByType.get(eventType) != null ? spellByType.get(eventType) : new ArrayList<>();
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spellToRemove = spellById.remove(id);
        if (spellToRemove == null) {
            return;
        }
        spellByType.get(spellToRemove.getEventType()).remove(spellToRemove);
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> kv : spellById.entrySet()) {
            System.out.println(kv.getValue() + "\n");
        }
    }
}
