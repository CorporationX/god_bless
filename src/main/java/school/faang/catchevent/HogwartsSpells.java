package school.faang.catchevent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HogwartsSpells {
    private final Map<Integer, SpellEvent> spellById = new HashMap<>();
    private final Map<String, List<SpellEvent>> spellsByType = new HashMap<>();
    private int nextId = 1;

    public void addSpellEvent(String eventType, String actionDescription) {
        SpellEvent newSpell = new SpellEvent(nextId, eventType, actionDescription);
        spellById.put(nextId, newSpell);
        spellsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(newSpell);
        nextId++;
    }

    public SpellEvent getSpellEventById(int id) {
        return spellById.get(id);
    }

    public List<SpellEvent> getSpellEventsByType(String eventType) {
        return spellsByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void deleteSpellEvent(int id) {
        SpellEvent spell = spellById.remove(id);
        if (spell != null) {
            List<SpellEvent> spellsOfType = spellsByType.get(spell.getEventType());
            if (spellsOfType != null) {
                spellsOfType.remove(spell);
                if (spellsOfType.isEmpty()) {
                    spellsByType.remove(spell.getEventType());
                }
            }
        }
    }

    public void printAllSpellEvents() {
        for (Map.Entry<Integer, SpellEvent> entry : spellById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}